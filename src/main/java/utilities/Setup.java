package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Setup {

    protected String userName;
    protected String password;
    protected String filePath;
    protected Logger logger;
    public WebDriver driver = new ChromeDriver();
    public WebDriverWait wait;
    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.logger = LoggerFactory.getLogger(Workflows.class);
        this.userName = System.getenv("USER_NAME");
        this.password = System.getenv("PASSWORD");
        this.filePath = System.getenv("FILE_PATH");
        Assert.assertNotNull(userName, "Please define an environment variable for username");
        Assert.assertNotNull(password, "Please define an environment variable for password");
        Assert.assertNotNull(filePath, "Please define an environment variable for the file path you want to upload");

        driver.get("http://1722461-2.qakmstest.dev.kaltura.com");
        driver.manage().window().maximize();
    }
}
