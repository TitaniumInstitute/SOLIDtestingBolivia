package com.ti.pages.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class StudentAbstractMenuPage extends MenuAbstractPage{
    @FindBy(linkText = "Enrolled Classes") protected WebElement navEnrolledClasses;

    public abstract void goToEnrolledClass();
}
