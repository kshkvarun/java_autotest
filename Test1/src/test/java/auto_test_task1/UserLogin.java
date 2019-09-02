package auto_test_task1;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class UserLogin extends Temp {
  private String PtUrl = "https://pt2017.centralpoint.io";
  private String titleNames = "#productsPage1 > div > div > div > div > div.product-description.col-sm-18.col-md-15.col-lg-16 > a";
  private String title;
  private String prodInCart;
  private String delProd = "#yw0 > button > span";
  private String ManufacturLabel = "#custom-filters-block > div:nth-child(2) > div:nth-child(2) > div > div > div > div.scrollbar-dropdown.list-dropdown > ul > li:nth-child(9) > div > label";
  private String ManufactFacetSearch = "#custom-filters-block > div:nth-child(2) > div:nth-child(2) > div > div > div > div.search-button.search-button-static > a";
  Random random = new Random();

  @BeforeMethod
  public void setUp() {
    Configuration.startMaximized = true;
    Configuration.holdBrowserOpen = true;
      }

  private String compare;
  @Test(priority = 1)
  public void logging() {
    open(PtUrl);
    $("#LoginForm_username").setValue("test_main");
    $("#password-field").setValue("@Admin123");
    $(".blue-btn").click();
    $("#keyword").shouldBe(visible);
  }
  @Test(priority = 2)
  public void selectProduct() {

    open(PtUrl.concat("/catalog/tablets"));
    $("#custom-filters-block > div:nth-child(2) > div:nth-child(2) > div > div > div > div.dropdown-title").click();
    executeJavaScript("arguments[0].scrollIntoView(true);", $("#check-728"));
    String amount = $(ManufacturLabel).getText();
    compare = reg(amount, "(\\d+)");
    $("#check-728").click();
    $(ManufactFacetSearch).click();

    $(By.className("search-result-info")).shouldBe(text(" results for \"Lenovo\""));


  }
   @Test(priority = 3)
   public void compare () {
   String text = $(By.className("search-result-info")).getText();
   //sleep(7000000)
   String number = reg(text, "(\\d+)");
      Assert.assertEquals(number, compare);
  }

  @Test(priority = 4)
  public void addToCart () {
    ElementsCollection iconCarts = $$(".icon-cart");
    List<SelenideElement> selenideElements = $$(titleNames);
    int i = random.nextInt(iconCarts.size()-1);
    title = selenideElements.get(i).getText();
    iconCarts.get(i).scrollTo().click();
    $(".fa-shopping-cart.icon_cart > span").shouldBe(appears).should(text("1"));
    $("#cart-container > a > div.cartTop.account-cart > div.small.icon > span.fa.fa-shopping-cart.icon_cart").click();
    }
  @Test(priority = 4)
    public void compareInCart () {
    prodInCart = $(By.className("cart-product__title")).getText();
    Assert.assertEquals(title, prodInCart);
    $(delProd).click();
    $("body > div.page-wrap.container > div > p").shouldHave(text("You still do not have items in your basket"));
    $("body > header > div.container > menu > li.account.dropdown-list > a > div.icon > span").click();
    $("#account-profile-menu > a.logout").scrollTo().click();
    $("#LoginForm_username").shouldBe(appears);



     }
  }

