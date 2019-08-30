package auto_test_task1;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class UserLogin extends Temp {

  private String compare;

  @Test(priority = 1)
  public void logging() {
    open("https://pt2017.centralpoint.io");
    $("#LoginForm_username").setValue("test_main");
    $("#password-field").setValue("@Admin123");
    $(".blue-btn").click();
    $("#keyword").shouldBe(visible);
  }
  @Test(priority = 2)
  public void selectProduct() {

    open("https://pt2017.centralpoint.io/catalog/tablets");
    $("#custom-filters-block > div:nth-child(2) > div:nth-child(2) > div > div > div > div.dropdown-title").click();
    executeJavaScript("arguments[0].scrollIntoView(true);", $("#check-728"));
    String amount = $("#custom-filters-block > div:nth-child(2) > div:nth-child(2) > div > div > div > div.scrollbar-dropdown.list-dropdown > ul > li:nth-child(9) > div > label").getText();
    compare = reg(amount, "(\\d+)");
        //System.out.println(amount);
    //System.out.println(facetamo);
    $("#check-728").click();
    $("#custom-filters-block > div:nth-child(2) > div:nth-child(2) > div > div > div > div.search-button.search-button-static > a").click();
    $(By.className("search-result-info")).shouldBe(text(" results for \"Lenovo\""));


  }
   @Test(priority = 3)
   public void compare () {
   String text = $(By.className("search-result-info")).getText();
   //sleep(7000000)
   String number = reg(text, "(\\d+)");
      Assert.assertEquals(number, compare);

  }

  }

