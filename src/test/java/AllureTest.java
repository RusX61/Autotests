import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

public class AllureTest {

    private WebDriver driver;

    @BeforeEach

    public void setupPage() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("http://127.0.0.1:5500/index.html");

        Thread.sleep(1000);

    }

    @Step

    @DisplayName("Navigation test")

    @Description("Navigation test description")

    @Test

    public void FromMainToSendAndBack () throws InterruptedException {

        MainPage mainPage = new MainPage(driver);

        mainPage.clickSend();

        Assertions.assertEquals(driver.findElement(By.xpath("/html/body/h1")).getText(), "Передача показаний");

        driver.findElement(By.xpath("//*[@id=\"back_button\"]")).click();

        Assertions.assertEquals(driver.findElement(By.xpath("/html/body/h1")).getText(), "Neo ЖКХ");

    }


    @AfterEach

    public void closePage() {

        driver.quit();

    }

}

//@Step - данная аннотация используется для обозначения тестового шага
//@DisplayName - данная аннотация используется для того, чтобы задать название тестовому шагу
//@Description - данная аннотация используется для того, чтобы задать описание к тестовому шагу
//        Для того, чтобы после выполнения теста сформировать отчёт и открыть его в браузере, необходимо выполнить следующие действия:
//        1) Открыть Terminal в IntelliJ IDEA
//2) Ввести команду: allure generate --clean
//3) Ввести команду: allure serve
//4) После выполнения команды allure serve откроется окно браузера с отчётом по запущенным тестам


