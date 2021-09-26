package ui.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.utilities.BaseClass;

import java.beans.Visibility;
import java.util.ArrayList;
import java.util.List;

public class FacebookPage extends BaseClass {
    public FacebookPage(WebDriver driver) {

        super(driver, wait);
        PageFactory.initElements(BaseClass.driver, this);
    }

    @FindBy(xpath = "//*[@id='blueBarDOMInspector']/div/div/div/div[1]/a/i")
    WebElement Facebook;


    public String facebookPage(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
       WebElement facebook= wait.until(ExpectedConditions.visibilityOf(Facebook));
        String name = facebook.getText();
       System.out.println(name);
       return name;

    }
}
