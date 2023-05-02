package DropDownList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class DropDownList {
    WebDriver driver;
    public DropDownList(WebDriver driver) {
        this.driver = driver;
    }

    private final String accordionLocator = "accordion__heading-";
    private final String accordionPanelLocator = "accordion__panel-";

    public void clickDropDownList(int index){
        driver.findElement(By.id(accordionLocator + index)).click();
    }
    public void scrollToElement(int index){
        WebElement element = driver.findElement(By.id(accordionLocator + index));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public String getTextOfDropDown(int index){
        return driver.findElement(By.id(accordionPanelLocator + index)).getText();
    }
}
