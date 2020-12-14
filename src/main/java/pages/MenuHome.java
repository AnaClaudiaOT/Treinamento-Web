package pages;

import driver.DriverManager;
import org.openqa.selenium.By;

public class MenuHome extends DriverManager {

    private By mn_users = By.id("users");

    public void clickUsers() {
        getDriver().findElement(mn_users).click();
    }
}
