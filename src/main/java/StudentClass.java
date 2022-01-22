import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentClass {
    public static String userId;
    public static Integer subjectsNum;
    public static Integer weeksNum;
    public static ArrayList<String> colsStr;
    public static ArrayList<String> rowsStr;
    public static ArrayList<ArrayList<String>> marks;

    public void rowsImporter(List<WebElement> rowsElems){
        subjectsNum = rowsElems.size() / 2;
        rowsStr = new ArrayList<>();
        for (int i = 0; i < subjectsNum; i++){
            rowsStr.add(rowsElems.get(i).getText());
        }
    }

    public void colsImporter(List<WebElement> colsElems){
        weeksNum = colsElems.size() / 2 - 14;
        colsStr= new ArrayList<>();
        for (WebElement e: colsElems){
            colsStr.add(e.getText());
        }
    }

    public static void makeMarksMatrix(WebDriver driver){
        marks = new ArrayList<>();
        for (int i = 0; i < subjectsNum; i++){
            marks.add(new ArrayList<>());
            for (int j = 0; j < weeksNum; j++){
                String tmp = cellString(i, j);
                WebElement cell = driver.findElement(By.xpath(tmp));
                marks.get(i).add(cell.getText());
            }
        }
    }

    private static String cellString(Integer subj, Integer week){
        Integer t1 = subj + 1;
        Integer t2 = week + 2;
        StringBuilder inpStr = new StringBuilder("//*[@id=\"tableMarkSummary\"]/tbody/tr[_]/td[_]");
        inpStr.replace(37, 38, t1.toString());
        inpStr.replace(43, 44, t2.toString());
        return inpStr.toString();
    }

    public static void saveMarksInFile() throws IOException {
        FileWriter mrWriter = new FileWriter("marks.txt", true);
        Date date = new Date();
        mrWriter.write(date.toString() + "\n");
        for (int i = 0; i < subjectsNum; i++){
            mrWriter.write(rowsStr.get(i)+": ");
            for (int j = 0; j < weeksNum; j++)
                mrWriter.write(marks.get(i).get(j) + " ");
            mrWriter.write("\n");
        }
        mrWriter.write("\n");
        mrWriter.flush();
    }
}
