package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SendPage extends Element {

    public SendPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements((driver), this);
    }


    private static By inputDate = By.xpath("//*[@id=\"date\"]");

    public static void fillDate(String date) {
        driver.findElement(inputDate).sendKeys(date);
    }


    private static By inputCold = By.xpath("//*[@id=\"coldData\"]");

    public static void fillCold(String cold) {
        driver.findElement(inputCold).sendKeys(cold);
    }


    private static By inputHot = By.xpath("//*[@id=\"hotData\"]");

    public static void fillHot(String hot) {
        driver.findElement(inputHot).sendKeys(hot);
    }


    private static By inputGas = By.xpath("//*[@id=\"gasData\"]");

    public static void fillGas(String gas) {
        driver.findElement(inputGas).sendKeys(gas);
    }


    private static By inputElec = By.xpath("//*[@id=\"elecData\"]");

    public static void fillElec(String elec) {
        driver.findElement(inputElec).sendKeys(elec);
    }


    private static By sendBtn = By.xpath("//*[@id=\"button\"]");

    public static void clickSubmitBtn() {
        waitForElementClickable(driver.findElement(sendBtn), driver);
        click(driver.findElement(sendBtn));
    }


    private static By summary = By.xpath("//*[@id=\"table\"]/tbody/tr[7]/td[2]");

    public static String getSummary() {
        return driver.findElement(summary).getText();
    }


    public static WebElement getTableElement() {
        return driver.findElement(By.id("table"));
    }
}
