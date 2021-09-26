package ui.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.utilities.BaseClass;


public class EarthPage extends BaseClass {


    public EarthPage(WebDriver driver) {

        super(driver, wait);
        PageFactory.initElements(BaseClass.driver, this);
    }

    @FindBy(xpath = "//*[@id='ember43']")
    WebElement EarthTopics;

    public boolean earthTopicsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement earthTopics = wait.until(ExpectedConditions.visibilityOf(EarthTopics));
        boolean event = earthTopics.isDisplayed();
        return event;
    }

}