package com.ti.pages.menu;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminMenuPage extends AdminAbstractMenuPage{
    WebDriver driver;
    public AdminMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    @Override
    public void goToTeachers() {

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .visibilityOf(navTeachers));
        ((JavascriptExecutor)driver)
                .executeScript("arguments[0].click();",navTeachers);
    }

    @Override
    public void goToStudents() {
        navStudents.click();
    }

    @Override
    public void goToClasses() {
        navClasses.click();
    }

    @Override
    public void goToAttendance() {
        navAttendance.click();
    }

    @Override
    public void goToNotify() {
        navNotify.click();
    }

    @Override
    public void goToGeneralSettings() {
        navGeneralSettings.click();
    }
}
