package Homework10.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BasePagePOM {
    WebDriver driver;
    Select select;

    //Constructor
    public BasePagePOM (WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Custom page method to get text of an element
     * @param elementBy Method parameter of By (locator) type
     * @return It returns the visible text of an element as a String
     */
    public String getTextFromElement(By elementBy) {
        return driver.findElement(elementBy).getText();
    }

    /**
     * Custom page method to click on element
     * @param elementBy Method parameter of By (locator) type
     */
    public void clickOnElement(By elementBy) {
        driver.findElement(elementBy).click();
    }

    /**
     * Custom page method to erase the contents from text boxes
     * @param elementBy Method parameter of By (locator) type
     */
    public void clearElement(By elementBy) {
        driver.findElement(elementBy).clear();
    }

    /**
     * Custom page method to determine if a web element such as radio button or checkbox is selected or not
     * @param elementBy Method parameter of By (locator) type
     * @return It returns a boolean value as true if the web element is selected and false if it is not selected
     */
    public boolean isElementSelected(By elementBy) {
        return driver.findElement(elementBy).isSelected();
    }

    /**
     * Custom page method to set value to element
     * @param elementBy The first method parameter of By (locator) type
     * @param text The second method parameter of String type
     */

    public void setValueToElement(By elementBy, String text) {
        driver.findElement(elementBy).sendKeys(text);
    }

    /**
     * Custom page method to get value from element
     * @param elementBy Method parameter of type By (locator)
     * @return It returns the value of a certain attribute of an element
     */
    public String getAttributeFromElement(By elementBy) {
        return driver.findElement(elementBy).getAttribute("value");
    }

    /**
     * Custom page method to select one of the options in a drop-down box or an option among multiple selection boxes using the text over the option.
     * @param elementBy The first method parameter of By (locator) type
     * @param text The second method parameter of String type which is one of the values of Select element
     */
    public void selectElementFromDropDownByVisibleText(By elementBy, String text) {
        select = new Select(driver.findElement(elementBy));
        select.selectByVisibleText(text);
    }

    /**
     * Custom page method to select the list option from the drop-down field using the specified index of the list option
     * @param elementBy The first method parameter of By (locator) type
     * @param index The second method parameter of integer type beginning with 0
     */
    public void selectElementFromDropDownByIndex(By elementBy, int index) {
        select = new Select(driver.findElement(elementBy));
        select.selectByIndex(index);
    }

    /**
     * Custom page method to get text of first selected element in a drop-down box
     * @param elementBy Method parameter of By (locator) type
     * @return It returns the visible text of an element as a String
     */
    public String getFirstSelectedElementFromDropDown(By elementBy) {
        select = new Select(driver.findElement(elementBy));
        return select.getFirstSelectedOption().getText();
    }

    /**
     * Custom page method to get text of selected element in a drop-down box using specified index
     * @param elementBy First method parameter of By (locator) type
     * @param index The second method parameter of integer type beginning with 0
     * @return It returns the visible text of an element as a String
     */
    public String getSelectedElementFromDropDown(By elementBy, int index) {
        select = new Select(driver.findElement(elementBy));
        return select.getAllSelectedOptions().get(index).getText();
    }

    /**
     * Custom page method to verify whether the specified select element support selecting multiple options at the same time
     * @param elementBy Method parameter of By (locator) type
     * @return It returns true when the specified select element support selecting multiple options else it will return false
     */
    public boolean isElementMultiply(By elementBy) {
        select = new Select(driver.findElement(elementBy));
        return select.isMultiple();
    }
}
