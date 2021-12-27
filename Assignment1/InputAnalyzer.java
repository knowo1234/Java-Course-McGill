//Fill in your name and student number
//Name: Kuba Nowosielski
//Student Number: 260854650

public class InputAnalyzer {
    public static void main(String args[]) {
        if(args.length < 3) {
            System.out.println("You need to enter three arguments to this program. Try typing 'run InputAnalyzer 2.5 8 9' in Dr. Java, or 'java InputAnalyzer 2.5 8 9' on the command line.");
            return;
        } 
        double a = getInputDouble(args[0]);
        double b = getInputDouble(args[1]);
        double c = getInputDouble(args[2]);
        
        //========================
        //Enter your code below
        
        //declare variables
        boolean notNegative;
        boolean oneIsOdd;
        boolean decreasingOrder;
        boolean notNegDec;
        boolean notNegNonOdd;
        
        //check for non-negatives
        if(a >=0 && b >= 0 && c >= 0) {
        	notNegative = true;
        	System.out.println("The numbers " + a + ", " + b + ", and " + c + " are all non-negative: " + notNegative);
        }
        else {
        	notNegative = false;
        	System.out.println("The numbers " + a + ", " + b + ", and " + c + " are all non-negative: " + notNegative);
          }
        
        //check for even numbers
        if(((a%2)!=0) || ((b%2)!=0) || ((c%2)!=0)) {
        	oneIsOdd = true;
        	System.out.println("At least one between " + a + ", " + b + ", and " + c + " is odd: " + oneIsOdd);
        			}
        else {
        	oneIsOdd = false;
        	System.out.println("At least one between " + a + ", " + b + ", and " + c + " is odd: " + oneIsOdd);
        }
        
        //check for decreasing order
        if(a > b && b> c) {
        	decreasingOrder = true;
        	System.out.println("The numbers " + a + ", " + b + ", and " + c + " are strictly in decreasing order: " + oneIsOdd);
        }
        else {
        	decreasingOrder = false;
        	System.out.println("The numbers " + a + ", " + b + ", and " + c + " are strictly in decreasing order: " + oneIsOdd);
        }
        
        //checking if not negative or decreasing order
        if(notNegative == true || decreasingOrder == true) {
        	notNegDec = true;
        	System.out.println("The numbers " + a + ", " + b + ", and " + c + " are either all non-negative or in strictly a in decreasing order: " + notNegDec);
        }
        else {
        	notNegDec = false;
        	System.out.println("The numbers " + a + ", " + b + ", and " + c + " are either all non-negative or in strictly a in decreasing order: " + notNegDec);
        }
        
        //checking if not negative and not odd
        if(notNegative == true && oneIsOdd == false) {
        	notNegNonOdd = true;
        	System.out.println("The numbers " + a + ", " + b + ", and " + c + " are either all non-negative numebrs and none of them is odd: " + notNegNonOdd);
        }
        else {
        	notNegNonOdd = false;
        	System.out.println("The numbers " + a + ", " + b + ", and " + c + " are either all non-negative numebrs and none of them is odd: " + notNegNonOdd);
        }
        
        
        
        //Enter your code above
        //========================
    }
    
    public static double getInputDouble(String arg)
    {
        try
        {
            return Double.parseDouble(arg);
        } catch(NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage() + " This argument must be a number!");
        }
        
        //error, return 0
        return 0;
    }
}