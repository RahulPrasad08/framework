package com.dd.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dd.testcases.BaseClass;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.interactions.Actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

/**
 * A utility class for common WebDriver actions such as dropdown selection,
 * explicit waits, double clicks, taking screenshots, and logging.
 *
 * This class assumes that Log4j2 is configured and its dependencies are
 * available in the project's classpath.
 */

public class WebDriverUtilities {
	 private static final Logger logger = LogManager.getLogger(WebDriverUtilities.class);
	    private WebDriver driver;

	    public WebDriverUtilities(WebDriver driver) {
	        this.driver = driver;
	    }


    // A logger instance specific to this class.
   // private static final Logger logger = LogManager.getLogger(WebDriverUtilities.class);

    /**
     * Selects an option from a dropdown element by its visible text.
     *
     * @param dropdownElement The WebElement representing the <select> tag.
     * @param visibleText     The visible text of the option to be selected.
     */
    public void selectFromDropdownByVisibleText(WebElement dropdownElement, String visibleText) {
        try {
            Select select = new Select(dropdownElement);
            select.selectByVisibleText(visibleText);
            logger.info("Selected '" + visibleText + "' from dropdown.");
        } catch (NoSuchElementException e) {
            logger.error("Could not find element with visible text '" + visibleText + "' in dropdown.", e);
            throw e; // Re-throw the exception to fail the test.
        } catch (Exception e) {
            logger.error("An unexpected error occurred while selecting from dropdown.", e);
            throw e;
        }
    }

    /**
     * Waits for an element to be clickable. This is an explicit wait that
     * prevents test failures due to timing issues.
     *
     * @param driver         The WebDriver instance.
     * @param element        The WebElement to wait for.
     * @param timeoutInSeconds The maximum time to wait in seconds.
     * @return The WebElement once it is clickable.
     */
    public WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            logger.info("Waited for element to be clickable successfully.");
            return clickableElement;
        } catch (Exception e) {
            logger.error("Element was not clickable within " + timeoutInSeconds + " seconds.", e);
            throw e;
        }
    }

    /**
     * Performs a double-click action on a specified WebElement.
     *
     * @param driver The WebDriver instance.
     * @param element The WebElement to double-click.
     */
    public void doubleClick(WebDriver driver, WebElement element) {
        try {
            Actions actions = new Actions(driver);
            actions.doubleClick(element).perform();
            logger.info("Successfully performed double-click on the element.");
        } catch (Exception e) {
            logger.error("Failed to perform double-click on the element.", e);
            throw e;
        }
    }

    /**
     * Captures a screenshot of the current browser view and saves it to a specified location.
     * This method is useful for capturing evidence on test failures.
     *
     * @param driver          The WebDriver instance.
     * @param screenshotName  The desired name for the screenshot file (e.g., "login_failure").
     */
    public void takeScreenshotOnFailure(WebDriver driver, String screenshotName) {
        if (driver instanceof TakesScreenshot) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "target/screenshots/" + screenshotName + "_" + System.currentTimeMillis() + ".png";
            try {
                FileHandler.copy(screenshotFile, new File(path));
                logger.info("Screenshot saved to: " + path);
            } catch (IOException e) {
                logger.error("Failed to save screenshot.", e);
            }
        } else {
            logger.warn("WebDriver does not support taking screenshots.");
        }
    }

    /**
     * Logs an informational message using Log4j.
     *
     * @param message The message to be logged.
     */
    public static void logInfo(String message) {
        logger.info(message);
    }

    /**
     * Logs an error message using Log4j.
     *
     * @param message The error message to be logged.
     */
    public static void logError(String message) {
        logger.error(message);
    }
    public void clickElement(WebElement element) {
        try {
            element.click();
            logger.info("Successfully clicked on the element.");
        } catch (Exception e) {
            logger.error("Failed to click on the element.", e);
            throw e;
        }
    }
}
