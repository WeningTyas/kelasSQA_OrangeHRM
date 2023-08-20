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

    //Locator @FindBy = apapun yg perlu xpath taruh di sini
    @FindBy(xpath = "//input[@name='username']")  // ← jangan pake titik koma ';'
    WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//button[contains(@class, 'login-button')]")
    WebElement btnLogin;

    @FindBy(xpath = "//h6[contains(@class, 'topbar-header-breadcrumb')]")
    WebElement txtDashboard;

//    @FindBy(xpath = "//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]")
    @FindBy(xpath = "//div[contains(@class, 'login-slot-wrapper')]//div[1]//div[1]//span[1]")
    WebElement txtRequiredUname;

//    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    @FindBy(xpath = "//span[contains(@class, 'error-message')]")
    WebElement txtRequiredPassword;

    @FindBy(xpath = "//p[contains(@class, 'alert-content-text')]")
    WebElement txtInvalidCredentials;

    //Custom methode yg berhubungan dgn Halaman Login
    public void login(String uname, String pass){
        username.sendKeys(uname);
        password.sendKeys(pass);
        btnLogin.click();
        System.out.println("Proses login");
    }

    // atau bisa juga pakai "this" klo parameter & nama web elementnya sama
    public void loginForm(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
        System.out.println("Proses login");
    }

    public void clean(){
        username.clear();
        password.clear();
    }

    public String getTextDashboard(){
        return txtDashboard.getText();
    }
    public String getTxtRequiredUname(){
        return txtRequiredUname.getText();
    }
    public String getTxtRequiredPassword(){
        return txtRequiredPassword.getText();
    }
    public String getTxtInvalidCredentials(){
        return txtInvalidCredentials.getText();
    }

}


/*
* Catatan:
* - Utk Negative test, biasanya akan dibuatkan methode dengan parameter
*   bagian ini belum dijelaskan apakah harus dipisah file antara negatif dan positifnya
* - Fungsi yg selalu dipakai (a.k.a aktif digunakan) biasanya ditaruh di Folder Pages
* - Di bagian ini juga bisa ditambahkan Methode return / Assert untuk verifikasi methode/hasil
*   atau bisa langsung di taruh di file main
* - Kebanyakan QA akan bekerja di bagian folder Pages dan file Main
*
* */


/*
* Bootstap tidak bisa dipakai (get) Xpathnya
* untuk mengatasinya perlu pakai getAttribute();
* karena returnnya trus & false
*
* */