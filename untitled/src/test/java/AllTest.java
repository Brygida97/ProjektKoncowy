import base.TestBase;
import helpers.GlobalMethods;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Cart;
import pages.Checkout;
import pages.ShirtWestHamUnitedPage;
import pages.ShopPage;

public class AllTest extends TestBase {

    GlobalMethods globalMethods;
    ShopPage shopPage;

    ShirtWestHamUnitedPage shirtWestHamUnitedPage;

    Cart cart;

    Checkout checkout;

    @BeforeTest
    public void startTest(){
        initialization();
        globalMethods = new GlobalMethods();
        shopPage = new ShopPage();
        shirtWestHamUnitedPage = new ShirtWestHamUnitedPage();
        cart = new Cart();
        checkout = new Checkout();
    }

    @Test(priority = 1)
    public void test1(){
        globalMethods.clickButton(shopPage.getShirtWestHamUnited());
        globalMethods.takeScreenShot(1);
        globalMethods.getPageURL();
        Assert.assertEquals(globalMethods.getPageURL(),testdata.getProperty("correctURL"),"URL strony, na której się znajdujesz jest niepoprawny");
    }

    @Test(priority = 2)
    public void test2(){
        Assert.assertEquals(shirtWestHamUnitedPage.getNameShirt(),testdata.getProperty("correctNameShirt"),"Nazwa produktu jest niepoprawna");
    }

    @Test(priority = 3)
    public void test3(){
        Assert.assertEquals(shirtWestHamUnitedPage.getPriceShirt(),"90,00 ZŁ","Cena produktu jest niepoprawna");
    }

    @Test(priority = 4)
    public void test4(){
        Assert.assertEquals(shirtWestHamUnitedPage.getQuantityShirt(),testdata.getProperty("correctQuantityShirt"), "Liczba wybranych produktów jest inna niż 1");
    }

    @Test(priority = 5)
    public void test5(){
        globalMethods.clickButton(shirtWestHamUnitedPage.getAddToCart());
        Assert.assertEquals(shirtWestHamUnitedPage.infoSeeBasket(),"Zobacz koszyk\n“Koszulka West Ham United” został dodany do koszyka.", "Na stronie pojawia się błędny komunikat");
    }

    @Test(priority = 6)
    public void test6(){
        globalMethods.clickButton(shirtWestHamUnitedPage.getSeeBasket());
        globalMethods.takeScreenShot(6);
        Assert.assertEquals(globalMethods.getPageTitle(),"Koszyk – Selenium Shop Automatyzacja Testów","Tytuł strony jest niepoprawny");
    }

    @Test(priority = 7)
    public void test7(){
        cart.getShippingMethod().isSelected();
    }

    @Test(priority = 8)
    public void test8(){
        globalMethods.clickButton(cart.getGoToCheckout());
        globalMethods.takeScreenShot(8);
        Assert.assertEquals(globalMethods.getPageTitle(),"Zamówienie – Selenium Shop Automatyzacja Testów","Tytuł strony jest niepoprawny");
    }

    @Test(priority = 9)
    public void test9(){
        Assert.assertEquals(checkout.getNameProduct(),testdata.getProperty("correctNameProduct"),"Nazwa produktu w koszyku jest niepoprawna");
    }

    @Test(priority = 10)
    public void test10(){
        Assert.assertEquals(checkout.getPriceProduct(),"90,00 zł","Cena produktu w koszyku jest niepoprawna");
    }

    @Test(priority = 11)
    public void test11(){
        checkout.getShippingMethod().isSelected();
    }

    @Test(priority = 12)
    public void test12(){
        Assert.assertEquals(checkout.getOrderTotal(),"90,00 zł","Suma w koszyku jest niepoprawna");
    }

    @AfterTest
    public void endTest(){
        driver.quit();
    }
}
