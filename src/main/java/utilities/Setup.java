package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Setup extends Base{
    public void setup() {
        WebDriverManager.chromedriver().setup();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        final Logger logger = LoggerFactory.getLogger(Workflows.class);
        String userName = System.getenv("USER_NAME");
        String password = System.getenv("PASSWORD");
        String filePath = System.getenv("FILE_PATH");

        driver.get("http://1722461-2.qakmstest.dev.kaltura.com");
        driver.manage().window().maximize();
//        Assert.assertTrue(userName.);
    }
}
