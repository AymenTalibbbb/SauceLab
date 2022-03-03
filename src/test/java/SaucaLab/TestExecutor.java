package SaucaLab;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.devtools.v85.V85Domains;
import org.testng.annotations.Test;

public class TestExecutor extends Extent_Report{
    @Test(priority = 1)
    public void LoginTest() {

        try {
            test = extent.createTest("test functionality of login");
            BrowserFactory browser = new BrowserFactory("Chrome");
            test.log(Status.INFO, "Url and browser is initiataed");
            Login loginWebsite = new Login(browser.driver);
            test.log(Status.INFO, "username and password is entered");
            loginWebsite.loginWeb();
            test.log(Status.INFO, "login button is clicked");
            loginWebsite.login_validation();
            test.log(Status.PASS, "user is successfully logged in");

        } catch (Exception e) {
            test.log(Status.FAIL, e.getMessage());
        }
    }

    @Test(priority = 2)

    public void LogoutTest() {
        try {
            test = extent.createTest("test functionality of logout");
            BrowserFactory browser = new BrowserFactory("Chrome");
            test.log(Status.INFO, "Url and browser is initiataed");
            Login loginWebsite = new Login(browser.driver);
            Logout logout = new Logout(browser.driver);
            loginWebsite.loginWeb();
            test.log(Status.INFO, "login is done");
            logout.logout_website();

            test.log(Status.INFO, "logout is done");
            logout.logout_validation();
            test.log(Status.PASS, "logout is successfully done");
        } catch (Exception ex) {
            test.log(Status.FAIL, ex.getMessage());
        }
    }

    @Test(priority = 3)
    public void AddToCartTest() {
        try {
            test = extent.createTest("test functionality of add to cart");
            BrowserFactory browser = new BrowserFactory("Chrome");
            test.log(Status.INFO, "browser and url is initiated");
            Login loginWebsite = new Login(browser.driver);
            test.log(Status.INFO, "username and password is added");
            AddToCart addtoCart = new AddToCart(browser.driver);
            Filter filter = new Filter(browser.driver);
            loginWebsite.loginWeb();
            test.log(Status.INFO,"user is logged into the system by clicking on login button");
            filter.select_filter2();
            test.log(Status.INFO, "A to Z filter is applied");
            addtoCart.Cart_website();
            test.log(Status.INFO, "multiple items are added into the cart");
            addtoCart.price_validation();
            test.log(Status.PASS, "price calculation is done correctly");

        } catch (Exception e) {
            test.log(Status.FAIL, e.getMessage());
        }
    }

    @Test(priority = 4)
    public void CheckOutTest() {
        try {
            test = extent.createTest("test functionality of checkout");
            BrowserFactory browser = new BrowserFactory("Chrome");
            test.log(Status.INFO, "browser and url is initiated");
            Login loginWebsite = new Login(browser.driver);
            test.log(Status.INFO, "username and password is added");
            Remove remove = new Remove(browser.driver);
            Filter filter = new Filter(browser.driver);
            loginWebsite.loginWeb();
            test.log(Status.INFO,"user is logged into the system");
            filter.select_filter();
            test.log(Status.INFO,"Price(low to high) filter is applied");
            remove.remove_from_cart();
            test.log(Status.INFO, "multiple items are added into the cart");
            test.log(Status.INFO, "an item is removed from the cart");
            remove.price_validation();
            test.log(Status.INFO, "price calculation is done correctly after removal from the cart");
            Checkout checkout = new Checkout(browser.driver);
            test.log(Status.INFO, "checkout is done");
            checkout.CheckOut();
            test.log(Status.INFO, "finish button is clicked");
            checkout.CheckOut_validation();
            test.log(Status.PASS, "thank you message is displayed");


        } catch (Exception e) {
            test.log(Status.FAIL, e.getMessage());
        }

    }
}


