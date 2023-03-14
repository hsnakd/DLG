package com.dlg.pages;

import com.dlg.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.List;

public class dlgPage {
    //#1-Create constructor and instantiate driver and object of the class

    public dlgPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@id='who-we-are']")
    public WebElement homePage;

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptCookies;

    @FindBy(xpath = "//ul[@class=\"primary-menu \"]/li")
    public List<WebElement> headers;

    @FindBy(xpath = "//li[@id='who-we-are']")
    public WebElement whoWeAre;

    @FindBy(id = "brands")
    public WebElement brands;

    @FindBy(id = "investors")
    public WebElement investors;

    @FindBy(id = "sustainability")
    public WebElement sustainability;

    @FindBy(id = "insights")
    public WebElement insights;

    @FindBy(id = "news")
    public WebElement news;

    @FindBy(xpath = "(//input[@role='searchbox'])[1]")
    public WebElement searchBox;

    @FindBy(xpath = "(//input[@type='submit'])[1]")
    public WebElement searchSign;

}
