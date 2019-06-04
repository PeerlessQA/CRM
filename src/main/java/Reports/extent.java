package Reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.text.SimpleDateFormat;
import java.util.Calendar;

// This is the old report  and not using it anymore

public class extent {
    ExtentReports extent;
    ExtentTest logger;
    public void setUpReport ()
    {
        String date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        String time = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());
        extent = new ExtentReports (System.getProperty("user.dir") +"/Report-Output/CRM-ExecutionReport/"+date+"/"+time+".html", false);
    }
    public void logEventsPass (String value)
    {
        logger.log(LogStatus.PASS, value);
    }
    public void logEventsFail (String value)
    {
        logger.log(LogStatus.FAIL, value);
    }
    public void logEventsInfo (String value)
    {
        logger.log(LogStatus.INFO, value);
    }
    public void logEventsWarning (String value)
    {
        logger.log(LogStatus.WARNING, value);
    }
    public void startTestCase (String testcaseName)
    {
        logger = extent.startTest(testcaseName);
    }
    public void createFinalReport()
    {
        extent.flush();
    }
}
