package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;

public class TestContext {

    private final WebDriver webDriver;

    public TestContext() {
        String OS = System.getProperty("os.name");
        if (OS.startsWith("Windows")) {
            System.setProperty("webdriver.chrome.driver", Paths.get("src/test/resources/chromedriver_win32/chromedriver.exe").toString());
        }
        this.webDriver = new ChromeDriver(new ChromeOptions());
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
