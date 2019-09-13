package auto_test_task2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class GeneralBase {
  private String UrlBO = "https://pt2017.centralpoint.io/admin/user/login";
  private String Login = "#UserLogin_username";
  private String Pass = "#UserLogin_password";
  private String LoginButton = ".margin-bottom-more";
  private String Documents = "#menu2 > li:nth-child(2) > a";
  private String Root = "div > ul > li > div > span.clickable";
  private String AddCatRoot = "#yw0 > div > div.col-lg-6 > div > ul > li > div > span.add-delete-category-button > i";
  private String TabEN = "#CategoryDocument_multilingual_1_name";
  private String TabFR = "#CategoryDocument_multilingual_3_name";
  private String TabNL = "#CategoryDocument_multilingual_2_name";
  private String CatSave = ".modal-footer > button.footer_save.btn.btn-primary";
  private String CatClick = "#yw0 > div > div.col-lg-6 > div > ul > li > ul > li:nth-child(2) > div > span.clickable";
  private String AddDoc = "#DocumentFile-grid > table.grid-controls-panel > tbody > tr > td:nth-child(2) > a";
  private String DocName = "#DocumentFile_name";
  private String LngDropDown = "#DocumentFile_language_id";
  private String LngSelect = "#DocumentFile_language_id > option:nth-child(3)";
  private String Choosefile = "#DocumentFile_pathTmp";
  private String DepartmentCheck = "#access_department_all";
  private String DCMCheck = "#access_dcm_all";
  private String MainCheck = "#access_main_all";
  private String CustomersCheck = "#access_customer_all";
  private String NewDocCreate = "#yw0 > div.panel-footer > div > button.controlling_buttons.save_form.btn.btn-success";
  private String ChekTheDoc = "#DocumentFile-grid > table.grid-controls-panel > tbody > tr > td:nth-child(1) > div > span";
  private String LngManageBO = "https://pt2017.centralpoint.io/admin/language/language";
  private String LngAddBtn = "#grid > table.grid-controls-panel > tbody > tr > td:nth-child(2) > a";
  private String LngNumbr = "#Languages_language_id";
  private String LngName = "#Languages_name";
  private String LngCode = "#Languages_code";
  private String LngActivate = "#Languages_active";
  private String LangCheck = "#Languages_code > option:nth-child(27)";
  private String OgoneCode = "#Languages_ogone_code";
  private String ChooseFlag = "#Languages_flagFile";
  private String LngCreate = "#yw0 > div.panel-footer > div > button.controlling_buttons.save_form.btn.btn-success";
  private String LngBack = "#yt0";



  @BeforeClass
  public void setUp() {
    Configuration.startMaximized = true;
    Configuration.holdBrowserOpen = true;
    Configuration.reportsFolder = "target/allure-results";
    Configuration.browser = "Selenoid.SolenoidDriver";
  }


//  @AfterMethod
//  public void tearDown() {
//
//    }

//  public void onTestFailure(ITestResult result) {
//    saveScreenshot();
//  }

  protected void LogInToBO(String LV, String PV) {
    open(UrlBO);
    $(Login).setValue(LV);
    $(Pass).setValue(PV);
    $(LoginButton).click();
    $("#yw0 > div.panel-body > div > div:nth-child(2) > h4").shouldBe(visible);

  }

  protected void goToDocuments() {
    $(Documents).click();
    $("#top > div > div.col-lg-20.slide_right > div.row_title > div > h3").shouldBe(text("Documents"));
  }

  protected void addNewCategory() {
    $(Root).hover();
    $(AddCatRoot).click();
    $("#CategoryDocument_parent_id").shouldBe(text("Root"));
    $(TabEN).setValue("DocEn");
    $("#yw0 > ul > li:nth-child(2) > a").click();
    $(TabFR).setValue("DocFr");
    $("#yw0 > ul > li:nth-child(3) > a").click();
    $(TabNL).setValue("DocNl");
    $(CatSave).click();
    refresh();
    $$ (".clickable").first().should(visible);
    System.out.println($$ (".clickable").size());
    //Check if new category was added
    ElementsCollection CatName = $$ (".clickable");
    List<String> texts = new ArrayList<String>();
    for(SelenideElement element : CatName){
      System.out.println(element.getText());
      texts.add(element.getText());
    }
    boolean result = texts.contains("DocEn (0)");
    Assert.assertTrue(result);
  }

  protected void addNewDocument() {
    $(CatClick).click();
    $(AddDoc).click();
    $(DocName).setValue("DocTest");
    $(LngDropDown).click();
    $(LngSelect).click();
    $(Choosefile).uploadFile(new File("/home/kostya/Рабочий стол/En.pdf"));
    $(DepartmentCheck).click();
    $(DCMCheck).click();
    $(MainCheck).click();
    $(CustomersCheck).click();
    $(NewDocCreate).click();
    $(ChekTheDoc).shouldBe(text("1"));
  }

  protected void addNewLng() {
    open(LngManageBO);
    $(LngAddBtn).click();
    $(LngNumbr).setValue("68");
    $(LngName).setValue("GE");
    $(OgoneCode).setValue("QWEQWEQWE");
    $(LngCode).click();
    $(LangCheck).scrollTo().click();
    $(ChooseFlag).uploadFile(new File("/home/kostya/Рабочий стол/Label 8.jpg"));
    $(LngActivate).click();
    $(LngCreate).click();
    sleep(2000);
    $(LngBack).click();
  }

}
