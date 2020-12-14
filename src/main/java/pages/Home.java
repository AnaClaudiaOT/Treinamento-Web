package pages;

import driver.DriverManager;

public class Home extends DriverManager {


    public void openPage() {
        getDriver().get(configuration.url());
    }
}
