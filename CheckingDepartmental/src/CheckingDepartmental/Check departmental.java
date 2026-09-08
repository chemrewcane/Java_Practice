package CheckingDepartmental;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class CheckingDepartmental {
	public static void main(String []args) throws IOException {
		Scanner sc = new Scanner(System.in);

		//Inputing how many fridges
		System.out.print("Input Fridges: ");
		int temp = sc.nextInt();

		//Arrays
		double[] temperature = new double[temp];

		//Inputing temperature
		System.out.println("\n==Input temperature of Fridges==");

		//Loopings
		for (int i = 0; i < temp; i++) {
			System.out.print("Fridge " + (i+1) + ": ");
			temperature[i] = sc.nextDouble();
			sc.nextLine();

			//Calling User-defined method
			String rawr = Temple(temperature, temp);
			save(temp, temperature, rawr);
		}

		sc.close();
		System.out.println("\nSave the input file in temperature.txt");	
	}

	//User-defined method
	public static String Temple(double[] temperature, int temp) {
		for (int i = 0; i < temp; i++) {
			if (temperature[i] > 10) {
				return("High");
			} else if (temperature[i] == 10) {
				return("Average");
			} else if (temperature[i] < 10) {
				return("Low");
			}
		}
		return null;
	}

	public static void save(int temp, double[] temperature, String rawr) throws IOException {
		FileWriter fw = new FileWriter("temperature.txt", false);

		for (int i = 0; i < temp; i++) {
			fw.write("Fridge " + (i+1) + ": " + temperature[i] + " - " + rawr + "\n");
		}
		fw.close();
	}
}
