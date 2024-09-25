package newPages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FirstProductPage {
    public Driver driver;

    By newarrival =By.xpath("//div[@class=\"product-information\"]/img[@class=\"newarrival\"]");
    By price = By.xpath("div[@class=\"product-information\"]/span/span");
    By name =By.xpath("//div[@class=\"product-information\"]/h2");
    By catogory = By.xpath("(//div[@class=\"product-information\"]/p)[1]");
    By avaliability = By.xpath("//div[@class=\"product-information\"]/p[2]");
    By condition = By.xpath("//div[@class=\"product-information\"]/p[3]");
    By brand = By.xpath("//div[@class=\"product-information\"]/p[4]");




    public FirstProductPage(Driver driver){
        this.driver=driver;
    }

    public FirstProductPage checkThatFirstProductPageIsLoadedSuccessfully(){
        Assert.assertTrue(driver.get().getCurrentUrl().contains("/product_details/1"));
        return this;
    }
    public FirstProductPage checkThatDetailedOfTheProductLoadedSuccessfully(){


        return this;
    }



}
