/*
 * Kuba Nowosielski	
 * 260854650
 * 
 */
public class Classifier {

	public static void main(String[] args) {
		typeOfBird(4,4,"Grey");
	}
	//Method which checks if the bird has type A qualities 
	public static boolean isTypeA(int Beak, int Claw, String Color) {
		//check for all conditions of type A
		if(Beak == 1 && Claw == 0 && Color.equalsIgnoreCase("grey"))
			return true;
		else if(Beak == 2 && Claw == 1 && Color.equalsIgnoreCase("grey"))
			return true;
		else if(Beak == 3 && Claw == 2 && Color.equalsIgnoreCase("grey"))
			return true;
		else if(Beak == 4 && Claw == 3 && Color.equalsIgnoreCase("grey"))
			return true;
		else if((Beak == 4 || Beak == 5) && Claw == 4 && Color.equalsIgnoreCase("grey"))
			return true;
		else 
			return false;
	}
	
	//Method which check for Type B qualities
	public static boolean isTypeB(int Beak, int Claw, String Color) {
		if((Beak == 4) && (Claw == 4 || Claw == 5) && (Color.equalsIgnoreCase("Grey")))
			return true;
		else if(Beak == 5 && (Claw == 6 || Claw == 7) && (Color.equalsIgnoreCase("grey") || Color.equalsIgnoreCase("blue")))
			return true;
		else if(Beak == 6 && (Claw == 8 || Claw == 9) && Color.equalsIgnoreCase("blue"))
			return true;
		else if(Beak == 7 && Claw == 10 && Color.equalsIgnoreCase("blue"))
			return true;
		else if(Beak == 8 && Claw == 11 && Color.equalsIgnoreCase("blue"))
			return true;
		else
			return false;
				
	}
	
	//method which checks for type C
	public static boolean isTypeC(int Beak, int Claw, String Color) {
		if(Beak == 5 && (Claw == 6 || Claw == 7) && (Color.equalsIgnoreCase("green") || Color.equalsIgnoreCase("blue")))
			return true;
		else if(Beak == 6 && (Claw == 8 || Claw == 9) && (Color.equalsIgnoreCase("green")))
			return true;
		else if (Beak == 7 && (Claw == 10) && (Color.equalsIgnoreCase("green")))
			return false;
		else if (Beak == 8 && (Claw == 11) && (Color.equalsIgnoreCase("green")))
			return true;
		else if (Beak == 9 && (Claw == 12) && (Color.equalsIgnoreCase("green")))
			return true;
		else
			return false;
	
	}
	//method that will take all the boolean outputs and display what the bird is
	public static void typeOfBird(int Beak, int Claw, String Color) {
		/*
		 * AB
		 * AC
		 * BC
		 * 
		 */
		if((isTypeA(Beak, Claw, Color) && (isTypeB(Beak, Claw, Color)))){
			System.out.println("The type of bird is A B");
		}
		else if((isTypeA(Beak, Claw, Color) && (isTypeC(Beak, Claw, Color)))){
			System.out.println("The type of bird is A C");
		}
		else if((isTypeB(Beak, Claw, Color) && (isTypeC(Beak, Claw, Color)))){
			System.out.println("The type of bird is B C");
		}
		else if(isTypeA(Beak, Claw, Color)) {
			System.out.println("The type of bird is A");
		}
		else if(isTypeB(Beak, Claw, Color)) {
			System.out.println("The type of bird is B");
		}
		else if(isTypeC(Beak, Claw, Color)) {
			System.out.println("The type of bird is C");
		}
		else {
			System.out.println("that the bird is not part of the study");
		}
	}
}
