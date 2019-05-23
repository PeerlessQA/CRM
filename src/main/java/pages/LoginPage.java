package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends TestBase  {

    WebDriver driver = null;

    By welcome = By.id("about");
    By userName = By.id("username");
    By password = By.id("password");
    By login = By.id("btnlogin");
    By title = By.id("logged_in");


    // Get Welcome massage

    public String getwelcome () {
        return driver.findElement(welcome).getText();
    }

    //Set user name
    public void setUserName(String strUserName){
        driver.findElement(userName).sendKeys(strUserName);
    }

    //Set Password
    public void setPassword(String strPassword){
        driver.findElement(password).sendKeys(strPassword);
    }

    //Click Loging
    public void clickLogin( ){
        driver.findElement(login).click();
    }

    //Get the User name from Home Page
    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void loginToCRM(String strUserName,String strPasword ){
        this.setUserName(strUserName);
        this.setPassword(strPasword);
        this.clickLogin();

        //System.out.println(getText());

    }

}
