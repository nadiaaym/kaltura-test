import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import utilities.Workflows;

public class UploadTest extends Workflows {

    @Test
    public void test1() {
        setup();
        login();
        uploadFile();
        openFile();
    }
    @AfterTest
            public void closeSession() throws InterruptedException {
        driver.quit();
    }
}
