public class MFP {

  public static void main(String[] args) {
    hello("World!");
    hello("usr");
    hello("Alex");

    double l = 5;
    System.out.println("Площадь квадрата " + l + " = " + area(l));

    double a = 4;
    double b = 6;
    System.out.println("Площадь треугольника со сторонами " + a + " и " + b + " = " + area(a, b));

  }

  public static void hello(String SB) {
    System.out.println("Hello " + SB + " " + "!");
  }

  public static double area(double len) {
    return len * len;
  }

  public static double area(double b, double a) {
    return a * b;

  }
}