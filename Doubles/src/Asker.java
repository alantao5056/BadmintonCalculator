import java.util.Scanner;

public class Asker {
  private static Scanner sc;

  public Asker(Scanner sc) {
    this.sc = sc;
  }

  public static double askIntegerWithRange(String message, int lower, int upper) {
    double result = -1000000000;
    do {
      System.out.print(message);
      while (!sc.hasNextFloat()) {
        System.out.println("Please enter a valid number.\n");
        System.out.print(message);
        sc.next();
      }
      result = sc.nextFloat();
      if (result < lower || result > upper) {
        System.out.println("Please enter a number in the provided range.\n");
        result = -1000000000;
      }
    } while (result <= 0);

    System.out.println();
    return result;
  }

  public static Report askRatings() {
    double a1 = askIntegerWithRange("Team A player 1 rating (1-10): ", 1, 10);
    double a2 = askIntegerWithRange("Team A player 2 rating (1-10): ", 1, 10);
    double b1 = askIntegerWithRange("Team B player 1 rating (1-10): ", 1, 10);
    double b2 = askIntegerWithRange("Team B player 2 rating (1-10): ", 1, 10);

    Report report = new Report(a1, a2, b1, b2);
    return report;
  }
}
