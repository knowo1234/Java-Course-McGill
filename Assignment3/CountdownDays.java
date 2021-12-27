//Fill in your name and student number
//Name: Kuba Nowosielski
//Student Number: 260854650

// do NOT touch these import statements 
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

public class CountdownDays {
    
    // the method returns a String representing the current date in the following format: dd/mm/yyyy
    // you can use it, but do NOT modify it!
    public static String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        return dtf.format(now);
    }
    
    //========================
    // Enter your code below
    
    public static void main(String[] args) {
        
        
    }
    //write method that returns substring of String s between and including ints i and j
    //integer inputs must be in increasing order
    //ex. (4,5) is allowed		(5,4) is NOT allowed
    public static String getSubstring(String s, int i, int j) {
    	//check for legal integer input
    	if(i>j) {
    		throw new IllegalArgumentException("integer inputs must be in increasing order");
    	}
    	//make the String that will be returned
    	String subString = "";
    	//want to iterate through the string from position i to position j and 
    	//add those letters to subString
    	for(int k = i; k<=j; k++) {
    		subString += s.charAt(k);
    	}
    	return subString;
    }
    
    	//method that takes a string of the date and returns the day as an integer
    public static int getDay(String s) {
    	//store the day String in a variable to later get the int from
    	String day = getSubstring(s, 0, 1);
    	//check if the day is a number<10 or number>=10
    	if(day.charAt(0) == '0') {
    		day = getSubstring(day,1,1);
    		return Integer.parseInt(day);
    	}
    	else {
    		return Integer.parseInt(day);
    	}
    }
    
  //method that takes a string of the date and returns the month as an integer
    public static int getMonth(String s) {
    	//store the month String in a variable to later get the int from
    	String month = getSubstring(s, 3,4);
    	//check if the month is a number <10 or number>=10
    	if(month.charAt(0) == '0') {
    		month = getSubstring(month,1,1);
    		return Integer.parseInt(month);
    	}
    	else {
    		return Integer.parseInt(month);
    	}
    }
  //method that takes a string of the date and returns the year as an integer
    public static int getYear(String s) {
    	//store the year String in a variable to later get the int from
    	String year = getSubstring(s, 6,9);
    	//check if the year is in the thousands
    	if(year.charAt(0) != '0') {
    		int yearInt = Integer.parseInt(year);
    		return yearInt;
    	}
    	//check if the year is in the hundreds
    	else if(year.charAt(1) != '0') {
    		year = getSubstring(year,1,3);
    		int yearInt = Integer.parseInt(year);
    		return yearInt;
    	}
    	//check if the year is in the tens
    	else if(year.charAt(2) != '0') {
    		year = getSubstring(year,2,3);
    		int yearInt = Integer.parseInt(year);
    		return yearInt;
    	}
    	//check if year is in the ones
    	else if(year.charAt(3) != '0') {
    		year = getSubstring(year,3,3);
    		int yearInt = Integer.parseInt(year);
    		return yearInt;
    	}
    	//finally if the year happens to be year 0
    	else {
    		int yearInt = Integer.parseInt(year);
    		return yearInt;
    	}
    	
    	
    }
    
    //write a method that tells if a year is a leap year
    //leap year is divisble by four unless its a century year than / 400
    public static boolean isLeapYear(int year) {
    	//check if year is not 0
    	if(year == 0)
    		return false;
    	//check if the year is a century
    	if(year % 100 == 0) {
    		//check if the centruy is divisible by 400
    		if(year % 400 == 0) {
    			return true;
    		}
    		else 
    			return false;
    	}
    	//if its not a century check if is leap year
    	if(year%4==0) {
    		return true;
    	}
    	else
    		return false;
    }
    
    //method that returns the amount of days in a month
    public static int getDaysInAMonth(int month, int year) {
    	//store the days of each month in variable, use array
    	int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    	//if it happens to be a leap year and February
    	if(isLeapYear(year) && month == 2) {
    		return 29;
    	}
    	else
    		return monthDays[month -1];
    }
    
    //method that checks if due date has passed
    public static boolean dueDateHasPassed(String nowDate, String dueDate) {
    	//check years if nowDate is greater or less than, if so the answer is easy
    	if(getYear(nowDate) > getYear(dueDate))
    		return true;
    	else if(getYear(nowDate) < getYear(dueDate))
    		return false;
    	//if years are the same check the months in same fashion
    	else if(getYear(nowDate) == getYear(dueDate)) {
    		if(getMonth(nowDate) > getMonth(dueDate))
        		return true;
        	else if(getMonth(nowDate) < getMonth(dueDate))
        		return false;
    		//if months are the same check the days
        	else if(getMonth(nowDate) == getMonth(dueDate)) {
        		if(getDay(nowDate) > getDay(dueDate))
            		return true;
            	else if(getDay(nowDate) < getDay(dueDate))
            		return false;
            	else if(getDay(nowDate) == getDay(dueDate)) {
            		return true;
            	}
        	}
    	}
    	//return statement that doesn't do anything is just here so that the method runs
    	return false;
    }
    
    //write a method that takes two strings that represnt dates as input and returns an int that tells the user how
    //many days are left until the assignment is due
    public static int countDaysLeft(String a, String b) {
    	
    	//establish values for each part of date
    	int yearA = getYear(a);
    	int monthA = getMonth(a);
    	int dayA = getDay(a);
    	
    	//establish amount of days in yearA
    	int daysYearA = 0;
    	if(isLeapYear(yearA)) {
    		daysYearA = 366;
    	}
    	else {
    		daysYearA = 365;
    	}
    	
    	
    	//establish values for each part of date
    	int yearB = getYear(b);
    	int monthB = getMonth(b);
    	int dayB = getDay(b);
    	
    	//establish amount of days in yearB
    	int daysYearB = 0;
    	if(isLeapYear(yearB)) {
    		daysYearB = 366;
    	}
    	else {
    		daysYearB = 365;
    	}
    	
    	//variable that will be returned
    	int daysLeft = 0;
    	
    	//check if the due date has passed
    	if(dueDateHasPassed(a, b)) {
    		return daysLeft;
    	}
    	
    	//if it hasn't passed start checking how many days are left
    	else {
    		
        	//check if the years are the same
        	if(yearA == yearB) {
        		//if they are check if months are the same
        		if(monthA == monthB) {
        			//if the months are the same then the days left is the difference between the days
        			daysLeft = dayB - dayA;
        			return daysLeft;
        		}
        		
        		//if the months are not the same the days left are the amount of days left in monthA
        		//added to the amount of days passed in monthB plus any amount of months in between 
        		//MonthA and MonthB.
        		else{
        			int monthAleft = (getDaysInAMonth(monthA, yearA) - dayA);
        			//dayB = the amount of days that happened in monthB
        			
        			daysLeft = dayB + monthAleft; //variable that keeps track of days
        			//already initialized with the days left in monthA and days Happened in monthB
        			
        			//loop through the months between monthA and monthB and add their days to the daysBetweenMonthAMonthB variable
        			for(int i = monthA+1; i<monthB; i++) {
        				//get the days that are in month i and add it the the sum
        				daysLeft += getDaysInAMonth(i, yearA);
        			}
        			return daysLeft;
        		}
        	}
        	
        	//if the years are not the same
        	else {
        		
        		//make a variable that will keep track of the days that happened in yearA and yearB
        		int daysHappenedYearA = 0;
        		int daysHappenedYearB = 0;
        		
        		//make a loop that will go through all the months from the beginning of yearA until the month before the current month
        		//in the loop add the days of the months looped through to the amount of days that happened in the current month
        		//after subtract this number from (amount of days in yearA) to get the amount of days left in yearA
        		//but if monthA = 1 subtract the day in monthA from (amount of days in yearA)
        		//else enter the loop
        		if(monthA == 1) {
        			daysLeft += getDaysInAMonth(monthA, yearA);
        		}
        		else {
        			for(int i = 1; i<monthA;i++) {
        				daysHappenedYearA += getDaysInAMonth(i, yearA);
        			}
        			//the daysLeft in yearA is (daysYearA - (all the days in the months before the current month + the days in the current month))
        			daysLeft = daysYearA - (daysHappenedYearA + dayA);
        		}
        		
        		//make a loop that will go though all the months from the beginning of yearB until the month before the current month 
        		//in the loop add the days of the months looped though to the amount of days that happened in the current month
        		//that will be the total amount of days that happened in yearB
        		//but if monthB = 1 then the amount of days that happened in yearB is the dayB variable
        		//else enter the loop
        		if(monthB == 1) {
        			daysLeft += dayB;
        		}
        		else {
        			for(int i =1;i<monthB;i++) {
        				daysHappenedYearB += getDaysInAMonth(i, yearB);
        			}
        			
        			//the days that happened in yearB are all the days of the months before the current month + the days of the current month
        			daysHappenedYearB += dayB;
        			daysLeft += daysHappenedYearB;
        		}
        		
        		//check if there are years between yearA and yearB
        		//if there are loop through them and add their days to the total amount of days left
        		//if there aren't any years between yearA and yearB return the daysLeft
        		if(yearB - yearA == 1) {
        			return daysLeft;
        		}
        		
        		else {
        			for(int i = (yearA + 1); i<yearB;i++) {
        				//if the year between is a leap year add 366 to daysLeft
        				if(isLeapYear(i)) {
        					daysLeft += 366;
        				}
        				else {
        					daysLeft += 365;
        				}
        			}
        		}
        		return daysLeft;
        	}
    	}
     }
    
    //write a method that takes the due date as input(String) and displays the current date, due date and the amount of days left or not
    public static void displayCountdown(String dueDate) {
    	String today = getCurrentDate();
    	System.out.println("Today is: " + today);
    	System.out.println("Due date: " + dueDate);
    	if(dueDateHasPassed(today, dueDate)) {
    		System.out.println("The due date has passed :( Better luck next time!");
    	}
    	else {
    		System.out.println("You have " + countDaysLeft(today, dueDate) + " days left. Get to work, you will succeed!");
    	}
    }
} 

    

