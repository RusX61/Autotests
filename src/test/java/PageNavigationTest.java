import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.FillFormToSend;
import pages.SendPage;


public class PageNavigationTest extends TestBase {

    @Test

    public void FromMainToSendAndBack () throws InterruptedException {
        applicationManager.getMainPage().clickSend();
        Assertions.assertEquals(applicationManager.getSendPage().getHeaderText(), "Передача показаний");
        applicationManager.getSendPage().clickBackButton();
        Assertions.assertEquals(applicationManager.getMainPage().getHeaderText(), "Neo ЖКХ");
    }

    @Test

    public void FromMainToHistoryAndBack () throws InterruptedException {

        applicationManager.getMainPage().clickHistory();
        Assertions.assertEquals(applicationManager.getHistoryPage().getHeaderText(), "История показаний");
        applicationManager.getHistoryPage().clickBackButton();
        Assertions.assertEquals(applicationManager.getMainPage().getHeaderText(), "Neo ЖКХ");

    }

    @Test

    public void FromMainToPriceAndBack () throws InterruptedException {

        applicationManager.getMainPage().clickPrice();
        Assertions.assertEquals(applicationManager.getPricePage().getHeaderText(), "Справочник стоимости услуг");
        applicationManager.getPricePage().clickBackButton();
        Assertions.assertEquals(applicationManager.getMainPage().getHeaderText(), "Neo ЖКХ");


    }

    @Test
    public void FillFormToSend () throws InterruptedException {

        applicationManager.getMainPage().clickSend();
        Assertions.assertEquals(applicationManager.getSendPage().getHeaderText(), "Передача показаний");
        FillFormToSend.fillDate("23.08.2024");
        FillFormToSend.fillCold("10");
        FillFormToSend.fillHot("10");
        FillFormToSend.fillGas("10");
        FillFormToSend.fillElec("10");
        applicationManager.getSendPage().clickSendMeterReadings();
        Assertions.assertEquals(FillFormToSend.getSummary(), "147");
    }

}
