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

}
