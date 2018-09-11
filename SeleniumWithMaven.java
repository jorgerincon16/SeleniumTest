import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SeleniumWithMaven {

   public static WebDriver driver = new ChromeDriver();
    String exePath = "C:\\Users\\mamurphy\\OneDrive - Itron\\Documents\\chromedriver.exe";
    String Link;

    public SeleniumWithMaven(String URL){
        Link = URL;
    }

    void start() {
        driver.get(Link);
    }

    public String getTitle() {
       return driver.getTitle();
    }

    void clickButton(String CSS){
        driver.findElement(By.cssSelector(CSS)).click();
    }

    void clickButtonXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    void TextField(String selector, String userInput) {
        WebElement textfield = driver.findElement(By.cssSelector(selector));
        textfield.sendKeys(userInput);
        textfield.sendKeys(Keys.DOWN);
        textfield.sendKeys(Keys.RETURN);
    }

    public List<WebElement> findElements(String CSS) {
        return driver.findElements(By.cssSelector(CSS));
    }

    void mouseOver(String CSS){
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.cssSelector(CSS));
        builder.moveToElement(element).perform();
    }

    void dropDown(String CSS){
        WebElement mySelectElement = driver.findElement(By.cssSelector(CSS));
        Select dropdown = new Select(mySelectElement);
    }

    public String currentURL(){
        return driver.getCurrentUrl();
    }

    public void close(){
        driver.close();
    }

}




/*
        System.setProperty("webdriver.chrome.driver", exePath);
        driver.get("https://www.phptravels.net/");
        String title = driver.getTitle();
        WebElement element = driver.findElement(By.cssSelector("#collapse > ul:nth-child(1) > li:nth-child(2) > a"));
        element.click();

        //WebElement TextField = driver.findElement(By.cssSelector("#s2id_autogen8 > a > span.select2-chosen"));
        //TextField.sendKeys("{}|:><?[].,/");


        System.out.println(title);
        driver.close();

    }

}
*/
