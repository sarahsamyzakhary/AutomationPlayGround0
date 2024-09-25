package newPages;

import driverFactory.Driver;
import elementActions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class AccountSuccessfulDeletion {
    public Driver driver;
    By successMessage = By.xpath("//h2[@data-qa=\"account-deleted\"]");
    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    public AccountSuccessfulDeletion(Driver driver){
        this.driver = driver;
    }
    public AccountSuccessfulDeletion checkThatSuccessMessageWillBeDisplayed(){


        Assert.assertTrue(driver.get().getCurrentUrl().contains("/delete_account"));
        Assert.assertTrue(driver.element().isDisplayed(successMessage));
        Assert.assertEquals(driver.element().getTextOf(successMessage),"ACCOUNT DELETED!");
return this;
    }



    public HomePage clickOnCountinueButton(){

        driver.element().click(continueButton);
        return new HomePage(driver);
    }


}
