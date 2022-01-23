package pagesWorkers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    /**
     * Конструктор без которого не будет работать, лол
     */
    public WebDriver driver;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Находим поле логина
     */
    @FindBy(xpath = "//*[contains(@id, 'UserName')]")
    private WebElement loginField;

    /**
     * Находим поле пароля
     */
    @FindBy(xpath = "//*[contains(@id, 'Password')]")
    private WebElement passwordField;

    /**
     * Находим кнопочку
     */
    @FindBy(xpath = "/html/body/div/div/div/form/div[3]/button")
    private WebElement loginButton;

    /**
     * Метод ввода логина
     * @param login
     */
    public void inputLogin(String login){
        loginField.sendKeys(login);
    }

    /**
     * метод ввода пароля
     * @param password пароль
     */
    public void inputPass(String password){
        passwordField.sendKeys(password);
    }

    /**
     * Метод нажатия кнопки входа
     */
    public void clickLoginButton(){
        loginButton.click();
    }
}