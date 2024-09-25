package newPages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterationPage {
    public Driver driver;
    By password = By.id("password");
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By address1 = By.id("address1");
    By state =By.id("state");
    By city = By.id("city");
    By zipcode = By.id("zipcode");
    By mobileNumber = By.id("mobile_number");
    By createAccountButton =By.xpath("//button[@data-qa=\"create-account\"]");
    By country = By.id("country");
    By enterAccountInformationTitle = By.xpath("(//h2[@class=\"title text-center\"])[1]");






    public RegisterationPage(Driver driver){
        this.driver = driver;
    }


    /************Assertion*********/

    public RegisterationPage checkThatRegisterationPageIsLoadedSuccessfully(){
        Assert.assertTrue(driver.get().getCurrentUrl().contains("/signup"));
        Assert.assertEquals(driver.element().getTextOf(enterAccountInformationTitle),"ENTER ACCOUNT INFORMATION");
        return this;


   }

    /************Actions***********/

    public RegisterationPage fillInRegisterationPage(){
       //driver = new EdgeDriver();

        driver.element().fillField(password,"123423");
        driver.element().fillField(firstName,"sarah");
        driver.element().fillField(lastName,"samy");
        driver.element().fillField(address1,"Alexandria");
        driver.element().fillField(state,"Alex");
        driver.element().fillField(city,"Alex");
        driver.element().fillField(zipcode,"21500");
        driver.element().fillField(mobileNumber,"01234456978");


        WebElement dropDown = driver.get().findElement(country);
        Select select = new Select(dropDown);
        select.selectByValue("Australia");
        return this;



    }

    public RegisterationSuccessPage clickOnCreateAcountButton(){
        driver.element().click(createAccountButton);
        return new RegisterationSuccessPage(driver);

    }
}
