package ui.tests;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pageObjects.EarthPage;
import ui.pageObjects.MainPage;
import ui.pageObjects.MoonToMarsPage;
import ui.pageObjects.SearchPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MainPageTest {

    public static Logger log = Logger.getLogger(MainPageTest.class);
    public static WebDriver driver;
    private WebDriverWait wait;
    public static MainPage MainPage;
    public static MoonToMarsPage MoonToMarsPage;
    public static EarthPage EarthPage;
    public static SearchPage SearchPage;





    @BeforeEach
    public  void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.nasa.gov");

    }

    @Test()
    @Tag("Smoke")
    public void testMoonToMars()  {
        MainPage = new MainPage(driver);
        MoonToMarsPage = new MoonToMarsPage(driver);
        MainPage.moonToMarsClick();
        log.info("testMoonToMars is running");
        assertTrue(MoonToMarsPage.aboutMoonToMarsDisplayed());

    }

    @Test()
    @Tag("Smoke")
    public void testEarth()  {

        MainPage = new MainPage(driver);
        EarthPage = new EarthPage(driver);
        MainPage.earthClick();
        log.info("testEarth is running");
        assertTrue(EarthPage.earthTopicsDisplayed());
    }

    @Test()
    @Tag("Smoke")
    public void testTopics()  {
        MainPage = new MainPage(driver);
        List<String> Top =  MainPage.findTopics();
        List<String> Topics = MainPage.createListByTopics();
        log.info("testTopics is running");
        assertEquals(Topics, Top);
    }

    @Test()
    @Tag("Smoke")
    public void testDropdown()  {
        MainPage = new MainPage(driver);
        List<String> Dropdown =  MainPage.findDropdown();
        List<String> headers = MainPage.createListByDropdown();
        log.info("testDropdown is running");
        assertEquals(headers, Dropdown);

    }

    @Test()
    @Tag("Smoke")
    public void testSearch()  {

        MainPage = new MainPage(driver);
        SearchPage = new SearchPage(driver);
        MainPage.search();
        log.info("testSearch is running");
        assertTrue(SearchPage.everythingDisplayed());


    }

    @AfterEach
    public  void tearDown() {
        driver.quit();

    }
}
