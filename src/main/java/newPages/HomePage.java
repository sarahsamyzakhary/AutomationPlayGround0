package newPages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
   public Driver driver;
    By loginLink =By.xpath("//a[@href=\"/login\"]");
    By logoutLink = By.xpath("//a[@href=\"/logout\"]");
    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");
    By contactUsLink = By.xpath("//a[@href=\"/contact_us\"]");
    By testCaseButton = By.xpath("//a[@href=\"/test_cases\"]");
    By productLink = By.xpath("//a[@href=\"/products\"]");

    public HomePage(Driver driver){
        this.driver = driver;
    }
    /*************************Assertion**************************/

    public HomePage checkThatLogoutLinkShouldBeDisplayed(){
        Assert.assertTrue(driver.get().findElement(logoutLink).isDisplayed());
        return this;

    }

    public HomePage checkThatLoginLinkShouldBeDisplayed(){
        Assert.assertTrue(driver.get().findElement(loginLink).isDisplayed());
        return this;

    }
    public HomePage checkThatDeleteAccountLinkShouldBeDisplayed(){
        Assert.assertTrue(driver.get().findElement(deleteAccountLink).isDisplayed());
        return this;
    }
    public HomePage checkThatUserShouldBeNavigatedToHomePageSuccessfully(){

        Assert.assertEquals(driver.get().getCurrentUrl(),"https://automationexercise.com/");
        return this;
    }
    public HomePage checkThatTestCasesLinkIsAppearSuccessfully(){
        Assert.assertTrue(driver.get().findElement(testCaseButton).isDisplayed());
        return this;
    }
    @Step("checkThatProductLinkAppearSuccessfully")
    public HomePage checkThatProductLinkAppearSuccessfully(){
        Assert.assertTrue(driver.get().findElement(productLink).isDisplayed());
        return this;
    }

    /*************************Action**************************/
    public AccountSuccessfulDeletion clickOnDeleteAccountLink(){

        driver.element().click(deleteAccountLink);
        return new AccountSuccessfulDeletion(driver);
    }
    public LoginSignUpPage clickOnLogoutLink(){

        driver.element().click(logoutLink);
        return new LoginSignUpPage(driver);
    }
    public LoginSignUpPage clickOnLoginLink(){

        driver.element().click(loginLink);
        return new LoginSignUpPage(driver);
    }



    public ContactUsPage clickOnContactUsLink(){
        driver.element().click(contactUsLink);
        return new ContactUsPage(driver);

    }
    public TestCasesPage clickOnTestCasesButton(){
        driver.element().click(testCaseButton);
        return new TestCasesPage(driver);
    }
    public ProductPage clickOnProductButton(){
        driver.element().click(productLink);
        return new ProductPage(driver);
    }
}
