package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends Element {
    private WebDriver driver;

    public MainPage(WebDriver driver)  {
        super(driver);
        this.driver = driver;
    }


    private By dataSend = By.xpath("//*[@id=\"send_button\"]");

    public SendPage clickSend() {
        click(driver.findElement(dataSend));
        return new SendPage(driver);
    }


    private By dataHistory = By.xpath("//*[@id=\"history_button\"]");

    public HistoryPage clickHistory() {
        driver.findElement(dataHistory).click();
        return new HistoryPage(driver);
    }


    private By price = By.xpath("//*[@id=\"catalog_button\"]");

    public PricePage clickPrice() {
        driver.findElement(price).click();
        return new PricePage(driver);
    }

}