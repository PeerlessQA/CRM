package pages;

import base.TestBase;
import org.openqa.selenium.By;

public class HomePage extends TestBase {



    By logedInUser = By.id("logged_in");
    //Buttons
    By siginOut = By.id("lbtnSignOut");
    By backButton  =  By.id("href_close");
    By printButton  = By.id("href_print");
    By exportButton = By.id("href_export");
    By leftMenu = By.id("id_click");

    By customer  =  By.id("a_customer");
    By firstCustomerFromList  =  By.xpath("//*[@id=\"gridCustomerSales\"]/div[2]/table/tbody/tr[1]/td");


    // Validate Page Tital
    public String validateLogingPageTital (){
        return driver.getTitle();
    }

    // Validate Page Tital


    // Validate Loged In user name
    public  String validateLogedInUserName (){
        return driver.findElement(logedInUser).getText();
    }

}
