package testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest(){
        super();
    }

    @BeforeClass
     public void setup (){
        initialization();
        loginPage = new LoginPage();
    }

    @Test (priority = 1)
    public void loginPageTitleTest(){
       String logingPageTital = loginPage.validateLogingPageTital();
        Assert.assertEquals(logingPageTital,"Peerless" ,"Login Page Title Not Matched" );
    }

    @Test (priority = 2)
    public void peerlesslogoTest(){
       boolean flag = loginPage.ValidatePeerlessLogo();
        Assert.assertTrue(flag);
    }

    @Test (priority = 3)
    public void welcomMessageText(){
        String welcom  = loginPage.ValidateWelcome();
        Assert.assertEquals(welcom,"Introducing the all new Peerless Web CRM" , "Login Page Welcom Message Not Matched");
    }

    @Test (priority = 4)
    public void logingtest(){
      homePage = loginPage.loginToCRM(prop.getProperty("username"),prop.getProperty("password"));
      //Assert.assertTrue(" In To CRM ");
    }

    @AfterClass
    private  void tearDown (){

        driver.quit();
    }

}
