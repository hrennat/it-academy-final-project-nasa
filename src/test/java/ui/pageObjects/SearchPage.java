package ui.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.utilities.BaseClass;


public class SearchPage extends BaseClass {


    public SearchPage(WebDriver driver) {

        super(driver, wait);
        PageFactory.initElements(BaseClass.driver, this);
    }

    @FindBy(xpath = "//*[@id='search-nav']/ul/li[1]")
    WebElement Everything;

    public boolean everythingDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement everything = wait.until(ExpectedConditions.visibilityOf(Everything));
        boolean event = everything.isDisplayed();
        return event;
    }

}