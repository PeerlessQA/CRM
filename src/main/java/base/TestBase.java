package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;


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

        public static void initialization (){
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browserName.equals("Firefox")){
            System.setProperty("webdriver.gecko.driver","F:/opt/geckodriver.exe");

        }
        }
        {
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT,TimeUnit.SECONDS);

            driver.get(prop.getProperty("url"));

        }
}

