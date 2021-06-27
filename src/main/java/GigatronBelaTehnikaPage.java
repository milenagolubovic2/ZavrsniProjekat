import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GigatronBelaTehnikaPage {

    WebDriver driver;

    //Locator for Products menu
    By proizvodiMenuElem = By.xpath("//button[contains(.,'Proizvodi')]");

    //Locator for 'Bela tehnika' menu
    By belaTehnikaMenuElem = By.xpath("//div[@class='content']//a[text()='Bela tehnika']");

    //Locator for 'Bela tehnika' page
    By belaTehnikaPageElem = By.xpath("//span[@itemprop='title' and text()='Početna']/../../..//a[text()='Bela tehnika']");

    //Locator for Frizideri
    By frizideriElem = By.xpath("//a[text()='Ugradni frižideri sa jednim vratima']");

    //Locator for Frizideri page
    By frizideriPageElem = By.xpath("//h1[text()='Frižideri sa jednim vratima']");

    //Locator for Gorenje
    By gorenjeElem = By.xpath("//span[text()='Gorenje']/..");

    //Locator for First Product
    By firstProductElem = By.xpath("//div[@class='row product-items-main elastic-grid view-grid']/div[1]");

    //Locator for sorting
    By sortElem = By.name("sort");

    //Locator for Products page
    By productPageElem = By.xpath("//span[@itemprop='title' and text()='Početna']/../../..//a[text()='Frižideri sa jednim vratima']");

    //Locator for Product available
    By productAvailElem = By.xpath("//span[(@itemprop='availability' and contains(text(),'Proizvod raspoloživ za online kupovinu'))]");

    //Locatpr for Adding product to the basket
    By dodajElem = By.xpath("//div[@class='product-main-price']//span[@class='btnTxt' and text()='Dodaj u korpu']");

    //Locator for Product added
    By productAddedElem = By.xpath("//div[@class='submit-window']//h4[text()='Proizvod je dodat u korpu']");

    //Constructor that will be called as soon as the object of the class is created
    public GigatronBelaTehnikaPage(WebDriver driver) {
        this.driver = driver;
    }


    //Method to click on Products menu
    public void clickProductMenu() {
        driver.findElement(proizvodiMenuElem).click();
        System.out.println("Step 2: Click on Products menu - SUCCESS");
    }

    //Method to click on 'Bela tehnika' menu
    public void clickBelaTehnikaMenu() {
        driver.findElement(belaTehnikaMenuElem).click();
        System.out.println("Step 3: Click on Category 'Bela tehnika' - SUCCESS");
    }

    //Method to wait for page 'Bela tehnika' to be loaded and select 'Ugradni frižideri sa jednim vratima'
    public void clickOnUgradniFrizideri() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(belaTehnikaPageElem));
        driver.findElement(frizideriElem).click();
        System.out.println("Step 4: Select 'Ugradni frizideri sa jednim vratima' - SUCCESS");
    }

    // Method to wait for page 'Frizideri sa jednim vratima' page to be loaded and select certain type
    public void selectGorenje() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(frizideriPageElem));
        driver.findElement(gorenjeElem).click();
        System.out.println("Step 5: Select checkbox 'Gorenje' from left menu - SUCCESS");
    }

    //Method for sorting products
    public void sortProducts(){
        Select subjectSelect = new Select(driver.findElement(sortElem));
        subjectSelect.selectByVisibleText("Ceni Opadajuće");
        System.out.println("Step 6: Sort products by Price - SUCCESS");
    }

    //Method to select first product from 'Gorenje' sorted list
    public void selectProduct() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductElem));
        driver.findElement(firstProductElem).click();
        System.out.println("Step 7: Select most expensive product - SUCCESS");
    }

    // Method to wait for Product page to be loaded and check if Product is available for online shopping
    public boolean checkProductAvailableAndAddToBasket(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPageElem));
        if (driver.findElements(productAvailElem).size() != 0)
        {
            driver.findElement(dodajElem).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(productAddedElem));
            System.out.println("Step 8: Add wanted product to the Basket - SUCCESS");
            return true;
        }
        else
            System.out.println("WARNING: Product not available for online shopping, please select another one!");
            return false;
    }

}
