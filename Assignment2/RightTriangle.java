/*
 * Name: Kuba Nowosielski
 * ID: 260854650 
 *  
 */
public class RightTriangle {

	public static void main(String[] args) {
		//get input from user
		int rows = Integer.parseInt(args[0]);
		//check if the input is greater than 0 if it is run the method
		if(rows<0) {
			System.out.println("Error: input value must be >= 0");
		}
		else
			rightTriangle(rows);
		
	}
	//a method that print the triangle thing from the right
	public static void rightTriangle(int rows) {
		//print a left triangle of spaces
		for(int i = 1; i<=rows; i++) {
			for(int j = rows -1; j>=i; j--) {
				System.out.print(' ');
			}
			//fill the rest with stars
			for(int k = 1; k<=i; k++) {
				System.out.print('*');
			}	
			System.out.println();
		}
		
	}

		
}

