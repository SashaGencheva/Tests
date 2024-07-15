package Homework10.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FormPagePOM extends BasePagePOM {
    List<WebElement> tools;
    Actions act;

    //Locators for WebElements
    By acceptCookiesBy = By.id("ez-accept-necessary");
    By firstNameBy = By.name("firstname");
    By lastNameBy = By.name("lastname");
    By maleBy = By.id("sex-0");
    By femaleBy = By.id("sex-1");
    By oneYearOfExperience = By.id("exp-0");
    By twoYearsOfExperience = By.id("exp-1");
    By threeYearsOfExperience = By.id("exp-2");
    By fourYearsOfExperience = By.id("exp-3");
    By fiveYearsOfExperience = By.id("exp-4");
    By sixYearsOfExperience = By.id("exp-5");
    By sevenYearsOfExperience = By.id("exp-6");
    By dateBy = By.id("datepicker");
    By manualTesterBy = By.id("profession-0");
    By autoTesterBy = By.id("profession-1");
    By toolsBy = By.name("tool");
    By uftTool = By.cssSelector("input#tool-0");
    By protractorTool = By.cssSelector("input#tool-1");
    By webDriverTool = By.cssSelector("input#tool-2");
    By continentsBy = By.cssSelector("select#continents");
    By commandsBy = By.id("selenium_commands");
    By photoBy = By.id("photo");
    By submitBy = By.id("submit");

    //Constructor that will be automatically called as soon as the object of the class is created
    public FormPagePOM (WebDriver driver) {
        super(driver);
    }

    //Page methods for Accept cookies (button)
    public String getTextFromAcceptCookiesBtn() {
        return getTextFromElement(acceptCookiesBy);
    }

    public void clickOnAcceptCookiesBtn() {
        clickOnElement(acceptCookiesBy);
    }

    //Page methods for First name (text box)
    public void setFirstName(String text) {
        setValueToElement(firstNameBy, text);
    }

    public String getFirstName() {
        return getAttributeFromElement(firstNameBy);
    }

    //Page methods for Last name (text box)
    public void setLastName(String text) {
        setValueToElement(lastNameBy, text);
    }

    public String getLastName() {
        return getAttributeFromElement(lastNameBy);
    }

    //Page methods for Gender (radio button)
    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("male"))
            clickOnElement(maleBy);
        else if (gender.equalsIgnoreCase("female")) {
            clickOnElement(femaleBy);
        }
    }

    public String getGender() {
        String gender = "";
        if (isElementSelected(maleBy)) {
            gender = getAttributeFromElement(maleBy);
        } else if (isElementSelected(femaleBy)) {
            gender = getAttributeFromElement(femaleBy);
        }
        return gender;
    }

    public boolean isGenderSelected() {
        return isElementSelected(maleBy) || isElementSelected(femaleBy);
    }

    //Page methods for Years of Experience (radio button)
    public void setYearsOfExperience(String years) {
        switch (years) {
            case "1":
                clickOnElement(oneYearOfExperience);
                break;
            case "2":
                clickOnElement(twoYearsOfExperience);
                break;
            case "3":
                clickOnElement(threeYearsOfExperience);
                break;
            case "4":
                clickOnElement(fourYearsOfExperience);
                break;
            case "5":
                clickOnElement(fiveYearsOfExperience);
                break;
            case "6":
                clickOnElement(sixYearsOfExperience);
                break;
            case "7":
                clickOnElement(sevenYearsOfExperience);
                break;
            default:
                System.out.println("Invalid years of experience");
        }
    }

    public String getYearsOfExperience() {
        String years = "";
        if (isElementSelected(oneYearOfExperience)) {
            years = getAttributeFromElement(oneYearOfExperience);
        } else if (isElementSelected(twoYearsOfExperience)) {
            years = getAttributeFromElement(twoYearsOfExperience);
        } else if (isElementSelected(threeYearsOfExperience)) {
            years = getAttributeFromElement(threeYearsOfExperience);
        } else if (isElementSelected(fourYearsOfExperience)) {
            years = getAttributeFromElement(fourYearsOfExperience);
        } else if (isElementSelected(fiveYearsOfExperience)) {
            years = getAttributeFromElement(fiveYearsOfExperience);
        } else if (isElementSelected(sixYearsOfExperience)) {
            years = getAttributeFromElement(sixYearsOfExperience);
        } else if (isElementSelected(sevenYearsOfExperience)) {
            years = getAttributeFromElement(sevenYearsOfExperience);
        }
        return years;
    }

    //Page methods for Date field
    public void setDate(String text) {
        setValueToElement(dateBy, text);
    }
    public void clearDate() {
        clearElement(dateBy);
    }

    public String getDate() {
        return getAttributeFromElement(dateBy);
    }

    //Page methods for Profession (checkbox)
    public void setProfession(String profession) {
        switch (profession) {
            case "Automation Tester":
                clickOnElement(autoTesterBy);
                break;
            case "Manual Tester":
                clickOnElement(manualTesterBy);
                break;
            default:
                System.out.println("Invalid profession");
        }
    }

    public String getProfession() {
        String profession = "";
        if (isElementSelected(manualTesterBy)) {
            profession = getAttributeFromElement(manualTesterBy);
        } else if (isElementSelected(autoTesterBy)) {
            profession = getAttributeFromElement(autoTesterBy);
        }
        return profession;
    }

    public boolean isProfessionSelected() {
        return isElementSelected(manualTesterBy) || isElementSelected(autoTesterBy);
    }

    //Page methods for Automation tools you are familiar with (multiple checkboxes)
    public void setAutomationToolByActions (String tool) {
        tools = driver.findElements(toolsBy);
        act = new Actions(driver);

        switch (tool) {
            case "UFT":
                act.click(tools.get(0));
                break;
            case "Protractor":
                act.click(tools.get(1));
                break;
            case "Selenium WebDriver":
                act.click(tools.get(2));
                break;
            default:
                System.out.println("Invalid automation tool");
        }
        act.build().perform();
    }

    public boolean isAutomationToolSelected() {
        return isElementSelected(uftTool) || isElementSelected(protractorTool) || isElementSelected(webDriverTool);
    }

    //Page methods for Continent (select box)
    public void setContinent(String continent) {
        switch (continent) {
            case "Asia":
                selectElementFromDropDownByVisibleText(continentsBy, "Asia");
                break;
            case "Europe":
                selectElementFromDropDownByVisibleText(continentsBy, "Europe");
                break;
            case "Africa":
                selectElementFromDropDownByVisibleText(continentsBy, "Africa");
                break;
            case "Australia":
                selectElementFromDropDownByVisibleText(continentsBy, "Australia");
                break;
            case "South America":
                selectElementFromDropDownByVisibleText(continentsBy, "South America");
                break;
            case "North America":
                selectElementFromDropDownByVisibleText(continentsBy, "North America");
                break;
            case "Antartica":
                selectElementFromDropDownByVisibleText(continentsBy, "Antartica");
                break;
            default:
                System.out.println("Invalid continent");
        }
    }

    public String getContinent() {
        return getFirstSelectedElementFromDropDown(continentsBy);
    }

    public boolean isContinentMultiply() {
        return isElementMultiply(continentsBy);
    }

    //Page methods for multiple commands from a multi-select box
    public void setCommands(String commands) {

        switch (commands) {
            case "Browser Commands":
                selectElementFromDropDownByIndex(commandsBy, 0);
                break;
            case "Navigation Commands":
                selectElementFromDropDownByIndex(commandsBy, 1);
                break;
            case "Switch Commands":
                selectElementFromDropDownByIndex(commandsBy, 2);
                break;
            case "Wait Commands":
                selectElementFromDropDownByIndex(commandsBy,3);
                break;
            case "WebElement Commands":
                selectElementFromDropDownByIndex(commandsBy, 4);
                break;
            default:
                System.out.println("Invalid Selenium commands");
        }
    }

    public String getSelectedCommandByIndex(int index) {
        return getSelectedElementFromDropDown(commandsBy, index);
    }

    public boolean isCommandsMultiply() {
        return isElementMultiply(commandsBy);
    }

    //Page methods for Upload image (button)
    public void uploadImage() {
        setValueToElement(photoBy, "C:\\Users\\digger\\Downloads\\sampleFile.jpeg");
    }

    public String getAttributeUploadImage() {
        return getAttributeFromElement(photoBy);
    }

    public boolean isUploadBtnSelected() {
        return isElementSelected(photoBy);
    }

    //Page methods for Submit button
    public void clickOnSubmitBtn() {
        clickOnElement(submitBy);
    }

    public String getTextFromSubmitBtn() {
        return getTextFromElement(submitBy);
    }
}