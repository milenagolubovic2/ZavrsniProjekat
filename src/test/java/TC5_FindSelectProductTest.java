import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC5_FindSelectProductTest {

    // Test5 : Search for a certain product select and verify

    @Test
    public void openBrowser() throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Creating object of Gigatron Home page
        GigatronHomePage gigatronHome = new GigatronHomePage(driver);

        //Creating object of Gigatron Home page
        GigatronBelaTehnikaPage gigatronBelaTehnika = new GigatronBelaTehnikaPage(driver);

        // Launch Gigatron page
        gigatronHome.openGigatronURL();
        Thread.sleep(5000);

        // Accept cookies on Gigatron site
        gigatronHome.clickAcceptCookies();
        Thread.sleep(3000);

        // Click on Products menu
        gigatronBelaTehnika.clickProductMenu();
        Thread.sleep(3000);

        // Select category 'Bela tehnika' from menu
        gigatronBelaTehnika.clickBelaTehnikaMenu();
        Thread.sleep(3000);

        // Wait for page 'Bela tehnika' to be loaded and select 'Ugradni frižideri sa jednim vratima'
        gigatronBelaTehnika.clickOnUgradniFrizideri();
        Thread.sleep(3000);

        // Wait for page 'Frizideri sa jednim vratima' page to be loaded and select certain type
        gigatronBelaTehnika.selectGorenje();
        Thread.sleep(3000);

        // Sort products by price
        gigatronBelaTehnika.sortProducts();
        Thread.sleep(3000);

        // Select first product from 'Gorenje' sorted list (most expensive)
        gigatronBelaTehnika.selectProduct();
        Thread.sleep(5000);

        // Wait for Product page to be loaded and check if Product is available for online shopping
        boolean isProductAvailAndAdded = gigatronBelaTehnika.checkProductAvailableAndAddToBasket();
        Assert.assertEquals(isProductAvailAndAdded, true);
        Thread.sleep(3000);

        System.out.println("TEST PASSED: Products found, sorted, selected and added to the basket.");

        Thread.sleep(3000);
        driver.quit();

    }
}
