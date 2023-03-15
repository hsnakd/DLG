package com.dlg.step_definitions;

import com.dlg.pages.dlgPage;
import com.dlg.utilities.BrowserUtils;
import com.dlg.utilities.ConfigurationReader;
import com.dlg.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class dlg_SD {
    dlgPage dlgPage = new dlgPage();


    @Given("navigate to homepage")
    public void navigateToHomepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


    @When("user on the homepage")
    public void userOnTheHomepage() {
        dlgPage.acceptCookies.click();
        dlgPage.closeInfo.click();
        String expectedUrl = "https://www.directlinegroup.co.uk/en/index.html";
        String currentUrl = Driver.getDriver().getCurrentUrl();
        assertEquals(expectedUrl,currentUrl);
    }


    @And("User should see there are {int} headings at the top of the page")
    public void userShouldSeeThereAreHeadingsAtTheTopOfThePage(int expectedNumber) {
        int actualNumber = dlgPage.headers.size();
        assertEquals(expectedNumber,actualNumber);
    }


    @Then("Verify {string} headers at the top of the page")
    public void verifyHeadersAtTheTopOfThePage(String title) {
        String expectedTitle1 = "Who We Are";
        String expectedTitle2 = "Brands";
        String expectedTitle3 = "Investors";
        String expectedTitle4 = "Sustainability";
        String expectedTitle5 = "Insights";
        String expectedTitle6 = "News & Media";

        String actualTitle1 = dlgPage.whoWeAre.getText();
        String actualTitle2 = dlgPage.brands.getText();
        String actualTitle3 = dlgPage.investors.getText();
        String actualTitle4 = dlgPage.sustainability.getText();
        String actualTitle5 = dlgPage.insights.getText();
        String actualTitle6 = dlgPage.news.getText();

        assertEquals(expectedTitle1,actualTitle1);
        assertEquals(expectedTitle2,actualTitle2);
        assertEquals(expectedTitle3,actualTitle3);
        assertEquals(expectedTitle4,actualTitle4);
        assertEquals(expectedTitle5,actualTitle5);
        assertEquals(expectedTitle6,actualTitle6);
    }


    @Then("Verify following headers at the top of the page with list")
    public void verifyFollowingHeadersAtTheTopOfThePageWithList(List<String> expectedHeaders) {
        List<String> actualHeaders = BrowserUtils.getElementsText(dlgPage.headers);
        System.out.println("expectedHeader = " + expectedHeaders);
        System.out.println("actualHeaders = " + actualHeaders);

        assertEquals(expectedHeaders, actualHeaders);

//        assertTrue(expectedHeaders.containsAll(actualHeaders));



    }

    @And("user types {string} in the search box")
    public void userTypesInTheSearchBox(String searchKeyword) {
        BrowserUtils.waitFor(5);

        dlgPage.searchBox.click();
        BrowserUtils.waitFor(5);

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(dlgPage.searchBox).click().sendKeys(searchKeyword).build().perform();
//        dlgPage.searchSign.click();
    }


    @And("user click the search sign")
    public void userClickTheSearchSign() {
        dlgPage.searchSign.click();
    }


    @Then("Check {string} in the search results")
    public void checkInTheSearchResults(String sendKey) {

        BrowserUtils.waitFor(5);

        String expectedResult = sendKey + " - Who We Are";
        String actualResult = dlgPage.resultTitle.getText();
        System.out.println("actualResult = " + actualResult);
//        String actualResult = dlgPage.resultTitleCheck.getText();

        assertEquals(expectedResult, actualResult);


    }



}
