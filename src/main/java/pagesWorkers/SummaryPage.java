package pagesWorkers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SummaryPage {
    /**
     * Конструктор без которого не будет работать, лол
     */
    public WebDriver driver;
    public SummaryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<WebElement> getRows(){
        return driver.findElements(By.className("summary-td-row-header"));
    }

    public List<WebElement> getCols(){
        return driver.findElements(By.className("summary-td-col-header"));
    }
}
