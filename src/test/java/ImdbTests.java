import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


/**
 * Created by Shree on 05-May-16.
 */
public class ImdbTests {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
        driver = new HtmlUnitDriver();
        baseUrl = "http://www.imdb.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testImdbTests() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.id("navbar-query")).clear();
        driver.findElement(By.id("navbar-query")).sendKeys("blade runner");
        driver.findElement(By.id("navbar-submit-button")).click();
        driver.findElement(By.linkText("Blade Runner")).click();
        assertEquals("Blade Runner (1982) - IMDb", driver.getTitle());
    }

    @Test
    public void testSite() throws Exception {
        driver.get("http://localhost:8080/Viswa.html");
        assertEquals("Professonial Webpage", driver.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();

    }
}
