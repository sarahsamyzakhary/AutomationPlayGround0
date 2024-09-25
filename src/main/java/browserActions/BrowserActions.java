package browserActions;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class BrowserActions {
    private WebDriver driver;
    private Action actions;

    public BrowserActions(WebDriver driver){
        this.driver=driver;


    }

    /* url controling and navigation */
    public BrowserActions navigateToURL(String url){
        driver.navigate().to(url);
        return this;
    }
    public BrowserActions getToURL(String url){
        driver.get(url);
        return this;
    }
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
    public BrowserActions navigateToFowrward(){
        driver.navigate().forward();
        return this;
    }
    public BrowserActions navigateToBackwords(){
        driver.navigate().back();
        return this;
    }
    public BrowserActions refreshCurrentPage(){
        driver.navigate().refresh();
        return this;
    }
    public BrowserActions scrollToBottom(){
        new Actions(driver).scrollByAmount(0,2500).build().perform();
        return this;
    }

    public BrowserActions scrollToAmount(int width,int height){
        new Actions(driver).scrollByAmount(width,height).build().perform();

       return this;
    }

    /*cookies*/
    public BrowserActions addCookie (Cookie cookie){
        driver.manage().addCookie(cookie);
        return this;
    }

    /*************window control *************/



}
