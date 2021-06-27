import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC3_CheckBasketEmptyTest {

    // Test3 : Check Shopping basket is empty on Gigatron page

    @Test
    public void openBrowser() throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Creating object of Gigatron Home page
        GigatronHomePage gigatronHome = new GigatronHomePage(driver);

        //Creating object of Gigatron Basket page
        GigatronBasketPage gigatronBasket = new GigatronBasketPage(driver);

        // Launch Gigatron page
        gigatronHome.openGigatronURL();
        Thread.sleep(5000);

        // Accept cookies on Gigatron site
        gigatronHome.clickAcceptCookies();
        Thread.sleep(3000);

        // Find Basket icon and click
        gigatronBasket.clickBasket();
        Thread.sleep(3000);

        // Verify if Basket is empty
        boolean isBasketEmpty = gigatronBasket.basketEmpty();
        Assert.assertEquals(isBasketEmpty, true);
        Thread.sleep(3000);

        System.out.println("TEST PASSED: Shopping basket successfully checked.");

        Thread.sleep(3000);
        driver.quit();

    }
}
