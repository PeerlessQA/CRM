package testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import util.CustomObject;
import util.db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        waitForPageLoaded();
    }

    @Test (priority =2)
    public  void validatePageTitleTest(){
        String homePageTitle = homePage.validateLogingPageTital();
        Assert .assertEquals(homePageTitle , "Home Page" , "Home Page Title Not Matched -");
    }

    @Test (priority =1)
    public void validateUserNameTest() {
        String homePageUserName = homePage.validateLogedInUserName();
        Assert.assertEquals(homePageUserName, ("Welcome " + prop.getProperty("user")), "Loged In Unser Name Not Matched -");
    }


    @Test (priority =5)
     public  void validateLastCustomer () throws SQLException ,ClassNotFoundException
    {
        List<CustomObject>  myList = new ArrayList<CustomObject>();
        myList = homePage.validateCustomer();

        for(int i = 0; i < myList.size(); i++ ) {
            System.out.println(myList.get(i).DbValue + " = "+ (myList.get(i).PgValue));
           // System.out.println(myList.get(i).PgValue);
            //Assert.assertEquals(myList.get(i).DbValue,myList.get(i).PgValue," Customer Name not match.");
        }


        //System.out.println(names);
        //System.out.println(names[2]);
        //System.out.println(names[3]);

        //Assert.assertEquals(lastCustomert,());

      //  Assert.assertEquals(homePageUserName,("Welcome " + prop.getProperty( "user")),"Loged In Unser Name Not Matched -");
        //System.out.println(homePage.validateLastCustomer()+" 333333333333 --DONE");
    }






    @AfterClass
    private  void tearDown (){
        driver.quit();
    }


}
