package auto_test_task2;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners ({helpers.ListenerBase.class})

public class BOdocCategory extends GeneralBase {

  private String LoginValue = "admin";
  private String PassValue = "admin";
  private String CheckFlag = "#Languages_flagFile";
  private String urlFO = "https://pt2017.centralpoint.io/login";
  private String loginFOValue = "#LoginForm_username";
  private String passFOValue = "#password-field";

  @Test(priority = 1)
  public void LogInBO () {
    LogInToBO(LoginValue, PassValue);
  }

  @Test(priority = 2)
  public void AddDocCategorie () {
    goToDocuments();
    addNewCategory();
  }

//  @Test(priority = 3)
//  public void AddLng() {
//    addNewLng();
//  }

//  @Test(priority = 4)
//  public void docVisibilityCheck () {
//
//  }

}
