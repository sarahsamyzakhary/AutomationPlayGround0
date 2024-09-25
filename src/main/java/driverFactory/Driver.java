package driverFactory;

import elementActions.ElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

public class Driver {
    private static WebDriver driver;


    public Driver(String driverType){
        WebDriver undecoratedDriver = getDriver(driverType).startDriver();
        driver = new EventFiringDecorator<>(org.openqa.selenium.WebDriver.class, new WebDriverListener(undecoratedDriver)).decorate(undecoratedDriver);
      //  driver = getDriver(driverType).startDriver();
        assert driver !=null;
       // driver = new ThreadLocal<>();

    }

    private DriverAbstract getDriver(String driver){
        switch (driver){
            case "CHROME":{
                return new ChromeDriverFactory();
            }
            case "EDGE":{
                return new EdgeDriverFactory();
            }
            case "FIREFOX":{
                return new FireFoxFactory();
            }
            default:{
                throw new IllegalStateException("unexpected value"+ driver);
            }
        }
    }

    public static WebDriver get(){
        return driver;

    }

    public void quit(){
        driver.quit();
    }

    public ElementActions element(){
        return new ElementActions(driver);
    }
}
