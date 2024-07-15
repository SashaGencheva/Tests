package Homework10.Tests;

import Homework10.Helpers.SetUpTearDownDriver;
import Homework10.Pages.FormPagePOM;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

public class FormPagePOMTest extends SetUpTearDownDriver {
    FormPagePOM formPagePOM;
    String expectedUrl = "https://www.techlistic.com/p/selenium-practice-form.html?m=1";
    String actualUrl;
    String expectedAcceptCookiesBtn = "Allow Necessary Cookies & Continue";
    String actualAcceptCookiesBtn;
    String actualFirstName;
    String actualLastName;
    String actualSelectedGender;
    String actualYearsOfExperience;
    String actualDate;
    String actualProfession;
    String actualContinent;
    String actualCommands1;
    String actualCommands2;
    String actualUploadImage;
    String actualSubmitBtn;

    @Test
    public void verifyPracticeForm() throws InterruptedException {
        formPagePOM = new FormPagePOM(driver);

        actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("URL does not match", expectedUrl, actualUrl );
        Assert.assertNotSame(expectedUrl, actualUrl);

        //Accept cookies (button)
        actualAcceptCookiesBtn = formPagePOM.getTextFromAcceptCookiesBtn();
        Assert.assertEquals("Title of accept cookies button does not match", expectedAcceptCookiesBtn, actualAcceptCookiesBtn);
        formPagePOM.clickOnAcceptCookiesBtn();

        //Enter First name (text box)
        formPagePOM.setFirstName("John");
        actualFirstName = formPagePOM.getFirstName();
        Assert.assertTrue("Expected and actual first name do not match", actualFirstName.equalsIgnoreCase("john"));

        //Enter Last name (text box)
        formPagePOM.setLastName("Smith");
        actualLastName = formPagePOM.getLastName();
        Assert.assertNotEquals("Expected and actual last name match", "smith", actualLastName);

        //Select Gender (radio button)
        formPagePOM.setGender("male");
        actualSelectedGender = formPagePOM.getGender();
        Assert.assertTrue("Gender is not selected", formPagePOM.isGenderSelected());
        Assert.assertEquals("Expected and actual gender do not match", "Male", actualSelectedGender);

        //Select Years of Experience (radio button)
        formPagePOM.setYearsOfExperience("3");
        actualYearsOfExperience = formPagePOM.getYearsOfExperience();
        Assert.assertEquals("Expected and actual years of experience do not match","3", actualYearsOfExperience);

        //Scroll down the webpage by 1000 pixels
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,1000)");

        //Enter Date
        formPagePOM.setDate("10-06-24");
        Thread.sleep(2000);
        formPagePOM.clearDate();
        formPagePOM.setDate("28-11-24");
        actualDate = formPagePOM.getDate();
        Assert.assertEquals("28-11-24", actualDate);

        //Select Profession (checkbox)
        formPagePOM.setProfession("Automation Tester");
        actualProfession = formPagePOM.getProfession();
        Assert.assertTrue("Profession is not selected", formPagePOM.isProfessionSelected());
        Assert.assertTrue(actualProfession.contains("Auto"));

        //Select Automation tools you are familiar with (multiple checkboxes)
        formPagePOM.setAutomationToolByActions("Protractor");
        formPagePOM.setAutomationToolByActions("Selenium WebDriver");
        Assert.assertTrue("Automation tool is not selected", formPagePOM.isAutomationToolSelected());

        //Select Continent (select box)
        formPagePOM.setContinent("Europe");
        actualContinent = formPagePOM.getContinent();
        Assert.assertNotNull(actualContinent);
        Assert.assertFalse(formPagePOM.isContinentMultiply());
        Assert.assertEquals("Expected and actual selected continent do not match", "Europe", actualContinent);

        //Select multiple commands from a multi-select box
        formPagePOM.setCommands("Switch Commands");
        formPagePOM.setCommands("WebElement Commands");
        actualCommands1 = formPagePOM.getSelectedCommandByIndex(0);
        actualCommands2 = formPagePOM.getSelectedCommandByIndex(1);
        Assert.assertTrue(formPagePOM.isCommandsMultiply());
        Assert.assertEquals("Expected and actual selected commands do not match", "Switch Commands", actualCommands1);
        Assert.assertEquals("Expected and actual selected commands do not match", "WebElement Commands", actualCommands2);

        //Upload image (button)
        formPagePOM.uploadImage();
        actualUploadImage = formPagePOM.getAttributeUploadImage();
        Assert.assertFalse(formPagePOM.isUploadBtnSelected());
        Assert.assertEquals("C:\\fakepath\\sampleFile.jpeg", actualUploadImage);

        //Click on Submit button
        formPagePOM.clickOnSubmitBtn();
        actualSubmitBtn = formPagePOM.getTextFromSubmitBtn();
        Assert.assertTrue("Expected and actual submit button title do not match", actualSubmitBtn.equalsIgnoreCase("button"));
    }
}