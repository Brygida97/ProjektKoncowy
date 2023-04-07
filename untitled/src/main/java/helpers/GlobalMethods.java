package helpers;

import base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class GlobalMethods extends TestBase {

    public GlobalMethods() {
    }

    public String getPageURL(){
        String pageURL = driver.getCurrentUrl();
        System.out.println("URL: " + pageURL);
        return pageURL;
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        System.out.println("Page title: " + title);
        return title;
    }

    public void setInput(WebElement inputElement, String text) {
        wait.until(visibilityOf(inputElement));
        inputElement.clear();
        inputElement.sendKeys(text);
    }

    public void clickButton(WebElement buttonElement) {

        wait.until(elementToBeClickable(buttonElement)).click();
    }

    public String getTextFromElement(WebElement element) {
        wait.until(visibilityOf(element));
        String text = element.getText();
        return text;
    }

    public void takeScreenShot(int NrTestu) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("src/main/resources/" + NrTestu + "_screenshot.png"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}