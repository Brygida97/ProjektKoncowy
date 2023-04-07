package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage extends TestBase {

    /**** repozytorium elementów ****/
    @FindBy(xpath = "//h2[contains(text(),'Koszulka West Ham United')]")
    private WebElement shirtWestHamUnited;

    /**** konstruktor ****/
    public ShopPage(){
        PageFactory.initElements(driver, this);
    }

    /**** metoda ****/
    public WebElement getShirtWestHamUnited() {
        return shirtWestHamUnited;
    }
}
