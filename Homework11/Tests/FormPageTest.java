package Homework11.Tests;

import Homework11.Helpers.SetUpTearDownDriver;
import Homework11.Pages.FormPage;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

public class FormPageTest extends SetUpTearDownDriver {
    FormPage formPage;

    @Test
    public void verifyPracticeForm() {
        formPage = new FormPage(driver);

        formPage.openUrl("https://www.techlistic.com/p/selenium-practice-form.html");

        //Accept cookies (button)
        formPage.clickOnAcceptCookiesBtn();

        //Enter First name (text box)
        formPage.setFirstName("John");

        //Enter Last name (text box)
        formPage.setLastName("Smith");

        //Select Gender (radio button)
        formPage.selectGender("Male");

        //Select Years of Experience (radio button)
        formPage.selectYearsOfExperience("3");

        //Scroll down the webpage by 1000 pixels
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,1000)");

        //Enter Date
        formPage.setDate("28-11-24");

        //Select Profession (checkbox)
        formPage.selectProfession("Automation Tester");

        //Select Automation tools you are familiar with (multiple checkboxes)
        formPage.selectAutomationToolByActions("Protractor");
        formPage.selectAutomationToolByActions("Selenium WebDriver");

        //Select Continent (select box)
        formPage.selectContinent("Europe");

        //Select multiple commands from a multi-select box
        formPage.selectCommands("Switch Commands");
        formPage.selectCommands("WebElement Commands");

        //Upload image (button)
        formPage.uploadImage();

        //Click on Submit button
        formPage.clickOnSubmitBtn();
    }
}