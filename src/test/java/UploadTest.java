import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import utilities.Assertions;
import utilities.Workflows;

public class UploadTest extends Workflows {

    @Test
    public void test1() {
        setup();
        loginBtn();
        login();
        uploadFile();
        openFile();
    }
    @AfterTest
            public void closeSession() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
