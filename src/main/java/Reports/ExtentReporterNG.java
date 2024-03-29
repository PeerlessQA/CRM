package Reports;

import com.relevantcodes.extentreports.*;
import org.testng.*;
import org.testng.xml.XmlSuite;
import org.testng.IReporter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExtentReporterNG implements IReporter {
    private ExtentReports extent;
    private ExtentReports jenkinsExtent;

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

        String date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        String time = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());

        extent = new ExtentReports (System.getProperty("user.dir") +"/CRM Test Report/"+date+"/"+time+".html", false);
        jenkinsExtent = new ExtentReports (System.getProperty("user.dir") +"/Jenkins Report/extend.html", true);

        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();

                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
            }
        }

        extent.flush();
        extent.close();
        jenkinsExtent.flush();
        jenkinsExtent.close();

    }

    private void buildTestNodes(IResultMap tests, LogStatus status) {
        ExtentTest test;

        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                jenkinsExtent.startTest(result.getMethod().getMethodName());
                test = extent.startTest(result.getMethod().getMethodName());
                test.getTest().setStartedTime(getTime(result.getStartMillis()));
                test.getTest().setEndedTime(getTime(result.getEndMillis()));

                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                String message = "Test " + status.toString().toLowerCase() + "ed";

                if (result.getThrowable() != null)
                    message = result.getThrowable().getMessage();

                test.log(status, message);

                extent.endTest(test);
                jenkinsExtent.endTest(test);
            }
        }
    }



    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }

}