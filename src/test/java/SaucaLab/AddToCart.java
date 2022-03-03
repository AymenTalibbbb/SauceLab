package SaucaLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class AddToCart {
    WebDriver driver = null;

    public AddToCart(WebDriver driver) {
        this.driver = driver;
    }

    By btn_AddToCart = By.id("add-to-cart-sauce-labs-backpack");
    By btn_AddToCart1 = By.id("add-to-cart-sauce-labs-bike-light");
    //By btn_AddToCart2 = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By btn_cart = By.id("shopping_cart_container");
    String firstName;
    String lastName;
    String ZipCode;
    By btn_checkout = By.id("checkout");
    By txt_firstName = By.id("first-name");
    By txt_lastName= By.id("last-name");
    By txt_zipcode= By.id("postal-code");
    By btn_continue = By.id("continue");

    public void Cart_website() {

        try {


            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("C:\\Users\\talibaym\\IdeaProjects\\finalproject\\src\\test\\SauceLab\\CheckoutData.xml");
            //System.out.println(doc.getDocumentElement().getNodeName());
            NodeList list = doc.getElementsByTagName("checkoutScenario");
            for (int i = 0; i < list.getLength(); i++) {
                Node n = list.item(i);
                //System.out.println(n.getNodeName());
                Element e = (Element) n;
                firstName= e.getElementsByTagName("firstName").item(0).getTextContent();
                lastName=  e.getElementsByTagName("lastName").item(0).getTextContent();
                ZipCode=  e.getElementsByTagName("ZipCode").item(0).getTextContent();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        driver.findElement(btn_AddToCart).click();
        driver.findElement(btn_AddToCart1).click();
        //driver.findElement(btn_AddToCart2).click();
        driver.findElement(btn_cart).click();
        driver.findElement(btn_checkout).click();
        driver.findElement(txt_firstName).sendKeys(firstName);
        driver.findElement(txt_lastName).sendKeys(lastName);
        driver.findElement(txt_zipcode).sendKeys(ZipCode);
        driver.findElement(btn_continue).click();



    }
    public void price_validation()
    {
        List<WebElement> beforeFilterPrice1 = driver.findElements(By.className("inventory_item_price"));
        List<Double> priceList1 = new ArrayList<>();
        for (WebElement p : beforeFilterPrice1) {
            priceList1.add(Double.valueOf(p.getText().replace("$", "")));
        }
        Double sumList=priceList1.stream().mapToDouble(n->n).sum();
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]"));
        Double Tax = Double.valueOf(element2.getText().replace("Tax: $",""));
        Double price_with_tax = sumList+Tax;
        WebElement Element = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]"));
        Double Total = Double.valueOf(Element.getText().replace("Total: $",""));
        Assert.assertEquals(Total,price_with_tax,"price is not calculated correctly");

    }

}







