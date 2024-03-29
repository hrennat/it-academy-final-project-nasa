package ui.tests;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pageObjects.BenefitsToYouPage;
import ui.pageObjects.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class NasaLogoTest {


    private static Logger log = Logger.getLogger(NasaLogoTest.class);
    public static WebDriver driver;
    public static MainPage MainPage;
    public static BenefitsToYouPage BenefitsToYouPage;


    @BeforeEach
    public  void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.nasa.gov");

    }
    @Test()
    @Tag("Smoke")
    @Tag("Regression")
    public void testLogoExists() {
        MainPage = new MainPage(driver);
        log.info("testLogoExists is running");
        assertTrue(MainPage.logoDisplayed());

    }

    @Test()
    @Tag("Regression")
    public void testLogoReload()  {
        MainPage = new MainPage(driver);
        log.info("testLogoReload is running");
        assertTrue(MainPage.logoReload());

    }

    @Test()
    @Tag("Regression")
    public void testBenefitsToYouBackHomePage()  {
        MainPage = new MainPage(driver);
        log.info("testBenefitsToYouBackHomePage is running");
        BenefitsToYouPage = new BenefitsToYouPage(driver);
        MainPage.benefitsToYouClick();
        BenefitsToYouPage.benefitsToYouDisplayed();
        MainPage.logoReload();
        assertTrue(MainPage.logoReload());


    }

    @AfterEach
    public  void tearDown() {
        driver.quit();

    }
}
