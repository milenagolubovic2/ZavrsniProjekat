import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {

    WebDriver driver;

    //Locator for Google search field
    By searchFieldElem = By.name("q");

    //Locator for click on Google search button
    By searchBtn = By.name("btnK");

    //Locator for click on Search result
    By searchResultElem = By.xpath("//a[contains(@href,'https://gigatron.rs')]/h3[normalize-space(text()='Gigatron')]");

    //Constructor that will be called as soon as the object of the class is created
    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Method to open Google URL
    public void openGoogleURL() {
        driver.get( "http://www.google.rs");
        System.out.println("Step 1: Open Google page - SUCCESS");
    }

    //Method for enter text in Google search field
    public void enterGoogleSearch(String searchText) {
        driver.findElement(searchFieldElem).sendKeys(searchText);
        System.out.println("Step 2: Type " + searchText + " in search field - SUCCESS");
    }

    //Method to click on Google search button
    public void clickGoogleSearch() {
        driver.findElement(searchBtn).click();
        System.out.println("Step 3: Click on Google search button - SUCCESS");
    }

    //Method to click on search result
    public void clickSearchResult() {
        driver.findElement(searchResultElem).click();
        System.out.println("Step 4: Find Gigatron in search results - SUCCESS");
    }
}

