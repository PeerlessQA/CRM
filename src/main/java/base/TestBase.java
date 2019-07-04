package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.WebEventListener;
import java.io.FileNotFoundException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;


    public static final long PAGE_LOAD_TIMEOUT = 40 ;
    public static final long IMPLICIT_WAIT = 40;

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

    public static void initialization (){
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")){

            if(System.getProperty("os.arch").toLowerCase().equalsIgnoreCase("amd64")){
                if(System.getProperty("os.name").toLowerCase().indexOf("windows")>=0){
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_driver/" + System.getProperty("os.arch") + "/windows/chromedriver");
                }

            }

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browserName.equals("Firefox")){
            System.setProperty("webdriver.gecko.driver","C:/opt/geckodriver.exe");

        }

            e_driver = new EventFiringWebDriver(driver);
            eventListener = new WebEventListener();
            e_driver .register(eventListener);
            driver = e_driver ;


            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT,TimeUnit.SECONDS);

            driver.get(prop.getProperty("url"));

        }

    public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

}

