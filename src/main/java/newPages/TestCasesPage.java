package newPages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCasesPage {
    public Driver driver;
    By testCaseButton = By.xpath("//a[@href=\"/test_cases\"]");

    public TestCasesPage(Driver driver){
        this.driver=driver;
    }

    public void checkThatUserCanNavigateToTestCasePageSuccessfully(){
        Assert.assertTrue(driver.get().getCurrentUrl().contains("/contact_us"));
    }



}
