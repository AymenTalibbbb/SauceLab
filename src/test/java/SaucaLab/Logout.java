package SaucaLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Logout {
    WebDriver driver;

    public Logout (WebDriver driver) {
        this.driver = driver;
    }

    By btn_menu = By.id("react-burger-menu-btn");
    By btn_logout = By.id("logout_sidebar_link");

    public void logout_website()
    {
        driver.findElement(btn_menu).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
        driver.findElement(btn_logout).click();
    }
    public void logout_validation()
    {
        String title = driver.getTitle();
        //System.out.println("Page Title: "+title);
        Assert.assertEquals(title,"Swag Labs","The title doesn't matched");
    }

}




