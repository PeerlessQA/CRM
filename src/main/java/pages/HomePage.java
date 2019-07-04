package pages;

import base.TestBase;
import groovy.lang.Tuple;
import javafx.util.Pair;
import org.openqa.selenium.By;
import BusinessRule.HomeBR;
import util.CustomObject;

import java.util.*;

import java.sql.SQLException;

public class HomePage extends TestBase {

    By logedInUser = By.id("logged_in");
    //Buttons
    By siginOut = By.id("lbtnSignOut");
    By backButton  =  By.id("href_close");
    By printButton  = By.id("href_print");
    By exportButton = By.id("href_export");
    By leftMenu = By.id("id_click");

    By customer  =  By.id("a_customer");
    By CustomerList;
    ArrayList<CustomObject> myList;

    //By firstCustomerFromList  =  By.xpath("//*[@id=\"gridCustomerSales\"]/div[2]/table/tbody/tr[1]/td");
    //By middleCustomerFromList  =  By.xpath("//*[@id=\"gridCustomerSales\"]/div[2]/table/tbody/tr[10]/td");
    //By lastCustomerFromList  =  By.xpath("//*[@id=\"gridCustomerSales\"]/div[2]/table/tbody/tr[20]/td");

    By CustomerCount = By.xpath("//*[@id=\"div_RowCount_max\"]/b");
    private int Count = Integer.parseInt(driver.findElement(CustomerCount).getText());

                                          //*[@id="gridCustomerSales"]/div[2]/table/tbody/tr[1]/td


    HomeBR homeBR = new HomeBR();

    // Validate Page Tital
    public String validateLogingPageTital (){
        return driver.getTitle();
    }

    // Pass first customer from the list to BR
    public ArrayList<CustomObject> validateCustomer () throws SQLException ,ClassNotFoundException
    {
        myList = new ArrayList<CustomObject>();

        for (int i = 1; i <= 20; i = i+1) {
            CustomerList  =  By.xpath("//*[@id=\"gridCustomerSales\"]/div[2]/table/tbody/tr["+Integer.toString(i)+"]/td");
            String Pvalue = driver.findElement(CustomerList).getText();
            String Dvalue = homeBR.validateCustomer(driver.findElement(CustomerList).getText());
            System.out.println(Pvalue+" = "+Dvalue);
            CustomObject o1 = new CustomObject(Pvalue, Dvalue);
            myList.add(o1);
        }

        System.out.println(myList.size());
        return myList;
    }

    // Validate Loged In user name
    public  String validateLogedInUserName (){
        return driver.findElement(logedInUser).getText();
    }

}
