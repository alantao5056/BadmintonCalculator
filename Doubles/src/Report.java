public class Report {
  // simple
  public double a1;
  public double a2;
  public double b1;
  public double b2;
  public double saA; // simple average
  public double saB;
  public double wpA; // winning percentage
  public double wpB;
  // weighted
  public double htbdA; // hit to bad difference
  public double htbdB;
  public double weightPA; // weighted percentage
  public double weightPB;
  public double weightAA; // weighted average
  public double weightAB;
  public double weightwpA;
  public double weightwpB;


  public final String seperator = "############################################\n";

  private double round(double x) {
    return Math.round(x * 100.0) / 100.0;
  }

  private double roundPercent(double x) {
    return Math.round(x * 10000.0) / 10000.0;
  }

  public Report(double a1, double a2, double b1, double b2) {
    this.a1 = round(a1);
    this.a2 = round(a2);
    this.b1 = round(b1);
    this.b2 = round(b2);
  }

  public String ratingSummary() {
    return
        String.format("Team A player 1: %,.2f\nTeam A player 2: %,.2f\nTeam B player 1: %,.2f\nTeam B player 2: %,.2f", a1, a2, b1, b2);
  }

  private void calcSimpleAverage() {
    saA = round((a1+a2)/2);
    saB = round((b1+b2)/2);
  }

  private void calcWinningPercentage() {
    wpA = saA / (saA + saB);
    wpB = saB / (saA + saB);
  }

  public String simpleSummary() {
    calcSimpleAverage();
    calcWinningPercentage();
    return
        "Simple Average Team A: " + saA +
            "\nSimple Average Team B: " + saB +
            "\n\nSimple Winning Percentage Team A: " + round(wpA * 100) + "%\nSimple Winning Percentage Team B: " + round(wpB * 100) + "%";
  }

  private void calcWeighted() {
    htbdA = Math.max(0, saA-Math.min(b1, b2));
    htbdB = Math.max(0, saB-Math.min(a1, a2));
    weightPA = roundPercent(htbdA * 0.05);
    weightPB = roundPercent(htbdB * 0.05);
    weightAA = round(saA * (1 + weightPA));
    weightAB = round(saB * (1 + weightPB));
    weightwpA = roundPercent(weightAA / (weightAA + weightAB));
    weightwpB = roundPercent(weightAB / (weightAA + weightAB));
  }

  public String weightedSummary() {
    calcWeighted();
    return
        "Team A 'Hit to bad' advantage: " + (weightPA*100) +
        "%\nTeam B 'Hit to bad' advantage: " + (weightPB*100) +
        "%\n\nTeam A weighted average: " + weightAA +
        "\nTeam B weighted average: " + weightAB +
        "\n\nTeam A weighted winning percentage: " + (weightwpA*100) +
        "%\nTeam B weighted winning percentage: " + (weightwpB*100)+
        "%";
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
