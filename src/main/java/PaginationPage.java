import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PaginationPage {

    public PaginationPage(WebDriver driver){
        this.driver = driver;
    }

    WebDriver driver;


    private final String URL = "https://demo.seleniumeasy.com/table-pagination-demo.html";

    private final By findRows = By.xpath("//*[@id='myTable']/tr[@style='display: table-row;']");

    private final By nextArrow = By.xpath("//*[@class='next_link']");


    public void navigate(){
        driver.navigate().to(URL);
    }

    public void clickOnNextArrow(){
        driver.findElement(nextArrow).click();
    }

    public boolean isClickableNextArrow(){
        WebElement nextArrowResult = driver.findElement(nextArrow);
                String attribute = nextArrowResult.getAttribute("style");
        return !attribute.equals("display: none;");
    }

    public void getNumbersFromTable(List<Integer> numbersList){
        List<WebElement> tableRows = driver.findElements(findRows);
        for (WebElement row : tableRows){
            WebElement td = row.findElement(By.xpath("./td[1]"));
            Integer value = Integer.valueOf(td.getText());
            numbersList.add(value);
        }
    }

}
