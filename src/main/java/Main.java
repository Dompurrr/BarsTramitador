import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pagesWorkers.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static SummaryPage summaryPage;
    public static WebDriver driver;
    private static StudentClass user;
    private static Integer timeout;

    public static void main(String[] args) {
        System.out.println("Bars Tramitador. test-0.1");
        System.out.println("Made by Dompurrr <3");
        System.out.println("Привет");
        System.out.println("Проверь что ввел все данные в конфиг (resources/conf.properties). Формат каждой строки:");
        System.out.println("Параметр = значение");
        System.out.println("Необходимы: login, password, timeout (минимальный 10 секунд)");
        System.out.println("Проверил? Запускаем? Y/N");
        Scanner inp = new Scanner(System.in);
        String readyStatus = inp.next();
        if (!readyStatus.equals("Y")){
            System.out.println("Не готов, значит иди пиши, чини.");
            System.out.println("\"До связи\"");
            return;
        }
        setup();
        loginInBars();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dataCollector();
        tramitador();
        tearDown();
        try {
            user.saveMarksInFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        summaryPage = new SummaryPage(driver);
        user = new StudentClass();
        driver.manage().window().maximize();
        driver.get(ConfProperties.getProperty("loginpage"));
        timeout = Integer.parseInt(ConfProperties.getProperty("timeout"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void tearDown(){
        profilePage.userLogout();
        driver.quit();
    }

    private static void loginInBars(){
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPass(ConfProperties.getProperty("password"));
        loginPage.clickLoginButton();
    }

    private static void dataCollector(){
        user.userId = profilePage.getUserId();
        profilePage.goToSvodka();
        List<WebElement> SummaryRows = summaryPage.getRows();
        user.rowsImporter(SummaryRows);
        System.out.println("INFO: Number of subjects: " + user.subjectsNum);
        List<WebElement> SummaryCols = summaryPage.getCols();
        user.colsImporter(SummaryCols);
        System.out.println("INFO: Number of weeks: " + user.weeksNum);
        user.makeMarksMatrix(driver);
    }

    private static void tramitador(){
        boolean work = true;
        int counter = 0;
        while (work){
            try {
                Thread.sleep(timeout * 1000);
                driver.navigate().refresh();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (counter < 2) counter++;
            else work = false;
        }
    }
}