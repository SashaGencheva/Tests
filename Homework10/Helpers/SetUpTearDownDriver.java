package Homework10.Helpers;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class SetUpTearDownDriver {
    public WebDriver driver;

    @Before
    public void setUp() {
        driver = BrowserFactory.getBrowser("Chrome");
    }

    @After
    public void tearDown() {
        BrowserFactory.closeBrowser();
    }
}