package com.itron;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

    WebDriver driver;
    private String url = "https://bhphotovideo.com";

    public LandingPage(WebDriver driver){

        this.driver = driver;
        this.driver.get(url);

        // Wait until shipping destination is occupied
        waitByShipDest();
    }

    public By shipDestBy() {    return By.cssSelector("span.shipDest"); }

    public void waitByShipDest(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.not(
                        ExpectedConditions.textToBe(shipDestBy(), "")));
    }

    public WebElement citySpan(){   return driver.findElement(shipDestBy()); }

    public WebElement zipInput(){   return driver.findElement(By.cssSelector("input.shippingZipInput")); }

    public WebElement zipButton() { return driver.findElement(By.cssSelector("div.shippingZipButton")); }

    public WebElement acctButton(){ return driver.findElement(By.cssSelector("div.user.login-account")); }

    public WebElement emailInput(){
        for(WebElement e : driver.findElements(By.cssSelector("input.fs16.material-text-input.js-materialTextInput"))){
            if(e != null && e.isDisplayed() && e.getAttribute("data-selenium").equals("emailAddress"))
                return e;
        }
        System.out.println("Email input not found!");
        return null;
    }

    public WebElement passInput(){
        for(WebElement e : driver.findElements(By.cssSelector("input.fs16.material-text-input.js-materialTextInput"))){
            if(e != null && e.isDisplayed() && e.getAttribute("data-selenium").equals("password"))
                return e;
        }
        System.out.println("Password input not found!");
        return null;
    }

    public WebElement loginButton(){
        for(WebElement e : driver.findElements(By.cssSelector("input.lf-primaryBtn"))){
            if(e != null && e.isDisplayed() && e.getAttribute("data-selenium").equals("submitBtn"))
                return e;
        }
        System.out.println("Log In button not found!");
        return null;
    }

    public WebElement errorMessage() {
        for(WebElement e : driver.findElements(By.cssSelector("label.m-error.lf-form-error"))){
            if(e != null)
                return e;
        }
        System.out.println("Error message not found!");
        return null;
    }
}
