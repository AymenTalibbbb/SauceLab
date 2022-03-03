package SaucaLab;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public WebDriver driver;


    public BrowserFactory(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        } else if (browserName.equalsIgnoreCase("FireFox")) {
            //System.setProperty("webdriver.gecko.driver", "C:\\Users\\talibaym\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();

            driver.manage().window().maximize();
        } else if (browserName.equals("Edge")) {
            //System.setProperty("webdriver.edge.driver", "C:\\Users\\talibaym\\Downloads\\edgedriver_win64\\msedgedriver.exe");

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
    }
}






