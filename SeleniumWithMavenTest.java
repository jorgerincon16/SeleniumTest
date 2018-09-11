import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class SeleniumWithMavenTest {

    static SeleniumWithMaven page = new SeleniumWithMaven("https://www.phptravels.net/en");

    @BeforeAll
    public static void setUp(){
        page.start();
    }

    @Test
    public void NavButtons() {
        page.clickButton("#collapse > ul:nth-child(1) > li:nth-child(2) > a");                //Navbar buttons
        page.clickButton("#collapse > ul:nth-child(1) > li:nth-child(3) > a");
        page.clickButton("#collapse > ul:nth-child(1) > li:nth-child(4) > a");
        page.clickButton("#collapse > ul:nth-child(1) > li:nth-child(5) > a");
        page.clickButton("#collapse > ul:nth-child(1) > li:nth-child(6) > a");
        page.clickButton("#collapse > ul:nth-child(1) > li:nth-child(7) > a");
        page.clickButton("#collapse > ul:nth-child(1) > li:nth-child(8) > a");
        page.clickButton("#collapse > ul:nth-child(1) > li:nth-child(1) > a");
        page.getTitle();
        System.out.println( page.getTitle());
        System.out.println(page.currentURL());
    }

    @Test
    public void AssertHomePageTitle(){
        assertTrue(page.getTitle().equals("PHPTRAVELS | Travel Technology Partner"));
    }

    @Test
    public void textField(){
        page.clickButton("#s2id_autogen8 > a > span.select2-chosen");
        page.TextField("#select2-drop > div > input", "Dublin");

        //page.clickButton("#collapse > ul.nav.navbar-nav.navbar-right > ul > li.dropdown > ul > li:nth-child(7) > a");
        //page.clickButton("#HOTELS > form > div.col-md-2.form-group.go-right.col-xs-12.search-button > button"); //search button
    }

    @Test
    void findHiddenElements(){
        page.mouseOver("#collapse > ul.nav.navbar-nav.navbar-right > ul > li.dropdown > a"); //currency button
        List<WebElement> element = page.findElements("#collapse > ul.nav.navbar-nav.navbar-right > ul > li.dropdown");
        for(int i=0; i<element.size(); i++ ){
            if (element.get(i).getText().equalsIgnoreCase("USD")){
                System.out.println(i);
            }
            System.out.println(element.get(i).getText()+i);
    }
        //element.get(1).click();
    }

    @AfterAll
    public static void CloseBrowser(){
        page.close();
    }
}



/*
    @BeforeEach
    public void TestSetUp(){
        //String exePath = "C:\\Users\\mamurphy\\OneDrive - Itron\\Documents\\chromedriver.exe";
        //System.setProperty("webdriver.chrome.driver", exePath);
        //driver.get("https://www.phptravels.net/");
    }
*/
