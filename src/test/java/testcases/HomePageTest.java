package testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest (){

         super();
     }

    @BeforeClass
    public void setup (){
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.loginToCRM(prop.getProperty("username"),prop.getProperty("password"));


    }

    @Test (priority =2)
    public  void validatePageTitleTest(){
        String homePageTitle = homePage.validateLogingPageTital();
        Assert .assertEquals(homePageTitle , "Home Page" , "Home Page Title Not Matched -");
    }

    @Test (priority =1)
    public void validateUserNameTest(){
        String homePageUserName = homePage.validateLogedInUserName();
        Assert.assertEquals(homePageUserName,("Welcome " + prop.getProperty( "user")),"Loged In Unser Name Not Matched -");
    }


    @AfterClass
    private  void tearDown (){
        driver.quit();
    }


}
