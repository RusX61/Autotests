package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(("http://127.0.0.1:5500/"));

        WebElement header = driver.findElement(By.xpath("/html/body/h1"));
        System.out.println(header.getText());
        driver.quit();


//        header.click();
//
//        header.sendKeys("selenium", Keys.ENTER);
//
//        header.clear();

    }

}

