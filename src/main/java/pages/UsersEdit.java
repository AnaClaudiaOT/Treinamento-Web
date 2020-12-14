package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import support.Action;

public class UsersEdit extends DriverManager {


    private By inputFullName = By.id("user_full_name");
    private By btnSave = By.id("btn-save");


    public void fillField(String field, String value) {
        switch (field) {
            case "login":
                break;
            case "nome completo":
                fillFullName(value);
                break;
            case "email":
                break;
            case "idade":
                break;

        }
    }

    private void fillFullName(String value) {
        Action.getVisibleElement(inputFullName);
        getDriver().findElement(inputFullName).clear();
        getDriver().findElement(inputFullName).sendKeys(value);
    }

    public void clickSave() {

        getDriver().findElement(btnSave).click();
    }
}
