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

import static org.junit.Assert.assertTrue;

public class MainPage extends BaseClass {




    public MainPage(WebDriver driver) {

        super(driver, wait);
        PageFactory.initElements(BaseClass.driver, this);
    }
 //   WebDriverWait wait = new WebDriverWait(driver, 20);

    @FindBy(className= "logo")
    WebElement logo;

    @FindBy(className = "no-countdown")
    WebElement header2;

    @FindBy(xpath = "//*[@id='nasa-main-menu']/li[1]/ul/li[1]/a")
    WebElement HumanInSpace;
    @FindBy(xpath = "//*[@id='nasa-main-menu']/li[1]/ul/li[2]/a")
    WebElement MoonToMars;
    @FindBy(xpath = "//*[@id='nasa-main-menu']/li[1]/ul/li[3]/a")
    WebElement Earth;
    @FindBy(xpath = "//*[@id='nasa-main-menu']/li[1]/ul/li[9]/a")
    WebElement BenefitsToYou;
    @FindBy(xpath = "//*[@id='nasa-main-menu']/li[1]/ul")
    WebElement uLElement;
    @FindBy(className = "dropdown")
    List <WebElement> dropdown;
    @FindBy(name = "query")
    WebElement searchInput;



    public boolean logoDisplayed ()
    {
        boolean Logo = logo.isDisplayed();
        return Logo;

    }

    public boolean logoReload() {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        logo.click();
        boolean event = wait.until(ExpectedConditions.visibilityOf(header2)).isDisplayed();
        return event;

    }


    public void moonToMarsClick()  {
        MoonToMars.click();

    }

    public void earthClick()  {
        Earth.click();

    }
    public void benefitsToYouClick()  {
        BenefitsToYou.click();

    }


    public List<String> findTopics() {
               WebElement ul_element = uLElement;
        List<WebElement> top= ul_element.findElements(By.tagName("li"));
        List<String> Top =  new ArrayList<>();
        for (int i = 1; i < top.size(); i++)
        {

            String text = top.get(i).getText();
             if(text != null && !text.trim().isEmpty()){



                    Top.add(text);}
        }
        Top.add(0, HumanInSpace.getText());
        return Top;
    }

    public List<String> createListByTopics (){
        List<String> Topics =  new ArrayList<String>();
        Topics.add("Humans in Space");
        Topics.add("Moon to Mars");
        Topics.add("Earth");
        Topics.add("Space Tech");
        Topics.add("Flight");
        Topics.add("Solar System and Beyond");
        Topics.add("STEM Engagement");
        Topics.add("History");
        Topics.add("Benefits to You");
        return Topics;

    }

    public List<String> findDropdown() {

        List <WebElement> dd=  dropdown;
        List<String> Dropdown =  new ArrayList<>();
        for (int i = 1; i < dd.size(); i++)
        {

            String text = dd.get(i).getText();
            Dropdown.add(text);
        }
        return Dropdown;
    }
    public List<String> createListByDropdown (){
        List<String> headers =  new ArrayList<String>();
        headers.add("Missions");
        headers.add("Galleries");
        headers.add("NASA TV");
        headers.add("Follow NASA");
        headers.add("Downloads");
        headers.add("About");
        headers.add("NASA Audiences");
        return headers;

    }

    public void search()  {
        searchInput.sendKeys("test"+ "\n");

    }



}