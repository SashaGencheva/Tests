package Homework11.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FormPage extends BasePage {
    @FindBy(id = "ez-accept-necessary")
    @CacheLookup
    WebElement acceptCookies;

    @FindBy(name = "firstname")
    @CacheLookup
    WebElement firstName;

    @FindBy(name = "lastname")
    @CacheLookup
    WebElement lastName;

    @FindBy(xpath = "//*[@type='radio'][@name='sex']")
    @CacheLookup
    List<WebElement> genderList;

    @FindBy(css = "*[name='exp']")
    @CacheLookup
    List<WebElement> yearsOfExperienceList;

    @FindBy(id = "datepicker")
    @CacheLookup
    WebElement date;

    @FindBy(name = "profession")
    @CacheLookup
    List<WebElement> professionList;

    @FindBy(css = "input[name='tool']")
    @CacheLookup
    List<WebElement> toolList;

    @FindBy(css = "select#continents")
    @CacheLookup
    WebElement continents;

    @FindBy(xpath = "//select[@id='selenium_commands']")
    @CacheLookup
    WebElement commands;

    @FindBy(css = "#photo.input-file")
    @CacheLookup
    WebElement photo;

    @FindBy(css = "button#submit")
    @CacheLookup
    WebElement submit;

    Actions act;

    //Constructor that will be automatically called as soon as the object of the class is created
    public FormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Page method for Accept cookies (button)
    public void clickOnAcceptCookiesBtn() {
        String expectedAcceptCookiesBtn = "Allow Necessary Cookies & Continue";
        Assert.assertEquals("Title of accept cookies button does not match", expectedAcceptCookiesBtn, getTextFromElement(acceptCookies));
        clickOnElement(acceptCookies);
    }

    //Page method for First name (text box)
    public void setFirstName(String fName) {
        clearElement(firstName);
        setValueToElement(firstName, fName);
    }

    //Page method for Last name (text box)
    public void setLastName(String lName) {
        clearElement(lastName);
        setValueToElement(lastName, lName);
    }

    //Page methods for Gender (radio button)
    public void selectGender(String gender) {
        Assert.assertFalse("Gender list is empty", genderList.isEmpty());
        switch (gender) {
            case ("Male"):
                clickOnElement(genderList.get(0));
                Assert.assertTrue("Male gender is not selected", isElementSelected(genderList.get(0)));
                break;
            case ("Female"):
                clickOnElement(genderList.get(1));
                Assert.assertTrue("Female gender is not selected", isElementSelected(genderList.get(1)));
                break;
            default:
                System.out.println("Invalid gender");
        }
        Assert.assertEquals("Expected and actual gender do not match", gender, getGender());
    }

    public String getGender() {
        String gender = "";
        for (WebElement genderElement : genderList) {
            if (isElementSelected(genderElement)) {
                gender = getAttributeFromElement(genderElement);
            }
        }
        return gender;
    }

    //Page methods for Years of Experience (radio button)
    public void selectYearsOfExperience(String years) {
        Assert.assertFalse("List with years of experience is empty", yearsOfExperienceList.isEmpty());
        switch (years) {
            case "1":
                clickOnElement(yearsOfExperienceList.get(0));
                Assert.assertTrue(isElementSelected(yearsOfExperienceList.get(0)));
                break;
            case "2":
                clickOnElement(yearsOfExperienceList.get(1));
                Assert.assertTrue(isElementSelected(yearsOfExperienceList.get(1)));
                break;
            case "3":
                clickOnElement(yearsOfExperienceList.get(2));
                Assert.assertTrue(isElementSelected(yearsOfExperienceList.get(2)));
                break;
            case "4":
                clickOnElement(yearsOfExperienceList.get(3));
                Assert.assertTrue(isElementSelected(yearsOfExperienceList.get(3)));
                break;
            case "5":
                clickOnElement(yearsOfExperienceList.get(4));
                Assert.assertTrue(isElementSelected(yearsOfExperienceList.get(4)));
                break;
            case "6":
                clickOnElement(yearsOfExperienceList.get(5));
                Assert.assertTrue(isElementSelected(yearsOfExperienceList.get(5)));
                break;
            case "7":
                clickOnElement(yearsOfExperienceList.get(6));
                Assert.assertTrue(isElementSelected(yearsOfExperienceList.get(6)));
                break;
            default:
                System.out.println("Invalid years of experience");
        }
        Assert.assertEquals("Expected and actual years of experience do not match", years, getYearsOfExperience());
    }

    public String getYearsOfExperience() {
        String years = "";
        for (WebElement yearsOfExp : yearsOfExperienceList) {
            if (isElementSelected(yearsOfExp)) {
                years = getAttributeFromElement(yearsOfExp);
            }
        }
        return years;
    }

    //Page method for Date field
    public void setDate(String date) {
        clearElement(this.date);
        setValueToElement(this.date, date);
    }

    //Page methods for Profession (checkbox)
    public void selectProfession(String profession) {
        Assert.assertFalse("List with professions is empty", professionList.isEmpty());
        switch (profession) {
            case "Manual Tester":
                clickOnElement(professionList.get(0));
                Assert.assertTrue(isElementSelected(professionList.get(0)));
                break;
            case "Automation Tester":
                clickOnElement(professionList.get(1));
                Assert.assertTrue(isElementSelected(professionList.get(1)));
                break;
            default:
                System.out.println("Invalid profession");
        }
        Assert.assertEquals("Expected and actual profession do not match", profession, getProfession());
    }

    public String getProfession() {
        String profession = "";
        for (WebElement prof : professionList) {
            if (isElementSelected(prof)) {
                profession = getAttributeFromElement(prof);
            }
        }
        return profession;
    }

    //Page methods for Automation tools you are familiar with (multiple checkboxes)
    public void selectAutomationToolByActions(String tool) {
        act = new Actions(driver);
        Assert.assertFalse("Automation tool list is empty", toolList.isEmpty());
        switch (tool) {
            case "UFT":
                act.click(toolList.get(0)).build().perform();
                Assert.assertTrue(isElementSelected(toolList.get(0)));
                Assert.assertEquals("QTP", getAutomationTool());
                break;
            case "Protractor":
                act.click(toolList.get(1)).build().perform();
                Assert.assertTrue(isElementSelected(toolList.get(1)));
                Assert.assertEquals("Selenium IDE", getAutomationTool());
                break;
            case "Selenium WebDriver":
                act.click(toolList.get(2)).build().perform();
                Assert.assertTrue(isElementSelected(toolList.get(2)));
                Assert.assertEquals("Selenium Webdriver", getAutomationTool());
                break;
            default:
                System.out.println("Invalid automation tool");
        }
    }

    public String getAutomationTool() {
        String tool = "";
        for (WebElement toolElement : toolList) {
            if (isElementSelected(toolElement)) {
                tool = getAttributeFromElement(toolElement);
            }
        }
        return tool;
    }

    //Page method for Continent (select box)
    public void selectContinent(String continent) {
        Assert.assertFalse("Continents select box is multiple", isElementMultiple(continents));
        switch (continent) {
            case "Asia":
                selectElementFromDropDownByVisibleText(continents, "Asia");
                break;
            case "Europe":
                selectElementFromDropDownByVisibleText(continents, "Europe");
                break;
            case "Africa":
                selectElementFromDropDownByVisibleText(continents, "Africa");
                break;
            case "Australia":
                selectElementFromDropDownByVisibleText(continents, "Australia");
                break;
            case "South America":
                selectElementFromDropDownByVisibleText(continents, "South America");
                break;
            case "North America":
                selectElementFromDropDownByVisibleText(continents, "North America");
                break;
            case "Antartica":
                selectElementFromDropDownByVisibleText(continents, "Antartica");
                break;
            default:
                System.out.println("Invalid continent");
        }
        Assert.assertEquals("Expected and actual selected continent do not match", continent, getSelectedElementsFromDropDown(continents));
    }

    //Page method for multiple commands from a multi-select box
    public void selectCommands(String command) {
        Assert.assertTrue("Commands select box is not multiple", isElementMultiple(commands));
        switch (command) {
            case "Browser Commands":
                selectElementFromDropDownByIndex(commands, 0);
                break;
            case "Navigation Commands":
                selectElementFromDropDownByIndex(commands, 1);
                break;
            case "Switch Commands":
                selectElementFromDropDownByIndex(commands, 2);
                break;
            case "Wait Commands":
                selectElementFromDropDownByIndex(commands, 3);
                break;
            case "WebElement Commands":
                selectElementFromDropDownByIndex(commands, 4);
                break;
            default:
                System.out.println("Invalid Selenium commands");
        }
        Assert.assertEquals("Expected and actual selected commands do not match", command, getSelectedElementsFromDropDown(commands));
    }

    //Page method for Upload image (button)
    public void uploadImage() {
        clearElement(photo);
        photo.sendKeys("C:\\Users\\digger\\Downloads\\sampleFile.jpeg");
        Assert.assertTrue("Expected and actual uploaded file do not match", getAttributeFromElement(photo).contains("sampleFile.jpeg"));
    }

    //Page method for Submit button
    public void clickOnSubmitBtn() {
        clickOnElement(submit);
        Assert.assertEquals("Expected and actual submit button title do not match", "Button", getTextFromElement(submit));
    }
}