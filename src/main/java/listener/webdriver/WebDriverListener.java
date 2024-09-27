package listener.webdriver;

import org.openqa.selenium.WebDriver;

public class WebDriverListener implements org.openqa.selenium.support.events.WebDriverListener {
    private WebDriver driver;

    public WebDriverListener(WebDriver driver){
        this.driver = driver;
    }

    @Override
    public void afterGet(WebDriver driver,String url){
        System.out.println("Getting to \"" + url + "\".");
    }
    @Override
    public void afterGetTitle(WebDriver driver, String result){
        System.out.println("Current Page Title is :\""+ result + "\".");
    }





 }
