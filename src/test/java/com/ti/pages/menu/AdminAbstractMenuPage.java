package com.ti.pages.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AdminAbstractMenuPage extends MenuAbstractPage{
    @FindBy(xpath = "(//*[contains(text(),'Teachers')])[2]") protected WebElement navTeachers;

    @FindBy(xpath = "(//*[contains(text(),'Students')])[2]") protected WebElement navStudents;

    @FindBy(xpath = "(//*[contains(text(),'Classes')])[2]") protected WebElement navClasses;

    @FindBy(xpath = "(//*[contains(text(),'Attendance')])[3]") protected WebElement navAttendance;

    @FindBy(xpath = "(//*[contains(text(),'Notify')])[2]") protected WebElement navNotify;

    @FindBy(xpath = "(//*[contains(text(),'General Settings')])[2]") protected WebElement navGeneralSettings;

    public abstract void goToTeachers();

    public abstract void goToStudents();

    public abstract void goToClasses();

    public abstract void goToAttendance();

    public abstract void goToNotify();

    public abstract void goToGeneralSettings();


}
