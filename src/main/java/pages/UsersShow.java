package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import support.Action;

public class UsersShow extends DriverManager {


    private By lblNotice = By.id("notice");
    private By btnBack = By.cssSelector(".ls-btn-primary-danger");
    private By lblCode = By.id("codigo");
    private By lblLogin = By.id("login");
    private By lblFullName = By.id("full_name");
    private By lblEmail = By.id("email");
    private By lblAge = By.id("age");

    public String getNotice() {
        return getDriver().findElement(lblNotice).getText();
        }

    public void clickBack() {
        Action.getVisibleElement(btnBack);
        getDriver().findElement(btnBack).click();
    }

    public String getCode() {
        return getDriver().findElement(lblCode).getText();
    }

    public String fillField(String field)  {
        String res = "";
        switch (field){
            case "login":
                res = getLogin();
                break;
            case "nome completo":
                res = getFullName();
                break;
            case "email":
                res = getEmail();
                break;
            case "idade":
                res = getAge();
                break;

        }
        return res;

    }


    private String getLogin()  {

        Action.getVisibleElement(lblLogin);
        return getDriver().findElement(lblLogin).getText();
    }

    private String getFullName() {
        Action.getVisibleElement(lblFullName);
        return getDriver().findElement(lblFullName).getText();
    }

    private String getEmail() {
        Action.getVisibleElement(lblEmail);
        return getDriver().findElement(lblEmail).getText();
    }

    private String getAge() {
        Action.getVisibleElement(lblAge);
        return getDriver().findElement(lblAge).getText();
    }
}
