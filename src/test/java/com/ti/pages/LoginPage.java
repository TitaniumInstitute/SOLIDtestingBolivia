package com.ti.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Single Responsibility
public class LoginPage {
    @FindBy(id = "user_login") private WebElement txtUser;
    @FindBy(name = "pwd") private WebElement txtPassword;
    @FindBy(xpath = "//input[contains(@value, 'Log')]") private WebElement btnLogin;

    /*DIP
    * Depende de la abstracción y todo el código está escrito en la interfaz de WebDriver
    * para que el código pueda funcionar con cualquier implementación como FirefoxDriver, ChromeDriver, etc
    */
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public LoginCommand loginAs(String userName){
        return new LoginCommand(userName);
    }

    public class LoginCommand {
        private String userName;
        private String password;

        public LoginCommand(String userName){
            this.userName = userName;
        }

        public LoginCommand withPassword(String password){
            this.password = password;
            return  this;
        }

        public void login(){
            txtUser.sendKeys(userName);
            txtPassword.sendKeys(password);
            btnLogin.click();
        }
    }
}
