/*
 * name:   Kuba Nowosielski	
 * ID:     260854650
 * 
 */
public class LeftTriangle {

	public static void main(String[] args) {
		
		//number of rows
		int row = Integer.parseInt(args[0]);
		//check if input from user is grater than 0 if not display error, if it is run the method
		if(row<0)
			System.out.println("Error: input value must be >= 0");
		else
			leftTriangle(row);
		
	}
	
	//method that prints out the triangle with row rows
	public static void leftTriangle(int row) {
		//create nested loops which will print out the * in their respective locations i=rows, j=columns
		for(int i = 1; i<=row; i++) {
			for(int j = 1; j<=i; j++) {
				System.out.print('*');
		}
			System.out.println();
		}
		
	}

}
