package stepdefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pageobjects.AmazonHomePage;
import pageobjects.SearchResultPage;
import utlility.BrowserBase;
import utlility.PageObjectManager;
import utlility.TestContext;

import java.io.IOException;

public class AmazonSteps {

   TestContext context;
    public AmazonSteps(TestContext context) throws IOException {

        this.context = context;
    }

    @Then("user validate the title of the page")
    public void userValidateTheTitleOfThePage() {
      String title =  context.pageObjectManager.getSearchResultPage().getTitleOfSearchResultPage();
        System.out.println(title);
    }
    
    @And("user clicks the search icon")
    public void clickSearchIcon(){
    context.pageObjectManager.getAmazonHomePage().clickSearchIcon();


    }


    @And("user validate the search results")
    public void userValidateTheSearchResults() {
        
    }

    @When("user click baby wish list option from Account menu")
    public void userClickBabyWishListOptionFromAccountMenu() {
        context. pageObjectManager.getAmazonHomePage().hoverAccountAndList();
        context. pageObjectManager.getAmazonHomePage().clickBabyWishList();
    }

    @Then("validate the navigation")
    public void validateTheNavigation() {

        Assert.assertEquals("Baby Wishlist",context.pageObjectManager.getBabyWishListPage().getBabyText());

        Assert.assertTrue(context.pageObjectManager.getAmazonHomePage().m1());
        Assert.assertFalse(context.pageObjectManager.getAmazonHomePage().m1());
    }

    @When("user enter the product name {string}")
    public void userEnterTheProductName(String productName) throws IOException {

        context.pageObjectManager.getAmazonHomePage().enterProductName(productName);

    }

    @Then("verify whether the user navigates to the homepage")
    public void verifyWhetherTheUserNavigatesToTheHomepage() {

    }

    @When("user select the dropdown value from category dropdown")
    public void handleDropdown() {
        context.pageObjectManager.getAmazonHomePage().handleDropdown();
    }

    @And("user extracts the dropdown values")
    public void userExtractsTheDropdownValues() {
        context.pageObjectManager.getAmazonHomePage().extractDropdownValue();
    }

    @Then("validate the dropdown values")
    public void validateTheDropdownValues() {

    }


}
