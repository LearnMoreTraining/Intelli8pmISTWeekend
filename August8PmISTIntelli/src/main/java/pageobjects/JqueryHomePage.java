package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JqueryHomePage {

    WebDriver driver;
    public JqueryHomePage(WebDriver driver){
        this.driver = driver ;
    }

    public void dragAndDrop(){

        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        WebElement source = driver.findElement(By.id("draggable")); //5s
        WebElement target = driver.findElement(By.id("droppable"));
        Actions a = new Actions(driver);
        a.dragAndDrop(source,target).build().perform();

    }

    public void getDroppedText(){

    }
}
