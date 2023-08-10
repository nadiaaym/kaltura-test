import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;

public class Test01 extends  Assertions {

    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        final Logger logger = LoggerFactory.getLogger(Test01.class);
        String userName = System.getenv("USER_NAME");
        String password = System.getenv("PASSWORD");
        String filePath = System.getenv("FILE_PATH");

        driver.get("http://1722461-2.qakmstest.dev.kaltura.com");
        driver.manage().window().maximize();

        driver.findElement(By.id("userMenuToggleBtn")).click();
        clickOnELement("//*[@id=\'userMenuToggleMenu\']/li[5]/a");
        verifyTitle(driver.getTitle(), "Select Login - QA environment #1", "incorrect page");
        clickOnELement("//*[@id='wrap']/div/div/div[1]/div[4]/button[1]");
        verifyTitle(driver.getTitle(), "Login - QA environment #1", "incorrect page");
        driver.findElement(By.id("Login-username")).sendKeys(userName);
        driver.findElement(By.id("Login-password")).sendKeys(password);
        clickOnELement("//*[@id='Login-login']");
        verifyTitle(driver.getTitle(), "QA environment #1", "incorrect page");
        clickOnELement("//*[contains(@class, 'icon-upload')]");
        clickOnELement("//a[@href='/upload/media']");
        WebElement hiddenUploadBtn = driver.findElement(By.id("fileinput1"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.display = 'block';", hiddenUploadBtn);
        hiddenUploadBtn.sendKeys(filePath);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement uploadSuccessMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#successmsg:not([class*='hidden'])")));
        Assert.assertTrue(uploadSuccessMsg.isDisplayed(), "Upload failed");
        clickOnELement("//a[@id='back']");
    }

    @AfterTest
            public void closeSession() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
