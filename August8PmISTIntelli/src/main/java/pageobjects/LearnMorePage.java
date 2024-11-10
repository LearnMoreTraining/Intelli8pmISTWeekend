package pageobjects;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utlility.ExcelHandler;

import java.io.IOException;
import java.time.Duration;

public class LearnMorePage {
    WebDriver driver;
    public LearnMorePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickChangeTextButton(){
        driver.findElement(By.id("quote")).click(); //imp
    }

    public void enterProductName(String sheetname , int  row , int column) throws IOException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(ExcelHandler.readData(sheetname,row, column));
    }

    public void clickSearchIcon(){

        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    public String getChangeText(){
        String text;

        try{
            text =driver.findElement(By.xpath("//h3[text()='Hello, Learn More Aspirants']")).getText();

        } catch (NoSuchElementException e) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            wait.pollingEvery(Duration.ofSeconds(10));
            wait.ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Hello, Learn More Aspirants']")));
            text =driver.findElement(By.xpath("//h3[text()='Hello, Learn More Aspirants']")).getText();
        }
        return text;

    }

    public void dragAndDrop(){

        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        WebElement source = driver.findElement(By.id("draggable")); //5s
        WebElement target = driver.findElement(By.id("droppable"));
        Actions a = new Actions(driver);
        a.dragAndDrop(source,target).build().perform();

    }

    public void enter(){

    }
}
