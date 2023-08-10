package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Workflows extends CommonOps {
    public void verifyTitle(String title, String expected, String message) {
        Assert.assertEquals(driver.getTitle(), expected, message);
    }
    public void loginBtn() {
        driver.findElement(By.id("userMenuToggleBtn")).click();
        clickOnELement("//*[@id=\'userMenuToggleMenu\']/li[5]/a");
        verifyTitle(driver.getTitle(), "Select Login - QA environment #1", "incorrect page");
    }

    public void login() {
        clickOnELement("//*[@id='wrap']/div/div/div[1]/div[4]/button[1]");
        verifyTitle(driver.getTitle(), "Login - QA environment #1", "incorrect page");
        driver.findElement(By.id("Login-username")).sendKeys(userName);
        driver.findElement(By.id("Login-password")).sendKeys(password);
        clickOnELement("//*[@id='Login-login']");
        verifyTitle(driver.getTitle(), "QA environment #1", "incorrect page");
    }

    public void uploadFile() {
        clickOnELement("//*[contains(@class, 'icon-upload')]");
        clickOnELement("//a[@href='/upload/media']");
        WebElement hiddenUploadBtn = driver.findElement(By.id("fileinput1"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.display = 'block';", hiddenUploadBtn);
        hiddenUploadBtn.sendKeys(filePath);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement uploadSuccessMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#successmsg:not([class*='hidden'])")));
        Assert.assertTrue(uploadSuccessMsg.isDisplayed(), "Upload failed");
    }

    public void openFile() {
        clickOnELement("//a[@id='back']");
//click to play music
    }
}
