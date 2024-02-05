public class Report {
  public double a1;
  public double a2;
  public double b1;
  public double b2;
  public double saA;
  public double saB;

  public Report(double a1, double a2, double b1, double b2) {
    this.a1 = a1;
    this.a2 = a2;
    this.b1 = b1;
    this.b2 = b2;
  }

  public String ratingSummary() {
    return
        String.format("Team A player 1: %,.1f\nTeam A player 2: %,.1f\nTeam B player 1: %,.1f\nTeam B player 2: %,.1f", a1, a2, b1, b2);
  }

  private void calcSimpleAverage() {
    saA = (a1+a2)/2;
    saB = (b1+b2)/2;
  }

  public String simpleAverageSummary() {
    calcSimpleAverage();
    return
        "Simple Average Team A: " + saA +
        "\nSimple Average Team B: " + saB;
  }

  @Override
  public String toString() {
    return
        "Report{" +
        "a1=" + a1 +
        ", a2=" + a2 +
        ", b1=" + b1 +
        ", b2=" + b2 +
        '}';
  }
}
