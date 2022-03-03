package SaucaLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Checkout {
    WebDriver driver = null;


    public Checkout(WebDriver driver)
    {
        this.driver=driver;
    }
    By btn_finish = By.id("finish");
    public void CheckOut()
    {
        driver.findElement(btn_finish).click();
    }
    public void CheckOut_validation()
    {
        WebElement element = driver.findElement(By.className("complete-header"));
        String Checkout_message_Actual =element.getText();
        String Checkout_message_expected = "THANK YOU FOR YOUR ORDER";
        //System.out.println("message :"+Checkout_message_Actual);
        Assert.assertEquals(Checkout_message_Actual,Checkout_message_expected,"Checkout not completed");
    }

}


