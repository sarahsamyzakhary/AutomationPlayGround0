package test;

import driverFactory.Driver;
import newPages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTTest {
    Driver driver;

    //ContactUsPage contactUsPage;



    @BeforeClass
    public void setUp(){
        // EdgeOptions options = new EdgeOptions(); for run hidden screen or change window size or to make the view as a mobile screen
        //driver = new EdgeDriver(options);
        driver = new Driver("EDGE");
        driver.get().navigate().to("https://automationexercise.com");
        driver.get().manage().window().maximize();

    }
    @Test (priority = 1)
    public void userCanRegisterSuccessfully(){

        new HomePage(driver).checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                            .clickOnLoginLink()
                            .checkThatUserIsNavigatedToLoginSignUpPage()
                            .fillInSignUpEmail("fylhathl22mn10llns125@gmail.com")
                            .fillInSignUpName("sarah")
                            .clickOnSignUpButton()
                            .checkThatRegisterationPageIsLoadedSuccessfully()
                            .fillInRegisterationPage()
                            .clickOnCreateAcountButton()
                            .checkThatSuccessMessageWillBeDisplayed();

        driver.get().manage().deleteAllCookies();
    }

    @Test(dependsOnMethods = "userCanRegisterSuccessfully", priority = 2)

    public void userCanLoginSuccessfully(){
        driver.get().navigate().to("https://automationexercise.com/login");

        new LoginSignUpPage(driver).fillInLoginEmail("fylhathl22mn10llns125@gmail.com")
                                   .fillInLoginPassword("123423")
                                   .clickInLoginButton()
                                   .checkThatUserShouldBeNavigatedToHomePageSuccessfully()
                                   .checkThatLogoutLinkShouldBeDisplayed();

    }

    @Test(dependsOnMethods = "userCanLoginSuccessfully",priority = 3)
    public void userCanLogoutSuccessfuly(){
        new HomePage(driver).clickOnLogoutLink()
                            .checkThatUserIsNavigatedToLoginSignUpPage();


    }
    @Test(dependsOnMethods = "userCanLogoutSuccessfuly", priority = 4)
    public void userCanDeleteAcccountSuccessfuly(){

        new LoginSignUpPage(driver).fillInLoginEmail("fylhathl22mn10llns125@gmail.com")
                                   .fillInLoginPassword("123423")
                                   .clickInLoginButton()
                                   .checkThatLogoutLinkShouldBeDisplayed()
                                   .clickOnDeleteAccountLink()
                                   .checkThatSuccessMessageWillBeDisplayed()
                                   .clickOnCountinueButton()
                                   .checkThatLoginLinkShouldBeDisplayed();



    }


    @AfterClass
    public void tearDown(){
        driver.get().manage().deleteAllCookies();
        driver.quit();
    }
}
