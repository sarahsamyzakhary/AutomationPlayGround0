package test;

import driverFactory.Driver;
import newPages.ContactUsPage;
import newPages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.ScreenShotManager;

import java.time.Duration;

public class ContactUsTest {




    ThreadLocal<Driver> driver;

    @BeforeClass
    @Parameters(value = {"browserName"})
    public void setup(@Optional("EDGE") String browserName){


       driver =new ThreadLocal<>();
       driver.set(new Driver(browserName));

        driver.get().get().manage().window().maximize();
       driver.get().get().navigate().to("https://automationexercise.com");
       driver.get().get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
       //driver.element().hoverOnItem(By.xpath("(//a[@class=\"btn-default add-to-cart\"])[1]"))
        //       .click(By.xpath("(//a[@class=\"btn-default add-to-cart\"])[1]"));
       
    }
    @Test
    public void contactUsTest() throws InterruptedException {
        driver.get().element().hoverOnItem(By.xpath("(//div[@class=\"product-overlay\"])[1]"))
               .click(By.xpath("(//a[@class=\"btn btn-default add-to-cart\"])[1]"));
       Thread.sleep(5000);

        new HomePage(driver.get()).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                 .clickOnContactUsLink()
                .checkThatCountactUsPageLoadedSuccessfully()
                .fillInContactUsForm("sara","sara@gmail.com","tester","hello there")
                .clickOnSubmitButton()
                .checkThatFormShouldBeSubmittedSuccessfully()
                .clickOnHomeButton()
                .checkThatUserShouldBeNavigatedToHomePageSuccessfully();


    }
    @AfterMethod
    public void screenshotOnFailure(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            System.out.println("Test Failure");
            System.out.println("Taking screen shot....");
            ScreenShotManager.captureScreenshot(driver.get().get(), result.getName());
        }
    }
    @AfterClass
    public void tearDown(){
        driver.get().get().manage().deleteAllCookies();
        driver.get().get().quit();

    }
}
