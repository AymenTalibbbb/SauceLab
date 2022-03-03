package SaucaLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Filter {
    public static WebDriver driver;

    public Filter(WebDriver driver) {
        this.driver = driver;
    }

    public void select_filter() {
        //low to high price list function

        List<WebElement> beforeFilterPrice = driver.findElements(By.className("inventory_item_price"));
        List<Double> priceList = new ArrayList<>();
        for (WebElement p : beforeFilterPrice) {
            priceList.add(Double.valueOf(p.getText().replace("$", "")));
        }
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Price (low to high)");
        List<WebElement> afterFilterPrice = driver.findElements(By.className("inventory_item_price"));
        List<Double> afterPriceList = new ArrayList<>();
        for (WebElement p : afterFilterPrice) {
            afterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }
        Collections.sort(priceList);
        Assert.assertEquals(priceList, afterPriceList);
    }

    public void select_filter1() {
        List<WebElement> beforeFilterPrice = driver.findElements(By.className("inventory_item_price"));
        List<Double> priceList = new ArrayList<>();
        for (WebElement p : beforeFilterPrice) {
            priceList.add(Double.valueOf(p.getText().replace("$", "")));
        }
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Price (high to low)");
        List<WebElement> afterFilterPrice = driver.findElements(By.className("inventory_item_price"));
        List<Double> afterPriceList = new ArrayList<>();
        for (WebElement p : afterFilterPrice) {
            afterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }
        Collections.sort(priceList, Collections.reverseOrder());
        Assert.assertEquals(priceList, afterPriceList);

    }


    public void select_filter2() {


        List<WebElement> beforeFilterName = driver.findElements(By.className("inventory_item_name"));
        List<String> nameList1 = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByVisibleText("Name (A to Z)");

        Collections.sort(nameList);
        Assert.assertEquals(nameList1, nameList);
        //Assert.assertEquals(priceList,afterPriceList);
    }

    public void select_filter3() {

        List<WebElement> beforeFilterName1 = driver.findElements(By.className("inventory_item_name"));
        List<String> nameList = new ArrayList<>();
        List<String> nameList1 = new ArrayList<>();
        Select dropdown1 = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown1.selectByVisibleText("Name (Z to A)");
        Collections.sort(nameList1, Collections.reverseOrder());
        Assert.assertEquals(nameList, nameList1);


    }
}

