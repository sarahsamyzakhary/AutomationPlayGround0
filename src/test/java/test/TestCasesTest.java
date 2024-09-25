package test;

import driverFactory.Driver;
import newPages.ContactUsPage;
import newPages.HomePage;
import newPages.TestCasesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCasesTest {
    public Driver driver;
    HomePage homePage;
    TestCasesPage testCasesPage;
    @BeforeClass
    public void setup(){
        driver=new Driver("EDGE");
        driver.get().manage().window().maximize();
        driver.get().navigate().to("https://automationexercise.com");

    }
    @Test
    public void contactUsTest(){
        homePage=new HomePage(driver);
        testCasesPage =new TestCasesPage(driver);
        homePage.checkThatUserShouldBeNavigatedToHomePageSuccessfully();
        homePage.checkThatTestCasesLinkIsAppearSuccessfully();
        homePage.clickOnTestCasesButton();
        testCasesPage.checkThatUserCanNavigateToTestCasePageSuccessfully();


    }
    @AfterClass
    public void tearDown(){
        driver.get().manage().deleteAllCookies();
        driver.quit();

    }
}
