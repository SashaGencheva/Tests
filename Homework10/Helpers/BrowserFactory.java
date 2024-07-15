package Homework10.Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
    public static WebDriver driver = null;
    protected static String testUrl = "https://www.techlistic.com/p/selenium-practice-form.html?m=1";

    //Factory method for getting browsers
    public static WebDriver getBrowser(String browserName) {
        switch (browserName) {
            case "Chrome":
                if (driver == null) {
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\digger\\IdeaProjects\\JQALearn\\src\\main\\resources\\drivers\\chromedriver.exe");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                }
                break;

            case "Firefox":
                if (driver == null) {
                    System.setProperty("webdriver.gecko.driver", "C:\\Users\\digger\\IdeaProjects\\JQALearn\\src\\main\\resources\\drivers\\geckodriver.exe");
                    FirefoxOptions options = new FirefoxOptions();
                    options.setLegacy(true);
                    driver = new FirefoxDriver(options);
                }
                break;

            case "Edge":
                if (driver == null) {
                    System.setProperty("webdriver.edge.driver", "C:\\Users\\digger\\IdeaProjects\\JQALearn\\src\\main\\resources\\drivers\\msedgedriver.exe");
                    driver = new EdgeDriver();
                }
                break;
            default:
                throw new IllegalArgumentException("The browser type " + browserName + " is not defined");
        }
        driver.manage().window().maximize();
        driver.get(testUrl);
        return driver;
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}