package ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ui.pageObjects.BenefitsToYouPage;
import ui.pageObjects.FacebookPage;
import ui.pageObjects.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BenefitsToYouPageTest {

    private static Logger log = Logger.getLogger(BenefitsToYouPageTest.class);
    public static WebDriver driver;
    public static MainPage MainPage;
    public static BenefitsToYouPage BenefitsToYouPage;
    public static FacebookPage FacebookPage;


    @BeforeAll
    public static void infoMsgBefore(){

            log.info("Test execution for BenefitsToYouPage has been started.");}
    @BeforeEach
    public  void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.nasa.gov");


    }
    @Test()
    @Tag("EndToEnd")
    public void testFacebookFromBenefitsToYouPage()  {
        MainPage = new MainPage(driver);
        BenefitsToYouPage = new BenefitsToYouPage(driver);
        FacebookPage = new FacebookPage(driver);
        MainPage.benefitsToYouClick();
        BenefitsToYouPage.benefitsToYouDisplayed();
        BenefitsToYouPage.facebookIconClick();
        BenefitsToYouPage.followFacebook();
        log.info("testFacebookFromBenefitsToYouPage is running");
       assertEquals("Facebook", FacebookPage.facebookPage());


    }
    @AfterEach
    public  void tearDown() {
        driver.quit();
    }
    @AfterAll
    public static void infoMsgAfter(){
        log.info("Test execution for BenefitsToYouPage has been completed.");}
}
