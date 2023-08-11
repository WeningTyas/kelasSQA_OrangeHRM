package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPages {
    private WebDriver driver;

    public DashboardPages(){ //
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    //Locator @FindBy

    //Custom methode
}
