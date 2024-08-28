package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static  String CHROME = "chrome";
    public static String FIREFOX = "firefox";

    static WebDriver createDriver(String browser) {
        if (browser.equalsIgnoreCase(CHROME)) {
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase(FIREFOX)) {
            return new FirefoxDriver();
        }
        return new ChromeDriver();
    }

}
