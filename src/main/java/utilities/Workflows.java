package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class Workflows extends CommonOps {
    public void verifyTitle(String expected, String message) {
        Assert.assertEquals(driver.getTitle(), expected, message);
    }
    public void navigateToLogin() {
        driver.findElement(By.id("userMenuToggleBtn")).click();
        clickOnElement("//*[@id=\'userMenuToggleMenu\']/li[5]/a");
        verifyTitle("Select Login - QA environment #1", "incorrect page");
    }

    public void login() {
        navigateToLogin();
        clickOnElement("//*[@id='wrap']/div/div/div[1]/div[4]/button[1]");
        verifyTitle("Login - QA environment #1", "incorrect page");
        driver.findElement(By.id("Login-username")).sendKeys(userName);
        driver.findElement(By.id("Login-password")).sendKeys(password);
        clickOnElement("//*[@id='Login-login']");
        verifyTitle("QA environment #1", "incorrect page");
        logger.info("Login completed successfully");
    }

    public void uploadFile() {
        clickOnElement("//*[contains(@class, 'icon-upload')]");
        clickOnElement("//a[@href='/upload/media']");
        WebElement hiddenUploadBtn = driver.findElement(By.id("fileinput1"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.display = 'block';", hiddenUploadBtn);
        hiddenUploadBtn.sendKeys(filePath);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement uploadSuccessMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#successmsg:not([class*='hidden'])")));
        Assert.assertTrue(uploadSuccessMsg.isDisplayed(), "Upload failed");
        logger.info("File uploaded successfully");
    }

    public void openFile() {
        clickOnElement("//a[@id='back']");
        Assert.assertTrue(driver.findElement(By.className("playkit-container")).isDisplayed(), "file is not visible");
        logger.info("File is visible to user");
    }
}
