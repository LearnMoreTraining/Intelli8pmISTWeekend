package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utlility.Base64Decoder;
import utlility.ExcelHandler;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class AmazonHomePage {

    WebDriver driver;
    WebElement categoryElement;//null know

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void handleDropdown() {
        categoryElement = driver.findElement(By.xpath("//div[@id='nav-search-dropdown-card']/child::div/child::select"));
        Select category = new Select(categoryElement);
        //  category.selectByIndex(10);
        //  category.selectByVisibleText("Clothing & Accessories");
        category.selectByValue("search-alias=automotive");

    }

    public void extractDropdownValue() {
        int categorySize = categoryElement.findElements(By.tagName("option")).size();

        for (int i = 0; i < categorySize; i++) {
            String value = categoryElement.findElements(By.tagName("option")).get(i).getText();
            System.out.println(value);
        }
    }

    public void enterProductName(String productName) {

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(productName);
        //  driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(productName);
        //  driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(productName);
        // driver.findElement(By.className("nav-input nav-progressive-attribute")).sendKeys(productName);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].SetAttribute('value','iphone')", driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")));

        jse.executeScript("window.scrollBy(300,0)", "");
    }

    public void enterProductName(String sheetname, int row, int column) throws IOException {
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(ExcelHandler.readData(sheetname, row, column));

    }

    public void clickSearchIcon() {

        driver.findElement(By.id("nav-search-submit-button")).click(); //ElementInterceptedExecuion
    }

    public void hoverAccountAndList() {
        WebElement accountElement = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Actions a = new Actions(driver);
        a.clickAndHold(accountElement).build().perform();

    }

    public void clickBabyWishList() {
        //  driver.findElement(By.xpath("//span[text()='Baby Wishlist']")).click();
        driver.findElement(By.partialLinkText("by..iytt")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));

        Set<String> winProperties = driver.getWindowHandles();
        Iterator<String> i = winProperties.iterator();
        String parentWin = i.next(); // 0
        String childWinProperty = i.next(); //1
        driver.switchTo().window(childWinProperty);
        System.out.println(winProperties);

    }

    public void m1() {
        driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_OneWay")).sendKeys(Base64Decoder.getDecodeValue("Password2"));
    }






}
