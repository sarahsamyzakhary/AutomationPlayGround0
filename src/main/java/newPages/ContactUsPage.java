package newPages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ContactUsPage {
    public Driver driver;
    By formTitle = By.xpath("(//h2[@class=\"title text-center\"])[1]");
    By nameField = By.xpath("//input[@data-qa=\"name\"]");
    By emailField = By.xpath("//input[@data-qa=\"email\"]");
    By subjectField = By.name("subject");
    By messageField = By.id("message");
    By submitField = By.name("submit");
    By successMessage = By.cssSelector("div.status.alert.alert-success");
    By homeButton =By.cssSelector("a.btn.btn-success");


    public ContactUsPage(Driver driver){
        this.driver = driver;
    }

    /****************Assertions********************/
    public ContactUsPage checkThatCountactUsPageLoadedSuccessfully(){
        Assert.assertTrue(driver.get().getCurrentUrl().contains("/contact_us"));
        Assert.assertEquals(driver.element().getTextOf(formTitle),"CONTACT US");
        return this;
    }
    public ContactUsPage checkThatFormShouldBeSubmittedSuccessfully(){
        Assert.assertEquals(driver.element().getTextOf(successMessage),"Success! Your details have been submitted successfully.");
        return this;

    }

    /*************************Actions****************/

    public ContactUsPage fillInContactUsForm(String name,String email,String subject,String message){
        driver.element().fillField(nameField,name);
        driver.element().fillField(emailField,email);
        driver.element().fillField(subjectField,subject);
        driver.element().fillField(messageField,message);
        return this;


    }

    public ContactUsPage clickOnSubmitButton(){
        driver.element().click(submitField);
        driver.get().switchTo().alert().accept();
        return this;
    }
    public HomePage clickOnHomeButton(){

        driver.element().click(homeButton);
        return new HomePage(driver);
    }
}
