package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends TestBase  {


    // POM - object Repository

    By peerlessImage  = By.xpath("/html/body/div[1]/div/div/img");
    By welcome = By.xpath("//*[@id=\"about\"]/div[1]/div/h1");
    By footer = By.xpath("//*[@id=\"about\"]/footer/div");

    By userName = By.id("username");
    By password = By.id("password");
    By login = By.id("btnlogin");
    By title = By.id("logged_in");



    // Validate Page Tital
    public String validateLogingPageTital (){
        return driver.getTitle();
    }

    // Validate Peerless Image
    public boolean ValidatePeerlessLogo (){
        return driver.findElement(peerlessImage).isDisplayed();
    }

    // Validate Welcome massage
    public String ValidateWelcome () {
        return driver.findElement(welcome).getText();
    }
    // Validate Footer
    private boolean ValidateFooterText (){
        return driver.findElement(footer).isDisplayed();
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


    public HomePage loginToCRM(String strUserName,String strPasword ){
        this.setUserName(strUserName);
        this.setPassword(strPasword);
        this.clickLogin();

        return new HomePage();

        //System.out.println(getText());

    }

}
