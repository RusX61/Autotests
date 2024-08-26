package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class GetTable {

    private static WebElement tableElement;


    public void Table(WebElement tableElement, WebDriver driver) {

        GetTable.tableElement = tableElement;

    }

    //Получение всех строк строк из таблицы и удаление строки с заголовками
    public static List<WebElement> getRows() {

        List<WebElement> rows = tableElement.findElements(By.xpath(".//tr"));

        rows.remove(1);

        return rows;

    }

    //Разбиение строк на колонки
    public static List<List<WebElement>> getRowsWithColumns() {

        List<WebElement> rows = getRows();

        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();

        for (WebElement row : rows) {

            List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td"));

            rowsWithColumns.add(rowWithColumns);

        }

        return rowsWithColumns;

    }

    //Вычитывание содержимого ячейки по номеру строки и столбца
    public static String getValueFromCell(int rowNumber, int columnNumber) {

        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();

        WebElement cell = rowsWithColumns.get(rowNumber).get(columnNumber);

        return cell.getText();

    }

}