package auto_test_task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Temp {

  public String reg(String str, String regex) {
   // String str = "Крещение Руси произошло в 988 году! Не так ли?";
    String pattern = regex;

    // Создание Pattern объекта
    Pattern r = Pattern.compile(pattern);

    // Создание matcher объекта
    Matcher m = r.matcher(str);
    if (!m.find()) {

      return  "Найдено значение: " + m.group(1);

    } else {
      return m.group(0);
    }
  }

  }
