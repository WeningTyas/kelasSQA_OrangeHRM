package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    // 7. Isi methodenya
    private WebDriver driver;

    public LoginPage(){ // ← samakan dgn nama class
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //Locator @FindBy
    @FindBy(xpath = "//input[@name='username']")  // ← jangan pake titik koma ';'
    WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//button[contains(@class, 'login-button')]")
    WebElement btnLogin;

    //Custom methode
    public void login(){
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        btnLogin.click();
        System.out.println("klik login");
    }

    //Methode return / Assert

}
