import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GigatronHomePage {

    WebDriver driver;

    //Locator for Accept cookies button
    By acceptCookiesBtn = By.xpath("//button[text()='Prihvatam']");

    //Locator for Gigatron site title
    String gigatronTitle = "Važno je gde kupujete tehniku | Gigatron";

    //Locator for Facebook header icon
    By fbHeaderElem = By.xpath("//li[@class='social']//a[contains(@href,'https://www.facebook.com/GigatronRS')]");

    //Locator for Facebook footer icon
    By fbFooterElem = By.xpath("//div[@class='footer-social']/a[contains(@href,'https://www.facebook.com/GigatronRS')]");

    //Locator for Instagram header icon
    By instHeaderElem = By.xpath( "//li[@class='social']//a[contains(@href,'https://www.instagram.com/gigatron.rs')]");

    //Locator for Instagram footer icon
    By instFooterElem = By.xpath("//div[@class='footer-social']/a[contains(@href,'https://www.instagram.com/gigatron.rs')]");

    //Constructor that will be called as soon as the object of the class is created
    public GigatronHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Method to open Gigatron URL
    public void openGigatronURL() {
        driver.get("https://www.gigatron.rs/");
        System.out.println("Step 1: Open Gigatron page - SUCCESS");
    }

    //Method to click on Accept cookies button
    public void clickAcceptCookies() {
        driver.findElement(acceptCookiesBtn).click();
        System.out.println("Accept cookies on Gigatron site - SUCCESS");
    }

    //Method for checking Gigatron site title exists
    public boolean siteTitleVisible(){
        if (driver.getTitle().contains(gigatronTitle))
        {
            System.out.println("Step 5: Open Gigatron site and verify title - SUCCESS");
            return true;
        }
        else
            System.out.println("ERROR opening Gigatron site and verifing title - FAILED");
            return false;
    }

    //Method for checking Facebook widget exists
    public boolean fbWidgetsExist(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(fbHeaderElem));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fbFooterElem));
        if (driver.findElements(fbHeaderElem).size() !=0 && driver.findElements(fbFooterElem).size() !=0 )
        {
            System.out.println("Step 2: Check Gigatron Facebook widgets - SUCCESS");
            return true;
        }
        else
            System.out.println("ERROR Checking Gigatron Facebook widgets - FAILED");
            return false;
    }

    //Method for checking Instagram widget exists
    public boolean instWidgetsExist(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(instHeaderElem));
        wait.until(ExpectedConditions.visibilityOfElementLocated(instFooterElem));
        if (driver.findElements(instHeaderElem).size() !=0 && driver.findElements(instFooterElem).size() !=0)
        {
            System.out.println("Step 3: Check Gigatron Instagram widgets - SUCCESS");
            return true;
        }
        else
            System.out.println("ERROR Checking Gigatron Instagram widgets - FAILED");
            return false;
    }
}
