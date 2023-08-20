package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.General;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage();
    }

    @AfterClass
    public void finish(){
        General.delay(3);
        DriverSingleton.closeObjectInstance();
    }
    @BeforeMethod
    public void refresh(){
        General.refresh(driver);
        General.delay(3);
    }

    //==== Positive Test ===//
    @Test (priority = 4)
    public void validLoginTest(){
        loginPage.loginForm("Admin", "admin123");
        String actual = loginPage.getTextDashboard();
        Assert.assertEquals(actual, "Dashboard");
        System.out.println("Berhasil login!");
    }

    //==== Negative Test ===//
    @Test (priority = 3)
    public void testLoginInvalidCredentials(){
        loginPage.login("Admin", "admin1234");
        String actual = loginPage.getTxtInvalidCredentials();
        Assert.assertEquals(actual, "Invalid credentials");
        System.out.println("Salah masukkan user login");
    }
    @Test (priority = 2)
    public void testLoginWithoutUname(){
        loginPage.login("", "admin123");
        String actual = loginPage.getTxtRequiredUname();
        Assert.assertEquals(actual, "Required");
        System.out.println("Login tanpa uname");
        loginPage.clean(); // ← bisa pakai clear()
    }

    @Test (priority = 1)
    public void testLoginWithoutUPassword(){
        loginPage.login("Admin", "");
        String actual = loginPage.getTxtRequiredPassword();
        Assert.assertEquals(actual, "Required");
        System.out.println("Login tanpa password");
        General.refresh(driver); // ← bisa juga pakai refresh,
        // tp ini ga bisa digeneralisir, karena ga semua web bisa kosong lagi pas direfresh
    }
}
