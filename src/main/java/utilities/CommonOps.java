package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommonOps extends Setup {

    public void clickOnELement(String str) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(str))).click();
    }
}
