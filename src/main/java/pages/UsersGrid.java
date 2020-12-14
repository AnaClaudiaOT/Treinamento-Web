package pages;

import driver.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import support.Action;


public class UsersGrid extends DriverManager {

    By btnNewUser = By.cssSelector("#btn-new");

    public void clickNewUser() {
        Action.getVisibleElement(btnNewUser);
        getDriver().findElement(btnNewUser).click();
    }

    public void clickShowUser(String lastUser) {
        String elem = String.format("//a[@href='/users/%s']", lastUser); // botão mostrar
        By btnShowLastUser = By.xpath(elem);
        Action.getVisibleElement(btnShowLastUser);
        getDriver().findElement(btnShowLastUser).click();
    }

    public void clickEditUser(String lastUser) {
        String elem = String.format("//a[@href='/users/%s/edit']", lastUser);
        By btnShowLastUser = By.xpath(elem);
        Action.getVisibleElement(btnShowLastUser);
        getDriver().findElement(btnShowLastUser).click();
    }

    public void clickDeleteUser(String lastUser) {
        String elem = String.format("/html/body/main/div/table/tbody/tr[11]/td[8]/a", lastUser);
        By btnShowLastUser = By.xpath(elem);
        Action.getVisibleElement(btnShowLastUser);
        getDriver().findElement(btnShowLastUser).click();
    }

    public void clickConfirmDelete() {
        final Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    public boolean getShowButton(String lastUser) {
        String elem = String.format("//*[@id=\"btn-show_\"]/a", lastUser);
        By btnUserShow = By.xpath(elem);
        return Action.existElement(btnUserShow, 10);
    }
}
