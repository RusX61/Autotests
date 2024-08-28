import model.SendPageDataItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.WebElement;
import pages.GetTable;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static pages.BasePage.driver;
import static pages.SendPage.*;
import static utils.DataProvider.sendPageTestData;

class AllureTst extends TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    public static Iterator<Object[]> dataRead() throws IOException {
        return sendPageTestData();
    }

    @Test
    public void FromMainToSendAndBack () throws InterruptedException {
        logger.info(() -> "Start FromMainToSendAndBack");
        applicationManager.getMainPage().clickSend();
        Assertions.assertEquals(applicationManager.getSendPage().getHeaderText(), "Передача показаний");
        applicationManager.getSendPage().clickBackButton();
        Assertions.assertEquals(applicationManager.getMainPage().getHeaderText(), "Neo ЖКХ");
        logger.info(() -> "Success FromMainToSendAndBack");
    }

    @Test
    public void FromMainToHistoryAndBack () throws InterruptedException {
        logger.info(() -> "Start FromMainToHistoryAndBack");
        applicationManager.getMainPage().clickHistory();
        Assertions.assertEquals(applicationManager.getHistoryPage().getHeaderText(), "История показаний");
        applicationManager.getHistoryPage().clickBackButton();
        Assertions.assertEquals(applicationManager.getMainPage().getHeaderText(), "Neo ЖКХ");
        logger.info(() -> "Success FromMainToHistoryAndBack");
    }

    @Test
    public void FromMainToPriceAndBack () throws InterruptedException {
        logger.info(() -> "Start FromMainToPriceAndBack");
        applicationManager.getMainPage().clickPrice();
        Assertions.assertEquals(applicationManager.getPricePage().getHeaderText(), "Справочник стоимости услуг");
        applicationManager.getPricePage().clickBackButton();
        Assertions.assertEquals(applicationManager.getMainPage().getHeaderText(), "Neo ЖКХ");
        logger.info(() -> "Success FromMainToPriceAndBack");
    }

@MethodSource("dataRead")
    @ParameterizedTest
    public void FillFormToSend (SendPageDataItem SendPageDataItem) throws InterruptedException {
        logger.info(() -> "Start FillFormToSend");
        applicationManager.getMainPage().clickSend();
        Assertions.assertEquals(applicationManager.getSendPage().getHeaderText(), "Передача показаний");
        fillDate(SendPageDataItem.getDate());
        fillCold(SendPageDataItem.getColdWater());
        fillHot(SendPageDataItem.getHotWater());
        fillGas(SendPageDataItem.getGas());
        fillElec(SendPageDataItem.getElectric());
        clickSubmitBtn();
        Assertions.assertEquals(SendPageDataItem.getResultValue(), getSummary());
        logger.info(() -> "Success FillFormToSend");
    }

@MethodSource("dataRead")
    @ParameterizedTest
    public void FillAndCheckTable(SendPageDataItem SendPageDataItem) throws InterruptedException {
        logger.info(() -> "Start FillFormToSend");
        applicationManager.getMainPage().clickSend();
        Assertions.assertEquals(applicationManager.getSendPage().getHeaderText(), "Передача показаний");
        fillDate(SendPageDataItem.getDate());
        fillCold(SendPageDataItem.getColdWater());
        fillHot(SendPageDataItem.getHotWater());
        fillGas(SendPageDataItem.getGas());
        fillElec(SendPageDataItem.getElectric());
        clickSubmitBtn();
        logger.info(() -> "Filling table success, start check table");
        GetTable getTable = new GetTable();
        getTable.Table(getTableElement(), driver);
        List<List<WebElement>> rowsWithColumns = GetTable.getRowsWithColumns();
        for (List<WebElement> row : rowsWithColumns) {
            for (WebElement cell : row) {
                Assertions.assertNotEquals("", cell.getText());
            }
        }
        logger.info(() -> "Success FillAndCheckTable");
    }
}
