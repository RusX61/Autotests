package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HistoryPage;
import pages.MainPage;
import pages.PricePage;
import pages.SendPage;

import java.util.concurrent.TimeUnit;

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



    public void init() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://127.0.0.1:5500/");
        mainPage = new MainPage(driver);
        sendPage = new SendPage(driver);
        historyPage = new HistoryPage(driver);
        pricePage = new PricePage(driver);

    }

    public void close() {
        driver.quit();
    }
}
