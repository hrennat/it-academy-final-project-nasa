package ui.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.utilities.BaseClass;


public class MoonToMarsPage extends BaseClass {


    public MoonToMarsPage(WebDriver driver) {

        super(driver, wait);
        PageFactory.initElements(BaseClass.driver, this);
    }

    @FindBy(xpath = "//*[@id='ember43']")
    WebElement AboutMoonToMars;

    public boolean aboutMoonToMarsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement aboutMoonToMars = wait.until(ExpectedConditions.visibilityOf(AboutMoonToMars));
        boolean event = aboutMoonToMars.isDisplayed();
        return event;
    }

}