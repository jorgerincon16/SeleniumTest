package com.itron;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.*;

public class TestCases {

    public static WebDriver driver;
    public LandingPage landingPage;

    @BeforeClass
    public static void beforeAll() {
        driver = new ChromeDriver();
    }

    @Before
    public void beforeEach() {
        driver.get("https://bhphotovideo.com");
        landingPage = new LandingPage(driver);
    }

    @Test
    public void freeShippingCityShouldNotBeBlank() {
        assertThat(landingPage.citySpan().getText()).isNotEmpty();
    }

    @Test
    public void freeShippingLabelCityShouldShowSanMarcosFor78666() {

        // When changing the ZIP to 78666
        landingPage.citySpan().click();
        landingPage.zipInput().sendKeys("78666");
        landingPage.zipButton().click();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.not(
                        ExpectedConditions.textToBe(landingPage.shipDestBy(), "San Antonio")));

        // The shipping destination should change to San Marcos
        assertThat(landingPage.citySpan().getText()).isEqualTo("San Marcos");
    }

    @Test
    public void loginShouldFailWithBogusAccount() throws InterruptedException {
        //Navigate to My Account dropdown/button
        landingPage.acctButton().click();

        //Insert phony password

        // FIX BELOW LINE! NOT PICKING THE RIGHT ELEMENT, AS PER UZHE...
        Thread.sleep(2000);
        landingPage.emailInput().sendKeys("admin@bhphotovideo.com");
        landingPage.passInput().sendKeys("admin");
        landingPage.loginButton().click();
        assertThat(landingPage.errorMessage().getText().equals("Incorrect email address or password"));
    }

    //@BeforeClass
    //public void setUp(){
    //driver = new ChromeDriver();
    //driver.get("www.google.com");
    //LandingPage landingPage = new LandingPage(driver);

    //}

    @AfterClass
    public static void afterAll() {
        driver.quit();
    }
}
