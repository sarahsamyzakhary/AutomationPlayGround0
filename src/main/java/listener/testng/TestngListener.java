package listener.testng;

import driverFactory.Driver;
import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ScreenShotManager;

import java.io.IOException;

public class TestngListener implements ITestListener, IExecutionListener {
    @Override
    public void onExecutionStart(){
        System.out.println("******** welcome to selenium framework **********");
    }

    @Override
    public void onExecutionFinish(){
        System.out.println("Generating reports.......");
        try {
            Runtime.getRuntime().exec("reportGeneration.bat");
        } catch (IOException e) {
            System.out.println("Unable to Generate Allure Report");
        }
        System.out.println("******************** End of execution ******************");
    }

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("************ Starting test " + result.getName() + " ***********");

    }
    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("************ Success of test " + result.getName() + " ***********");

    }

    public void onTestFailure(ITestResult result){
        System.out.println("Test Falied");
        System.out.println("Taking Screen shot.......");
        //ScreenShotManager.captureScreenshot(Driver.get(), result.getName());
        System.out.println("************ Faliure of test " + result.getName() + " ***********");
    }
}
