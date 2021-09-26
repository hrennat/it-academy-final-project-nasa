package ui.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.utilities.BaseClass;

import java.util.ArrayList;
import java.util.List;

public class BenefitsToYouPage extends BaseClass {
    public BenefitsToYouPage(WebDriver driver) {

        super(driver, wait);
        PageFactory.initElements(BaseClass.driver, this);
    }

    @FindBy(xpath = "//*[@id='landing-page-banner']/h1")
    WebElement BenefitsToYou;
    @FindBy(xpath = "//*[@id='atftbx']/div/a[1]")
    WebElement FacebookIcon;

    public boolean benefitsToYouDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement benefitsToYou = wait.until(ExpectedConditions.visibilityOf(BenefitsToYou));
        boolean event = benefitsToYou.isDisplayed();
        return event;
    }

    public void facebookIconClick()  {
        WebDriverWait wait = new WebDriverWait(driver, 20);
       WebElement facebookIcon= wait.until(ExpectedConditions.visibilityOf(FacebookIcon));
        facebookIcon.click();

    }
    public void followFacebook(){
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs .get(1));

    }
}
