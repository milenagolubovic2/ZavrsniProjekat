import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GigatronBasketPage {

    WebDriver driver;

    //Locator for Basket icon
    By basketElem = By.xpath("//span[@class='icon cart']");
    //Locator for empty basket status
    By emptyBasketElem = By.xpath("//div/h3[(text()='Vaša korpa je prazna')]");

    //Constructor that will be called as soon as the object of the class is created
    public GigatronBasketPage(WebDriver driver) {
        this.driver = driver;
    }

    //Method to click on Basket icon
    public void clickBasket() {
        driver.findElement(basketElem).click();
        System.out.println("Step 2: Click on Basket icon to check status - SUCCESS");
    }

    //Method for checking is Basket status
    public boolean basketEmpty(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        if (driver.findElements(emptyBasketElem).size() !=0 )
        {
            System.out.println("Step 3: Check that Basket is empty - SUCCESS");
            return true;
        }
        else
            System.out.println("ERROR verifying if Basket is empty - FAILED");
            return false;
    }

}
