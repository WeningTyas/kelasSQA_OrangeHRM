package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.General;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//8. Bikin ini ↓
public class MainApp {

    static WebDriver driver;

    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Masuk URL");

        LoginPage loginPage = new LoginPage();
        loginPage.login("Admin", "admin123");
        loginPage.getTextDashboard();

        System.out.println("Test Login");

        General.delay(3);
        DriverSingleton.closeObjectInstance();
        System.out.println("Exit");
    }
}


// ← ↑ → ↓ ↔ ↕