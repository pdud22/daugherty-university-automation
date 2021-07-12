package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IMDBResultsPage {

    @FindBy(css = ".result_text")
    public List<WebElement> results;

    @FindBy(css = ".title-section")
    public WebElement title;

    public IMDBResultsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
