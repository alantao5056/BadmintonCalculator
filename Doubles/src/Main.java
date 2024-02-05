import java.util.Scanner;

public class Main {
  private static Scanner sc;

  public static void main(String[] args) {
    sc = new Scanner(System.in);
    Asker asker = new Asker(sc);
    Report report = asker.askRatings();


    System.out.println(report.ratingSummary());
    System.out.println(report.simpleAverageSummary());

    sc.close();
  }
}
