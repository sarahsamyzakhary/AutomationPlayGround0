package newPages;

import driverFactory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductPage {
    public Driver driver;

    By productLink = By.xpath("//a[@href=\"/products\"]");
    By allProducts = By.cssSelector("h2.title.text-center");
    By catogory = By.xpath("//div[@class=\"left-sidebar\"]/h2");
    By woman = By.xpath("//a[@href=\"#Women\"]");
    By man = By.xpath("//a[@href=\"#Men\"]");
    By viewFirstProduct = By.xpath("//a[@href=\"/product_details/1\"]");
    By brands = By.xpath("//div[@class=\"brands_products\"]/h2");



    public ProductPage(Driver driver){
        this.driver=driver;
    }
    public ProductPage checkThatProductPageLoadedSuccessfully(){
        Assert.assertTrue(driver.get().getCurrentUrl().contains("/products"));
        Assert.assertEquals(driver.element().getTextOf(allProducts),"ALL PRODUCTS");
        return this;
    }
    public ProductPage checkThatTheProductListIsVisiable(){
        Assert.assertTrue(driver.element().isDisplayed(allProducts));
        Assert.assertTrue(driver.element().isDisplayed(catogory));
        Assert.assertTrue(driver.element().isDisplayed(brands));

        return this;
    }



    public FirstProductPage ClickOnViewFirstProduct(){
        driver.element().click(viewFirstProduct);
        return new FirstProductPage(driver);
    }


}
