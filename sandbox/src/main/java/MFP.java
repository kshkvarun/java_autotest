import org.w3c.dom.css.Rect;

public class MFP {

  public static void main(String[] args) {
    hello("World!");
    hello("Rt");
    hello("tg");

    Square s = new Square (10);
    System.out.println("Площадь квадрата со стороной " + s.len + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

  }

    public static void hello (String sb) {
      System.out.println("Hello " + sb);
    }


}