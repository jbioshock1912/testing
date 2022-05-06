package table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodTable {
    private WebElement tableElement;
    private WebDriver driver;


    public MethodTable(WebElement elementTable, WebDriver driver) {
        this.tableElement = elementTable;
        this.driver = driver;
    }

    public List<WebElement> getRows() {
        List<WebElement> rows = tableElement.findElements(By.xpath(".//tr")); // находим строки в найденной ранее таблице
        rows.remove(0); // удаляем строку с заголовками
        return rows;
    }

    public List<WebElement> getHeadings() {
        WebElement headingRows = tableElement.findElement(By.xpath(".//tr[1]")); // получаем первую строку со всеми заголовками
        List<WebElement> headingsColumn = headingRows.findElements(By.xpath(".//th")); // в строке ищем заголовки
        return headingsColumn;
    }

    public List<List<WebElement>> getRowsWithColumn() {
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for (WebElement row : rows) {
            List<WebElement> rowAndColumn = row.findElements(By.xpath(".//td"));
            rowsWithColumns.add(rowAndColumn);
        }
        return rowsWithColumns;
    }

    public List<Map<String, WebElement>> getRowsWithColumnsByHeadings() { // находим ячейку по заголовку
        List<List<WebElement>> rowsWithColumns = getRowsWithColumn(); //
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = new ArrayList<Map<String, WebElement>>();
        Map<String, WebElement> rowByHeadings; // одна строка разбитая на столбцы по заголовкам
        List<WebElement> headingColumns = getHeadings(); // получаем заголовки

        for (List<WebElement> row : rowsWithColumns) { // пробегаемся по всем строкам
            rowByHeadings = new HashMap<String, WebElement>();
            for (int i = 0; i < headingColumns.size(); i++) {
                String heading = headingColumns.get(i).getText(); // получаем текст конкретного заголовка по индексу
                WebElement cell = row.get(i); // получаем ячейку из строки под конкретным заголовком
                rowByHeadings.put(heading, cell); // помещаем в мар ячейку и заголовок; кога пробежимся по всем заголовкам, то переходим на новую строку
            }
            rowsWithColumnsByHeadings.add(rowByHeadings);
        }
        return rowsWithColumnsByHeadings; // на выходе получаем список мар в котором: ключ-заголовок, значение - конкретная ячейка. привязали к заголовкам - ячейки
    }

    public String getValueFromCell(int rowNumber, int columnNumber) {
        List<List<WebElement>> rowsWithColumns = getRowsWithColumn();
        WebElement cell = rowsWithColumns.get(rowNumber - 1).get(columnNumber - 1);
        return cell.getText();
    }

    public String getValueFromCell(int rowNumber, String columnName) {
        List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings();
        return rowsWithColumnsByHeadings.get(rowNumber - 1).get(columnName).getText();
    }

}
