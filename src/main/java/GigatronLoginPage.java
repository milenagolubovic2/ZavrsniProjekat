import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GigatronLoginPage {

    WebDriver driver;

    //Locator for login form
    By loginFormElem = By.linkText("Prijava");

    //Locator for email field
    By eMailElem = By.id("email");

    //Locator for password field
    By pswdElem = By.id("password");

    //Locator for Login button
    By LoginBtn = By.id("loginSubmit");

    //Locator for checking User page
    By userPageElem = By.xpath("//span[@class='user-identity-name']//b[text()='Milena']");

    //Locator for checking User full name
    By userFullNameElem = By.xpath( "//ul//li[contains(.,'Milena G')]");

    //Constructor that will be called as soon as the object of the class is created
    public GigatronLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Method to open login form
    public void clickLoginForm() {
        driver.findElement(loginFormElem).click();
        System.out.println("Step 2: Open Login form  - SUCCESS");
    }

    //Method to enter email
    public void enterEmail(String user) {
        driver.findElement(eMailElem).sendKeys(user);
        System.out.println("Step 3: Enter email - SUCCESS");
    }

    //Method to enter password
    public void enterPassword(String pass) {
        driver.findElement(pswdElem).sendKeys(pass);
        System.out.println("Step 4: Enter password - SUCCESS");
    }

    //Method to click on login button
    public void clickLogin() {
        driver.findElement(LoginBtn).click();
        System.out.println("Step 5: Click on Login button  - SUCCESS");
    }

    //Method for wait for page to be loaded and verify user successful login
    public boolean checkUserLoginSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userPageElem));
        if (driver.findElement(userFullNameElem).getText().contains("Milena G")) {
            System.out.println(driver.findElement(userFullNameElem).getText().contains("Milena G"));
            System.out.println("TEST PASSED: User is Successfully login on his account.");
            return true;
        }
        else
        {
            System.out.println("TEST FAILED: User did not login on his account.");
            return false;
        }
    }

}
