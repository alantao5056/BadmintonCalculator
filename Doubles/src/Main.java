import java.util.Scanner;

public class Main {
  private static Scanner sc;

  public static void main(String[] args) {
    sc = new Scanner(System.in);
    Asker asker = new Asker(sc);
    Report report = asker.askRatings();

    // simple report
    System.out.println(report.seperator);
    System.out.println(report.ratingSummary());
    System.out.println();
    System.out.println(report.seperator);
    System.out.println(report.simpleSummary());
    System.out.println();
    System.out.println(report.seperator);

    // complex report
    System.out.println(report.weightedSummary());
    System.out.println();
    System.out.println(report.seperator);

    sc.close();
  }
}
