package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Element extends BasePage {
    public Element(WebDriver driver) {
        super(driver);
    }

    private By header = By.xpath("/html/body/h1");

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    private By backButton = By.xpath("//*[@id=\"back_button\"]");

    public void clickBackButton (){
        waitForElementClickable(driver.findElement(backButton), driver);
        click(driver.findElement(backButton));
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

    private By sendBtn = By.xpath("//*[@id=\"button\"]");

    public void clickSendMeterReadings() {
        waitForElementClickable(driver.findElement(sendBtn), driver);
        click(driver.findElement(sendBtn));
    }

    private static By summary = By.xpath("//*[@id=\"table\"]/tbody/tr[7]/td[2]");

    public static String getSummary() {
        return driver.findElement(summary).getText();
    }

}









