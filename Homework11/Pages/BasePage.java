package Homework11.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Select select;
    List<WebElement> selectedOptionsList;

    //Constructor
    public BasePage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Custom page method to open a specified URL in the browser
     * @param url Method parameter of String type
     */
    public void openUrl(String url) {
        driver.get(url);
        Assert.assertEquals("URl does not match", url, driver.getCurrentUrl());
    }

    /**
     * Custom page method to check that an element is present on the DOM of a page and visible
     * @param element Method parameter of WebElement type
     */
    public void waitVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Custom page method to check that an element is visible and enabled such that it can be clicked
     * @param element Method parameter of WebElement type
     */
    public void waitElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Custom page method to get text of an element
     * @param element Method parameter of WebElement type
     * @return It returns the visible text of an element as a String
     */
    public String getTextFromElement(WebElement element) {
        waitVisibilityOfElement(element);
        return element.getText();
    }

    /**
     * Custom page method to click on element
     * @param element Method parameter of WebElement type
     */
    public void clickOnElement(WebElement element) {
        waitElementToBeClickable(element);
        element.click();
    }

    /**
     * Custom page method to erase the contents from text boxes
     * @param element Method parameter of WebElement type
     */
    public void clearElement(WebElement element) {
        waitElementToBeClickable(element);
        element.clear();
        Assert.assertTrue(getAttributeFromElement(element).isBlank());
    }

    /**
     * Custom page method to determine if a web element such as radio button or checkbox is selected or not
     * @param element Method parameter of WebElement type
     * @return It returns a boolean value as true if the web element is selected and false if it is not selected
     */
    public boolean isElementSelected(WebElement element) {
        return element.isSelected();
    }

    /**
     * Custom page method to set value to element
     * @param element The first method parameter of WebElement type
     * @param text The second method parameter of String type
     */
    public void setValueToElement(WebElement element, String text) {
        waitVisibilityOfElement(element);
        element.sendKeys(text);
        Assert.assertFalse("Input value is empty", getAttributeFromElement(element).isBlank());
        Assert.assertTrue("Expected and actual input value do not match", getAttributeFromElement(element).contains(text));
    }

    /**
     * Custom page method to get value from element
     * @param element Method parameter of WebElement type
     * @return It returns the value of a certain attribute of an element
     */
    public String getAttributeFromElement(WebElement element) {
        waitVisibilityOfElement(element);
        return element.getAttribute("value");
    }

    /**
     * Custom page method to select one of the options in a drop-down box or an option among multiple selection boxes using the text over the option.
     * @param element The first method parameter of WebElement type
     * @param text The second method parameter of String type which is one of the values of Select element
     */
    public void selectElementFromDropDownByVisibleText(WebElement element, String text) {
        waitElementToBeClickable(element);
        select = new Select(element);
        Assert.assertFalse("Option list is empty", select.getOptions().isEmpty());
        select.selectByVisibleText(text);
    }

    /**
     * Custom page method to select the list option from the drop-down field using the specified index of the list option
     * @param element The first method parameter of WebElement type
     * @param index The second method parameter of integer type beginning with 0
     */
    public void selectElementFromDropDownByIndex(WebElement element, int index) {
        waitElementToBeClickable(element);
        select = new Select(element);
        Assert.assertFalse("Option list is empty", select.getOptions().isEmpty());
        select.selectByIndex(index);
    }

    /**
     * Custom page method to get text of selected element in a drop-down box
     * @param element Method parameter of WebElement type
     * @return It returns the visible text of an element as a String
     */
    public String getSelectedElementsFromDropDown(WebElement element) {
        String options = "";
        waitVisibilityOfElement(element);
        select = new Select(element);
        selectedOptionsList = select.getAllSelectedOptions();
        for (WebElement elem : selectedOptionsList) {
            options = getTextFromElement(elem);
        }
        return options;
    }

    /**
     * Custom page method to verify whether the specified select element support selecting multiple options at the same time
     * @param element Method parameter of WebElement type
     * @return It returns true when the specified select element support selecting multiple options else it will return false
     */
    public boolean isElementMultiple(WebElement element) {
        select = new Select(element);
        return select.isMultiple();
    }
}