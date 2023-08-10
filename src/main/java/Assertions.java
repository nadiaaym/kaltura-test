import org.testng.Assert;
import utilities.Base;
import utilities.CommonOps;

public class Assertions extends CommonOps {

    public void verifyTitle(String title, String expected, String message) {
        Assert.assertEquals(driver.getTitle(), expected, message);
    }
}
