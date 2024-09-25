package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        WebDriver driver = new EdgeDriver();
        driver.navigate().to("https://automationexercise.com/login");
        driver.findElement(By.name("name")).sendKeys("sarahsamy");
        driver.findElement(By.xpath("(//input[@name=\"email\"])[2]")).sendKeys("s12345g555@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]")).click();

//        driver.findElement(By.id("name")).sendKeys("sarah");
//        driver.findElement(By.id("email")).sendKeys("sarah@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123423");
        driver.findElement(By.id("first_name")).sendKeys("sarah");
        driver.findElement(By.id("last_name")).sendKeys("samy");
        driver.findElement(By.id("address1")).sendKeys("Alexandria");
        driver.findElement(By.id("state")).sendKeys("Alex");
        driver.findElement(By.id("city")).sendKeys("Alex");
        WebElement dropDown = driver.findElement(By.id("country"));
        Select select = new Select(dropDown);
        select.selectByValue("Australia");
        driver.findElement(By.id("zipcode")).sendKeys("21500");
        driver.findElement(By.id("mobile_number")).sendKeys("01234456978");
        driver.findElement(By.xpath("//button[@data-qa=\"create-account\"]")).click();


    }
}
