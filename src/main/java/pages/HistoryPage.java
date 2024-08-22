package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HistoryPage extends Element {
    private WebDriver driver;
    private By backButton = By.xpath("//*[@id=\"back_button\"]");

    public HistoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickBackButton (){
        click(driver.findElement(backButton));
    }
}
