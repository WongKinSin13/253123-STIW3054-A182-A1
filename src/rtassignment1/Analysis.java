package rtassignment1;

import java.util.Scanner;

public class Analysis {

	private int actPoint;
	private int useCases;
	private int uUCP;
	private double tFactor;
	private double eFactor;
	private double tCF;
	private double eF;
	private double sZUC;
	private double uCP;
	private double totalManHour;
	private double totalManHourFinal;
	private double adjustedManHour;
	private int reportedManHour;

	Scanner scan = new Scanner(System.in);

	public Analysis(int actPoint, int useCases, int uUCP, double tFactor, double eFactor, double tCF, double eF,
			double sZUC, double uCP, double totalManHour, double totalManHourFinal, double adjustedManHour,
			int reportedManHour) {
		this.actPoint = actPoint;
		this.useCases = useCases;
		this.uUCP = uUCP;
		this.tFactor = tFactor;
		this.eFactor = eFactor;
		this.tCF = tCF;
		this.eF = eF;
		this.sZUC = sZUC;
		this.uCP = uCP;
		this.totalManHour = totalManHour;
		this.totalManHourFinal = totalManHourFinal;
		this.adjustedManHour = adjustedManHour;
		this.reportedManHour = reportedManHour;
	}

	public void calculateActorPts() {
		System.out.println("\n1.Calculate Total Actor Points");
		System.out.println("==============================");
		System.out.println("*Actor Type Explaination*");
		System.out.println("Simple : Defined API");
		System.out.printf("%s\n%34s\n", "Average: Interactive or", "Protocol driven interface");
		System.out.println("Complex: GUI\n");
		System.out.println("Please enter the quantity of each actor type:");
		System.out.print("Simple : ");
		int simp = scan.nextInt();
		System.out.print("Average: ");
		int avg = scan.nextInt();
		System.out.print("Complex: ");
		int comp = scan.nextInt();

		int actorPts = (simp * 1 + avg * 2 + comp * 3);
		this.actPoint = actorPts;
		System.out.println("Total Actor Point = " + actorPts);
	}

	public void calculateUseCases() {
		System.out.println("\n2.Calculate Total Use cases");
		System.out.println("===========================");
		System.out.println("Use case type explaination:");
		System.out.println("Simple : 3 or more transactions.");
		System.out.printf("%s\n", "Average: 4 to 7 transactions.");
		System.out.println("Complex: More than 7 transactions.");
		System.out.println("Complex: GUI\n");
		System.out.println("Please enter the quantity of each use case type:");
		System.out.print("Simple : ");
		int simp = scan.nextInt();
		System.out.print("Average: ");
		int avg = scan.nextInt();
		System.out.print("Complex: ");
		int comp = scan.nextInt();
		int usCases = (simp * 5 + avg * 10 + comp * 15);
		this.useCases = usCases;
		System.out.println("Total Use Cases = " + usCases);
	}

	public void calculateUUCP() {
		System.out.println("\nUnadjusted Use Case Points(UUCP) = Total Actor Points + Total Use Cases");
		int uucP = this.actPoint + this.useCases;
		this.uUCP = uucP;
		System.out.printf("Unadjusted Use Case Points(UUCP) = %d\n", uucP);
	}

	public void calculateTechFactors() {
		double weightFactor;
		int projectRating;
		double subTotalFinal = 0;
		System.out.println("\n3.Weighting Technical Factors");
		System.out.println("=============================");
		String[] listTFactor = new String[13];

		listTFactor[0] = "T1. Must have a distributed solution";
		listTFactor[1] = "T2. Must respond to specific performance objectives";
		listTFactor[2] = "T3. Must meet end-user efficiency desires";
		listTFactor[3] = "T4. Complex internal processing";
		listTFactor[4] = "T5. Code must be reusable";
		listTFactor[5] = "T6. Must be easy to install";
		listTFactor[6] = "T7. Must be easy to use";
		listTFactor[7] = "T8. Must be portable";
		listTFactor[8] = "T9. Must be easy to change";
		listTFactor[9] = "T10. Must allow concurrent users";
		listTFactor[10] = "T11. Includes special security features";
		listTFactor[11] = "T12. Must provide direct access for 3rd parties";
		listTFactor[12] = "T13. Requires special user training facilities";

		double[] subTotal = new double[13];
		for (int x = 0; x < 13; x++) {
			System.out.println(listTFactor[x]);
			System.out.print("Set Weight Factor: ");
			weightFactor = scan.nextDouble();
			System.out.print("Set Project Rating: ");
			projectRating = scan.nextInt();
			System.out.println("");
			subTotal[x] = weightFactor * projectRating;
			subTotalFinal = subTotalFinal + subTotal[x];
			this.tFactor = subTotalFinal;
		}
		System.out.println("Total TFactor = " + subTotalFinal);
		System.out.println("");
	}

	public void calculateTCF() {
		System.out.println("Technical Complexity Factor(TCF) = (0.01 * Tfactor) + 0.6");
		double tcf = (0.01 * this.tFactor) + 0.6;
		this.tCF = tcf;
		System.out.printf("Technical Complexity Factor(TCF) = %.2f\n\n", tcf);
	}

	public void calculateSoftwareSize() {
		System.out.println("Size of the software(use case)= UUCP * TCF ");
		double szUC = this.uUCP * this.tCF;
		this.sZUC = szUC;
		System.out.printf("Size of the software(use case)= %.1f\n", szUC);
	}

	public void calculateExpFactors() {
		double weightFactor;
		int projectRating;
		double subTotalFinal = 0;
		System.out.println("\n4.Weighting Experience Factors");
		System.out.println("==============================");
		String[] listEFactor = new String[13];
		listEFactor[0] = "E1. Familiar with FPT software process";
		listEFactor[1] = "E2. Application experience";
		listEFactor[2] = "E3. Paradigm experience(OO)";
		listEFactor[3] = "E4. Lead analyst capability";
		listEFactor[4] = "E5. Motivation";
		listEFactor[5] = "E6. Stable requirements";
		listEFactor[6] = "E7. Part-time workers";
		listEFactor[7] = "E8. Difficulty of programming language";

		double[] subTotal = new double[8];
		for (int x = 0; x < 8; x++) {
			System.out.println(listEFactor[x]);
			System.out.print("Set Weight Factor: ");
			weightFactor = scan.nextDouble();
			System.out.print("Set Project Rating: ");
			projectRating = scan.nextInt();
			System.out.println("");
			subTotal[x] = weightFactor * projectRating;
			subTotalFinal = subTotalFinal + subTotal[x];
			this.eFactor = subTotalFinal;
		}
		System.out.println("Total EFactor = " + subTotalFinal);
		System.out.println("");
	}

	public void calculateEF() {
		System.out.println("Experience Factor(EF) = (-0.03 * Efactor) + 1.4");
		double ecf = (-0.03 * this.eFactor) + 1.4;
		this.eF = ecf;
		System.out.printf("Experience Factor(EF) = %.2f\n\n", ecf);
	}

	public void calculateUCP() {
		System.out.println("Use Case Points(UCP) = SzUC * EF ");
		double ucP = this.sZUC * this.eF;
		this.uCP = ucP;
		System.out.printf("Use Case Points(UCP) = %.3f\n", ucP);
	}

	public void calculateManHours() {
		System.out.println("\n5.Calculating Man-Hours");
		System.out.println("=======================");
		System.out.println("Total Man-Hours = Effort Rate(ER) * UCP ");
		System.out.println("From Experience Factor Section, count the numbers " + "of factor rating");
		System.out.println("below 3 in E1-E6 and factor rating " + "that are above 3 in E7-E8 ");
		System.out.println("\nIf total is 2 or less, ER = 20");
		System.out.println("If total is 3 or 4, ER = 28");
		System.out.println("If total is 5 or more, significant failure risk present within the team.\n");
		System.out.print("Please enter the ER value to be used : ");
		int er = scan.nextInt();
		double totalManHr = er * this.uCP;
		this.totalManHour = totalManHr;
		System.out.println("Total Man-Hours = Effort Rate * UCP ");
		System.out.printf("Total Man-Hours = %.3f %s", totalManHr, "man-hours");
	}

	public void calculateAdjustedManHr() {
		System.out.println("\n\n6.Calculating Adjusted Man-Hours");
		System.out.println("================================");
		System.out.println("Adjusted Man-Hours = (1.0 + .xx[%]) * total man-hours");
		System.out.println("xx represent risk coefficients. ");
		System.out.print("Please enter the coefficient to be used : ");
		double coefficient = scan.nextDouble();
		double adjustedManHr = (1.0 + coefficient) * this.totalManHour;
		this.adjustedManHour = adjustedManHr;
		System.out.printf("\nAdjusted Man-Hours = %.2f %s", adjustedManHr, " man-hours");
	}

	public void calculateReportingManHr() {
		System.out.println("\n\n7.Calculating Reporting Man-Hours");
		System.out.println("=================================");
		System.out.println("Please enter the quantity and average ");
		System.out.println("man-hours of each report type:");

		System.out.print("Simple : \n");
		System.out.println("-------- ");
		System.out.print("Quantity          : ");
		int simpQty = scan.nextInt();
		System.out.print("Average Man-hours : ");
		int simpMH = scan.nextInt();

		System.out.println("\nAverage:");
		System.out.println("-------- ");
		System.out.print("Quantity          : ");
		int avgQty = scan.nextInt();
		System.out.print("Average Man-hours : ");
		int avgMH = scan.nextInt();

		System.out.println("\nComplex: ");
		System.out.println("-------- ");
		System.out.print("Quantity          : ");
		int compQty = scan.nextInt();
		System.out.print("Average Man-hours : ");
		int compMH = scan.nextInt();
		int subTotalHr = ((simpQty * simpMH) + (avgQty * avgMH) + (compQty * compMH));
		this.reportedManHour = subTotalHr;
		System.out.printf("\nTotal Reporting Man-hour estimate = %d %s", subTotalHr, " man-hours\n");
	}

	public void calculateTotalManHrFinal() {
		System.out.println("\n8.Calculating Total Man-Hours");
		System.out.println("=============================");
		System.out.println("Total Man-Hours = Adjusted man-hours + Reporting man-hours");
		double manHourFinal = this.adjustedManHour + this.reportedManHour;
		this.totalManHourFinal = manHourFinal;
		System.out.printf("Total Man-Hours = %.2f %s", manHourFinal, "man-hours\n");
	}
}
