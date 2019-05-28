package testcases;

import base.TestBase;
import net.bytebuddy.implementation.bind.annotation.Super;
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
       String tital = loginPage.validateLogingPageTital();
        Assert.assertEquals(tital,"Peerless");
    }

    @Test (priority = 2)
    public void peerlesslogoTest(){
       boolean flag = loginPage.ValidatePeerlessLogo();
        Assert.assertTrue(flag);
    }

    @Test (priority = 3)
    public void logingtest(){
      homePage = loginPage.loginToCRM(prop.getProperty("username"),prop.getProperty("password"));
    }



    @AfterClass
    private  void tearDown (){
        driver.quit();
    }



}
