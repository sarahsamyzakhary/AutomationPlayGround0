package listener.webdriver;

import org.openqa.selenium.WebDriver;

public class WebDriverListener implements org.openqa.selenium.support.events.WebDriverListener {
    private WebDriver driver;

    public WebDriverListener(WebDriver driver){
        this.driver = driver;
    }



 }
