package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart extends TestBase {
    /**** repozytorium elementów ****/
    @FindBy(xpath = "//input[@name='shipping_method[0]']")
    private WebElement shippingMethod;

    @FindBy(xpath = "//a[contains(text(),'Przejdź do kasy')]")
    private  WebElement goToCheckout;


    /**** konstruktor ****/
    public Cart(){
        PageFactory.initElements(driver, this);
    }

    /**** metoda ****/
    public WebElement getShippingMethod(){
        return shippingMethod;
    }


    public WebElement getGoToCheckout() {
        return goToCheckout;
    }
}
