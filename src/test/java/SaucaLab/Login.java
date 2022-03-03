package SaucaLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Login {
    WebDriver driver = null;

    public Login(WebDriver driver)
    {
        this.driver=driver;
    }
    String username;
    String password;

    By txt_username = By.id("user-name");
    By txt_password = By.id("password");
    By btn_login = By.id("login-button");

    public void loginWeb()
    {


        try {


            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("C:\\Users\\talibaym\\IdeaProjects\\finalproject\\src\\test\\SauceLab\\LoginData.xml");

            NodeList list = doc.getElementsByTagName("loginScenario");
            for (int i = 0; i < list.getLength(); i++) {
                Node n = list.item(i);

                Element e = (Element) n;
                username= e.getElementsByTagName("username").item(0).getTextContent();
                password =  e.getElementsByTagName("password").item(0).getTextContent();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        driver.get("https://www.saucedemo.com/");
        driver.findElement(txt_username).sendKeys(username);
        driver.findElement(txt_password).sendKeys(password);
        driver.findElement(btn_login).click();

    }
    public void login_validation()
    {
        String ExpectedUrl = "https://www.saucedemo.com/inventory.html";
        String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(ActualUrl,ExpectedUrl,"can't logged into the system");
    }
}



