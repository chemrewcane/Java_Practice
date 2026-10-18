package HotelRoom;

import java.util.Scanner;

public class HotelRoom {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);

		//Create a 2D array
		int hotel[][] = new int[7][5];
		int choice = 0;

		System.out.println("=== HOTEL RESERVATION SYSTEM ===");
		
		//While loop
		while (choice != 4) {
			System.out.println();
			System.out.println(
					"1. View Rooms"
							+ "\n2. Check In"
							+ "\n3. Check Out"
							+ "\n4. Exit" );
			System.out.print("Enter Choice: ");
			choice = sc.nextInt();

			//switch case for choices
			switch (choice) {
			case 1:
				for (int x = 6; x >= 0; x--) {
					System.out.print("Floor " + (x + 1) + ":");
					for (int y = 0; y < 5; y++) {
						System.out.print("[" + hotel[x][y] + "]");	
					}
					System.out.println();
				}
				break;

			case 2:
				System.out.print("\nEnter floor (1-7): ");
				int floorIn = sc.nextInt() - 1;
				System.out.print("Enter room (1-5): ");
				int roomIn = sc.nextInt() - 1;

				if (hotel[floorIn][roomIn] == 0) {
					hotel[floorIn][roomIn] = 1;
					System.out.println("Check-in successful!");
				} else {
					System.out.println("Room already occupied!");
				}
				break;

			case 3:
				System.out.print("\nEnter floor (1-7): ");
				int floorOut = sc.nextInt() - 1;
				System.out.print("Enter room (1-5): ");
				int roomOut = sc.nextInt() - 1;

				if (hotel[floorOut][roomOut] == 1) {
					hotel[floorOut][roomOut] = 0;
					System.out.println("Check-out successful!");
				} else {
					System.out.println("Room already empty!");
				}
				break;

			case 4:
				break;
			default:
				System.out.println("Invalid. Please try again.");
			}
			
			//Additional for my code (for inputing '4' hehe).
			while (choice == 4) {
				System.out.println("Thank you! Please come again!");
				break;
			}
		}
	}
}
