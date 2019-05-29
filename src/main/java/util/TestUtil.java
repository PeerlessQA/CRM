package util;

import base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import util.WebEventListener;

import java.io.File;
import java.io.IOException;

public class TestUtil extends TestBase {

  public static long PAGE_LOAD_TIMEOUT = 20 ;
  public static long IMPLICIT_WAIT = 20 ;


  public  void  switchTorame (){
    driver.switchTo().frame("mainpanel");

  }
  public void takeScreenshotAtEndOfTest() throws IOException{
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    String currentDir = System.getProperty("user.dir");
    FileUtils.copyFile(scrFile,new File(currentDir + "/screenShotes/"+System.currentTimeMillis()+ ".png"));
  }

}



