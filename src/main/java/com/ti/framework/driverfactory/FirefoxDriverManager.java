package com.ti.framework.driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

public class FirefoxDriverManager implements IDriver{
    public FirefoxDriverManager() {
    }

    @Override
    public WebDriver createDriver() {
        System.out.println("Initializing Chrome Driver");
        WebDriverManager.getInstance(FIREFOX).setup();

        return new FirefoxDriver();
    }
}
