//Fill in your name and student number
//Name: Kuba Nowosielski
//Student Number: 260854650

public class CoinMachine {
    
    public static void main(String args[]) {
        if(args.length < 2) {
            System.out.println("You need to enter two arguments to this program. Try typing 'run CoinMachine 400 215' in Dr. Java, or 'java VendingMachine 400 215' on the command line.");
            return;
        } 
        int cash = getInputInteger(args[0]);
        int price = getInputInteger(args[1]);
        
        //========================
        //Enter your code below
        
        //declare money coins
        int twoonies;
        int loonies;
        int quarters;
        int dimes;
        int nickels;
        
        //declare change
        int change = (cash - price);
        
        //cash received, cost, change
        System.out.println("Amount received: " + cash);
        System.out.println("Cost of the item: " + price);
        System.out.println("Required change: " + change);
        System.out.println("\nchange:");
        
        //changing change variable to contain multiples of 5
        change = change/5;
        //test variable
        //System.out.println(change);
       
        //number of each coin and test of change variable progression
        twoonies = change / 40;
        System.out.println("\t toonies x " + twoonies);
        change = change % 40;
        //System.out.println(change);
       
        loonies = change / 20;
        System.out.println("\t loonies x " + loonies);
        change = change % 20;
       // System.out.println(change);
       
        quarters = change / 5;
        System.out.println("\t quarters x " + quarters);
        change = change % 5;
       // System.out.println(change);
       
        dimes = change / 2;
        System.out.println("\t dimes x " + dimes);
        change = change % 2;
       // System.out.println(change);
       
        nickels = change / 1;
        System.out.println("\t nickels x " + nickels);
        change = change % 1;
       // System.out.println(change);
        
        
        //Enter your code above
        //========================
    }
    
    public static int getInputInteger(String arg) {
        try
        {
            return Integer.parseInt(arg);
        } catch(NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage() + " This argument must be an integer!");
        }
        
        //error, return 0
        return 0;
    }
}