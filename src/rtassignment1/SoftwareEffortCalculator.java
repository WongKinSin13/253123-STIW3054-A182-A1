package rtassignment1;

import java.util.Scanner;

public class SoftwareEffortCalculator {

    static Scanner scan = new Scanner(System.in);
    static Analysis run01 = new Analysis(0,0,0,0,0,0,0,0,0,0,0,0,0);

    public static void main(String args[]) {
        System.out.println("Software Effort Calculator Version 1.0");
        System.out.println("======================================");
        System.out.println("-------------Main Menu----------------");
        System.out.println("Enter '1' to start calculation.");
        System.out.println("Enter '0' to exit program.");
        System.out.print("Your choice: ");

        try {
            int option1 = scan.nextInt();
            switch (option1) {
                case 1:
                    run01.calculateActorPts();     
                    run01.calculateUseCases();
                    run01.calculateUUCP();
                    run01.calculateTechFactors();
                    run01.calculateTCF();
                    run01.calculateSoftwareSize();
                    run01.calculateExpFactors();
                    run01.calculateEF();
                    run01.calculateUCP();
                    run01.calculateManHours();
                    run01.calculateAdjustedManHr();
                    run01.calculateReportingManHr();
                    run01.calculateTotalManHrFinal();
                    break;
                case 0:
                    System.out.println("\nShutting down "
                            + "program. Have a good day.");
                    break;
                default:
                    System.out.println("\nUnknown command, closing program. "
                            + "Have a good day.");
                    break;
            }
        } catch (Exception e) {
            System.out.print("Unknown command, closing program.\n");
        }
    }
}
