package pagesWorkers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    /**
     * Конструктор без которого не будет работать, лол
     */
    public WebDriver driver;
    public ProfilePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Находим, кто это у нас такой красивый, сейчас получит незачет :D
     */
    @FindBy(xpath = "//*[contains(@href, '/bars_web/Service/RefreshPermissions')]")
    private WebElement userName;

    @FindBy(xpath = "//*[contains(@href, '/bars_web/Auth/Exit')]")
    private WebElement logoutBotton;

    @FindBy(xpath = "//*[contains(@href, '/bars_web/ST_Study/Main/Summary?studentID')]")
    private WebElement SvodkaButton;

    /**
     * Получаем имя пользователя
     */
    public String getUserName(){
        return userName.getText();
    }

    /**
     * Метод для выхода
     */
    public void userLogout(){
        logoutBotton.click();
    }

    public void goToSvodka(){
        SvodkaButton.click();
    }

    public String getUserId(){
        return driver.getCurrentUrl().substring(59);
    }
}
