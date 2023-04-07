package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout extends TestBase {
    /**** repozytorium elementów ****/
    @FindBy(xpath = "//*[@id=\"order_review\"]/table/tbody/tr/td[1]")
    private WebElement nameProduct;

//    @FindBy(xpath = "//span[@class='woocommerce-Price-amount amount']")
    @FindBy(xpath = "//*[@id=\"order_review\"]/table/tfoot/tr[1]/td/span")
    private WebElement priceProduct;

    @FindBy(xpath = "//*[@id=\"shipping_method\"]/li[1]/label")
    private WebElement shippingMethod;

    @FindBy(xpath = "//*[@id=\"order_review\"]/table/tfoot/tr[3]/td/strong/span")
    private WebElement orderTotal;

    /**** konstruktor ****/
    public Checkout(){
        PageFactory.initElements(driver, this);
    }

    /**** metoda ****/

    public String getNameProduct() {
        String name = nameProduct.getText();
        return name;
    }

    public String getPriceProduct() {
        String price=priceProduct.getText();
        return price;
    }

    public WebElement getShippingMethod() {
        return shippingMethod;
    }

    public String getOrderTotal() {
        String order=orderTotal.getText();
        return order;
    }
}
