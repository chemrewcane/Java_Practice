package StudentGrade;

import java.util.Scanner;

public class StudentGrade {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("--- Input Grades ---");

		int s = 3;
		double[][] report = new double [4][4];

		for (int i = 0; i < s; i++) {
			System.out.println("Enter grades for Student " + (i+1) + ":");

			System.out.print("Math: ");
			double math = sc.nextDouble();
			report[i][0] = math;

			System.out.print("Science: ");
			double science = sc.nextDouble();
			report[i][1] = science;

			System.out.print("English: ");
			double english = sc.nextDouble();
			report[i][2] = english;

			System.out.println();
		}

		System.out.println("--- Grade Report ---");
		System.out.printf("%-10s %-10s %-10s %-10s%n", "Student", "Math", "Science", "English");

		for (int i = 0; i < s; i++) {
			System.out.printf("%-10s %-10.2f %-10.2f %-10.2f%n", "Student "+ (i+1), report[i][0], report[i][1], report[i][2]);
		}

		System.out.println("---------------------------------------------\n");

		System.out.println("--- Average per Student (Row) ---");
		for (int i = 0; i < s; i++) {
			double sum = report[i][0] + report[i][1] + report[i][2];
			double result = sum/3;
			System.out.printf("%s %s %.2f%n", "Student " + (i+1), " Average: ", result);
		}

		System.out.println("\n--- Average per Subject (Column) ---");
	
			double mathave = report[0][0] + report[1][0] + report[2][0];
			double resultm = mathave/3;
			System.out.printf("%s %s %.2f%n", "Math", "Average: ", resultm);
			
			double sciave = report[0][1] + report[1][1] + report[2][1];
			double results = sciave/3;
			System.out.printf("%s %s %.2f%n", "Science", "Average: ", results);
			
			double engave = report[0][2] + report[1][2] + report[2][2];
			double resulte = engave/3;
			System.out.printf("%s %s %.2f%n", "English", "Average: ", resulte);
		
			sc.close();
	}
}
