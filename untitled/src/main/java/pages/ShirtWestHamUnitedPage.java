package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ShirtWestHamUnitedPage extends TestBase {

    /**** repozytorium elementów ****/
    @FindBy(xpath = "//h1[contains(text(),'Koszulka West Ham United')]")
    private WebElement nameShirt;

    @FindBy(xpath = "//p[@class='price']")
    private WebElement priceShirt;

    @FindBy(xpath = "//input[@class='input-text qty text']")
    private WebElement quantityShirt;

    @FindBy(xpath = "//button[@name='add-to-cart']")
    private WebElement addToCart;

    @FindBy(xpath = "//a[contains(text(),'Zobacz koszyk')]")
    private WebElement seeBasket;

    @FindBy(className = "woocommerce-message")
    private WebElement infoSeeBasket;


    /**** konstruktor ****/
    public ShirtWestHamUnitedPage(){
        PageFactory.initElements(driver, this);
    }

    /**** metoda ****/
    public String getNameShirt() {
        String nameShirtText = nameShirt.getText();
        return nameShirtText;
    }

    public String getPriceShirt() {
        String price = priceShirt.getText();
        return price;
    }

    public String getQuantityShirt(){
        String quantity = quantityShirt.getAttribute("value");
        return quantity;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

    public String infoSeeBasket(){
        String info = infoSeeBasket.getText();
        return info;
    }

    public WebElement getSeeBasket() {
        return seeBasket;
    }
}
