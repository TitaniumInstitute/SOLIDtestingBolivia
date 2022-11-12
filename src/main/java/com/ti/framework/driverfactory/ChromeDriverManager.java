package com.ti.framework.driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class ChromeDriverManager implements IDriver{
    public ChromeDriverManager() {
    }

    @Override
    public WebDriver createDriver() {
        System.out.println("Initializing Chrome Driver");
        WebDriverManager.getInstance(CHROME).setup();

        return new ChromeDriver();
    }
}
