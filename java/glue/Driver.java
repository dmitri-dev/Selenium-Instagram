package glue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    protected static WebDriver driver;

    protected WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:/programs/chromedriver_win32/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

}
