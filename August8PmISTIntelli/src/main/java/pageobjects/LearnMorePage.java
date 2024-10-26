package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LearnMorePage {

        WebDriver driver;
    public LearnMorePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickChangeTextButton(){
        driver.findElement(By.id("quote")).click(); //imp
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
}
