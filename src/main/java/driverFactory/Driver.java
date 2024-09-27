package driverFactory;

import elementActions.ElementActions;
import listener.webdriver.WebDriverListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class Driver {
    private ThreadLocal <WebDriver> driver;


    public Driver(String driverType){
        WebDriver undecoratedDriver = getDriver(driverType).startDriver();
        assert undecoratedDriver != null;
//        driver = new EventFiringDecorator<>(org.openqa.selenium.WebDriver.class,
//                new WebDriverListener(undecoratedDriver)).decorate(undecoratedDriver);

        driver = new ThreadLocal<>();
        driver.set(new EventFiringDecorator<>(org.openqa.selenium.WebDriver.class,
                new WebDriverListener(undecoratedDriver)).decorate(undecoratedDriver));
       // driver = getDriver(driverType).startDriver();
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

    public  WebDriver get(){
        return driver.get();

    }

    public void quit(){
        driver.get().quit();
    }

    public ElementActions element(){
        return new ElementActions(driver.get());
    }
}
