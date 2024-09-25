package test;

import driverFactory.Driver;
import newPages.HomePage;
import newPages.LoginSignUpPage;
import newPages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductPageTest {
    public Driver driver;
    HomePage homePage;
    LoginSignUpPage loginSignUpPage;
    ProductPage productPage;

    @BeforeClass
    public void setup(){
        driver=new Driver("EDGE");
        driver.get().manage().window().maximize();
        driver.get().navigate().to("https://automationexercise.com");

    }
    @Test
    public void contactUsTest(){
        homePage=new HomePage(driver);



    }
    @AfterClass
    public void tearDown(){
        driver.get().manage().deleteAllCookies();
        driver.quit();

    }
}
