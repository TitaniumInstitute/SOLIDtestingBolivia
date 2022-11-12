package com.ti.testcases;

import com.ti.framework.driverfactory.LocalDriverFactory;
import com.ti.pages.LoginPage;
import com.ti.pages.menu.AdminAbstractMenuPage;
import com.ti.pages.menu.AdminMenuPage;
import com.ti.pages.menu.StudentAbstractMenuPage;
import com.ti.pages.menu.StudentsMenuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SOLIDTest {
    WebDriver driver;
    LoginPage loginPage;
    AdminAbstractMenuPage teacherPage;
    StudentAbstractMenuPage studentPage;
    String baseURL = "https://demosite.titaniuminstitute.com.mx/wp-admin/admin.php?page=sch-dashboard";
    String adminUserName = "admin";
    String adminPassword = "G3-ySzY%";
    String teacherUserName = "Christopherwpsp@yourdomain.com";
    String teacherPassword = "1bp^z@Dr^H0R@MeepKi2(MtR";
    String studentUserName = "Ernawpsp@yourdomain.com";
    String studentPassword = "Z5n%FyX^wyy@299HoNiwq@0)";

    public void preLoading(){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions
                            .invisibilityOf(driver.findElement(By.className("wpsp-preLoading"))));
        }catch (TimeoutException te){
            driver.navigate().refresh();
            preLoading();
        }
    }

    @BeforeMethod
    void setUp() throws Exception {
        LocalDriverFactory.getInstance().setDriver("Chrome");
        driver = LocalDriverFactory.getInstance().getDriver();
        driver.navigate().to(baseURL);

        /*
        *DIP
        * El cliente debe pasar la implementación de la interfaz WebDriver
        * a través del constructor LoginPage (controlador WebDriver) al
        * crear el objeto LoginPage.
        * */
        loginPage = new LoginPage(driver);
        teacherPage = new AdminMenuPage(driver);
        studentPage = new StudentsMenuPage(driver);
    }

    @AfterMethod
    void closeBrowser() {
        LocalDriverFactory.getInstance().removeDriver();
    }

    @Test()
    void solidAdminTest() throws InterruptedException {
        loginPage.loginAs(adminUserName).withPassword(adminPassword).login();
        Thread.sleep(2000);
    }

    @Test(enabled = true)
    void solidStudentMenuTest() throws InterruptedException {
        loginPage.loginAs(studentUserName).withPassword(studentPassword).login();
        preLoading();
        studentPage.goToEnrolledClass();
        Thread.sleep(2000);
    }

    @Test(enabled = true)
    void solidTeacherMenuTest() throws InterruptedException {
        loginPage.loginAs(teacherUserName).withPassword(teacherPassword).login();
        preLoading();
        teacherPage.goToTeachers();
        Thread.sleep(2000);
    }
}
