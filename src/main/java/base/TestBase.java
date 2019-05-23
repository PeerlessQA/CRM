package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    static WebDriver driver;
    static Properties prop;


    public static final long PAGE_LOAD_TIMEOUT = 600 ;
    public static final long IMPLICIT_WAIT = 600;

    public TestBase(){

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/comfig/config.properties");
            prop.load(ip);

            } catch (FileNotFoundException e) {
            e.printStackTrace();
            } catch(IOException e) {
            e.printStackTrace();
           }
        }

           public TestBase (WebDriver driver) {this.driver = driver;}

               public WebDriver getDriver() {
                   return driver;
               }
               public void setDriver(WebDriver webdriver) {
                   driver = webdriver;
               }

            {
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT,TimeUnit.SECONDS);

                driver.get(prop.getProperty("url"));

            }
}

