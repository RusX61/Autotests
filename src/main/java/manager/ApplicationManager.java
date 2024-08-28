package manager;

import org.openqa.selenium.WebDriver;
import pages.HistoryPage;
import pages.MainPage;
import pages.PricePage;
import pages.SendPage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static manager.DriverFactory.CHROME;

public class ApplicationManager {
    public WebDriver driver;
    public MainPage mainPage;
    public MainPage getMainPage() {
        return mainPage;
    }
    public SendPage sendPage;
    public SendPage getSendPage() {
        return new SendPage(driver);
    }
    public HistoryPage historyPage;
    public HistoryPage getHistoryPage() {
        return new HistoryPage(driver);
    }
    public PricePage pricePage;
    public PricePage getPricePage() {
        return new PricePage(driver);
    }



    public void init() throws IOException {
        Properties properties = new Properties();
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/main/resources/%s.properties", target))));
        driver = DriverFactory.createDriver(System.getProperty("browser", CHROME));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("web.baseUrl"));
        mainPage = new MainPage(driver);
        sendPage = new SendPage(driver);
    }

    public void close() {
        driver.quit();
    }
}
