package com.stepDefinitions;

import com.Models.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginLogoutDef extends TestBase {

    HomePage home;
    SignInPage signInPage;
    SearchProductPage productPage;
    CartPage cartPage;

    @Given("I open the application")
    public void i_open_the_application() throws InterruptedException {
        home = new HomePage(driver);
        home.openApplication();
    }

    @Then("I click on sign in button and wait for sign in page")
    public void i_click_on_sign_in_button_and_wait_for_sign_in_page() {
        signInPage = home.clickOnSignIn();
    }

    @Then("I should see Sign In Page")
    public void i_should_see_sign_in_page() {
        signInPage.verifySignPage();
    }

    @When("I enter username as {string}")
    public void i_enter_username_as(String email) throws InterruptedException {
        signInPage.enterEmail(email);
    }

    @When("I Click on Continue button")
    public void i_click_on_continue_button() throws InterruptedException {
        signInPage.clickOnContinueBtn();
    }

    @When("I enter password as {string}")
    public void i_enter_password_as(String pwd) throws InterruptedException {
        signInPage.enterPwd(pwd);
    }

    @And("click on signin button")
    public void clickOnSigninButton() throws InterruptedException {
        home = signInPage.clickOnSignInBtn();
    }

    @Then("I am logged in and should see homepage")
    public void i_am_logged_in_and_should_see_homepage() throws InterruptedException {
        home.verifyHomePage("Amit");
    }

    @Then("I search {string}")
    public void iSearch(String product) throws InterruptedException {
        productPage = home.searchProduct(product);
    }

    @Then("I click on second watch and click on add to cart and increase the quantity to {int}")
    public void iClickOnSecondWatchAndClickOnAddToCartAndIncreaseTheQuantityTo(int quantity) throws InterruptedException {
        cartPage = productPage.addWatch();
        cartPage.addQuantity(quantity);
    }

    @Then("I search {string} and click on first item and add to cart")
    public void iSearchAndClickOnFirstItemAndAddToCart(String product) throws InterruptedException {
        productPage = home.searchProduct(product);
        cartPage = productPage.addPhone();
    }

    @Then("I Select cart from home and reduce the Smartwatches quantity by {int}")
    public void iSelectCartFromHomeAndReduceTheSmartwatchesQuantityBy(int quantity) throws InterruptedException {
        cartPage.removeQuantity(quantity);
        cartPage.printSubTotal();
    }

    @Then("I verify proceed to buy button")
    public void iClickProceedToBuyButton() {
        cartPage.verfiyProceedToBuy();
    }

    @Then("I Click on Sign out")
    public void i_click_on_sign_out() {

    }

    @Then("I got log out from the application and land on sign in page")
    public void i_got_log_out_from_the_application_and_land_on_sign_in_page() {

    }

}
