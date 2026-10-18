package Singcoll;

public class Singcoll {
	public static void main(String []args) {

		int numbers [][] =
			{{120,250,789,7},{58,79,31,87},{8,1,2,3},{99,98,97,96}};

		System.out.println("Print the array in table form: ");
		for (int x = 0; x<numbers.length;x++) {
			for (int y = 0; y<numbers[x].length;y++) {	
				System.out.print(numbers[x][y] + " ");
			}
			System.out.println();
		}

		System.out.println("\nFind the index of number 1: ");
		for (int x = 0; x<numbers.length;x++) {
			for (int y = 0; y<numbers[x].length;y++) {	
				if (numbers[x][y] == 1) {
					System.out.print("Number 1 is found at indices " + x + " and " + y + "\n");
					numbers[x][y] = 50;
				}
			}
		}

		System.out.println("\nUpdate number 1 -> 50: ");
		for (int x = 0; x<numbers.length;x++) {
			for (int y = 0; y<numbers[x].length;y++) {	
				System.out.print(numbers[x][y] + " ");
			}
			System.out.println(" ");
		}		

		System.out.println("\nUpdate 2D Array where row 2 is all zero: ");
		for (int x = 0; x<numbers.length;x++) {
			for(int y = 0; y<numbers[x].length; y++) {
				numbers[1][y] = 0;
				System.out.print(numbers[x][y] + " ");
			}
			System.out.println("");
		}
	}		
}
