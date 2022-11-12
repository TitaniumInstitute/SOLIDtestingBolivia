package com.ti.pages.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class MenuAbstractPage {
    @FindBy(xpath = "(//*[contains(text(),'Dashboard')])[4]") protected WebElement navDashboard;

    @FindBy(xpath = "(//*[contains(text(),'Parents')])[2]") protected WebElement navParents;

    @FindBy(xpath = "(//*[contains(text(),'Events')])[2]") protected WebElement navEvents;

    @FindBy(xpath = "(//*[contains(text(),'Transport')])[2]") protected WebElement navTransport;

    public abstract void goToDashboard();

    public abstract void goToParents();

    public abstract void goToEvents();

    public abstract void goToTransport();


}
