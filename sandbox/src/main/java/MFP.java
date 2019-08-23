import org.w3c.dom.css.Rect;

public class MFP {

  public static void main(String[] args) {
    hello("World!");
    hello("usr");
    hello("Alex");

    Square s = new Square(5);
    System.out.println("Площадь квадрата " + s.l + " = " + area(s));

    Rectangle r = new Rectangle();
    r.a = 4;
    r.b = 6;
    System.out.println("Площадь треугольника со сторонами " + r.a + " и " + r.b + " = " + area(r));

  }

  public static void hello(String SB) {
    System.out.println("Hello " + SB + " " + "!");
  }

  public static double area(Square s) {
    return s.l * s.l;
  }

  public static double area(Rectangle r) {
    return r.a * r.b;

  }
}