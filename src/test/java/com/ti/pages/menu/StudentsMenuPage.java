package com.ti.pages.menu;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StudentsMenuPage extends StudentAbstractMenuPage {

    WebDriver driver;
    public StudentsMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    public void goToEnrolledClass() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .visibilityOf(navEnrolledClasses));
        ((JavascriptExecutor)driver)
        .executeScript("arguments[0].click();",navEnrolledClasses);
    }

    @Override
    public void goToDashboard() {
        navDashboard.click();
    }

    @Override
    public void goToParents() {
        navParents.click();
    }

    @Override
    public void goToEvents() {
        navEvents.click();
    }

    @Override
    public void goToTransport() {
        navTransport.click();
    }
}
