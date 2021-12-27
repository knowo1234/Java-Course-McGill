//Fill in your name and student number
//Name: Kuba Nowosielski
//Student Number: 260854650

// do NOT touch the following import statement
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {
    
    private static final String[] words = {"perfect", "country", "pumpkin", "special", "freedom", "picture", "husband", 
        "monster", "seventy", "nothing", "sixteen", "morning", "journey", "history", "amazing", "dolphin", "teacher", 
        "forever", "kitchen", "holiday", "welcome", "diamond", "courage", "silence", "someone", "science", "revenge", 
        "harmony", "problem","awesome", "penguin", "youtube", "blanket", "musical", "thirteen", "princess", "assonant", 
        "thousand", "language", "chipotle", "business", "favorite", "elephant", "children", "birthday", "mountain", 
        "football", "kindness", "abdicate", "treasure", "strength", "together", "memories", "darkness", "sandwich", 
        "calendar", "marriage", "building", "function", "squirrel", "tomorrow", "champion", "sentence", "daughter", 
        "hospital", "identical", "chocolate", "beautiful", "happiness", "challenge", "celebrate", "adventure", 
        "important", "consonant", "dangerous", "irregular", "something", "knowledge", "pollution", "wrestling", 
        "pineapple", "adjective", "secretary", "ambulance", "alligator", "congruent", "community", "different", 
        "vegetable", "influence", "structure", "invisible", "wonderful", "nutrition", "crocodile", "education", 
        "beginning", "everything", "basketball", "weathering", "characters", "literature", "perfection", "volleyball", 
        "homecoming", "technology", "maleficent", "watermelon", "appreciate", "relaxation", "abominable", "government", 
        "strawberry", "retirement", "television", "silhouette", "friendship", "loneliness", "punishment", "university", 
        "confidence", "restaurant", "abstinence", "blackboard", "discipline", "helicopter", "generation", "skateboard", 
        "understand", "leadership", "revolution"};  
    
    // this method takes an integer as input and returns a radom String from the array above. 
    // you can use it, but do NOT modified neither the method NOR the above array. 
    public static String getRandomWord(int seed) {
        Random gen = new Random(seed);
        int randomIndex = gen.nextInt(words.length);
        return words[randomIndex];
    }
    
    //========================
    // Enter your code below
    
    public static void main(String[] args) {
        play(34);

    }
    //a method that checks if the char guessed is valid meaning its a lowercase letter of alphabet
    public static boolean isValidGuess(char c) {
    	//check if its lowercase letter of alphabet
    	//return true if yes else false
    	if(c >= 'a' && c <= 'z')
    		return true;
    	else
    		return false;
    }
    //make a method that generates an array that is the length of the word in question
    public static int[] generateArrayOfGuesses(String s) {
    	//make array o f length s.length
    	int [] lettersInString = new int[s.length()];
    	return lettersInString;
    	
    }
    //make a method that checks if the guess provided is in the secretword
    public static boolean checkAndUpdate(String secretWord, int[] guesses, char lastGuess) {
    	//make a variable that will contain the true/false results if a letter was guessed
    	boolean containsChar = false;
    	//loop through the secretword and compare each character to see if its the same as the guess
    	for(int i = 0; i<secretWord.length();i++) {
    		if(secretWord.charAt(i) == lastGuess) {
    			guesses[i] = 1;
    			containsChar = true;
    		}
    		
    	}
    	return containsChar;
    }
    
    //make a method that displays the characters someone has already guessed
    public static String getWordToDisplay(String secretWord, int[] guesses, char lastGuess) {
    	String guessedChars = "";
    	//make a String array that will contain the dashes and letters so that the string can be easily modifiable
    	char [] lettersGuessed = new char[guesses.length];
    	//iterate through the guesses array and see at which points have the letters been guessed
    	for(int i = 0; i < secretWord.length();i++) {
    	 	//check if the indices of value 1 in array guesses are the same as the lastGuess provided by the user
    		if(guesses[i] == 1 && secretWord.charAt(i) == lastGuess) {
    			lettersGuessed[i] = (char) (lastGuess-32);
    		}
    		else if(guesses[i] == 1 && secretWord.charAt(i) != lastGuess){
    			lettersGuessed[i] = secretWord.charAt(i);
    		}
    		//if the value of array guesses at index i is 0 
    		//check if the lastGuess provided by the user equals the character at index i in secretWord
    		else if(guesses[i] == 0 && secretWord.charAt(i) == lastGuess){
    			lettersGuessed[i] = (char) (lastGuess-32);
    		}
    		else if(guesses[i] == 0 && secretWord.charAt(i) != lastGuess){
    			lettersGuessed[i] = '-';
    		}
    	}
    	//Iterate through the array of characters and take each element and build the final string with them
    	for(int i = 0;i<secretWord.length();i++) {
    		guessedChars = guessedChars + lettersGuessed[i];
    	}
    	
    	return guessedChars;
    }
    
    public static boolean isWordGuessed(int [] guesses) {
    	boolean complete = true;
    	for(int i = 0; i<guesses.length; i++) {
    		if(guesses[i] == 0) {
    			complete = false;
    		}
    	}
    	return complete;
    }
    
    public static void play(int x) {
    	//generate and store the secret word
    	String secretWord = getRandomWord(x);
    	int lives = 10;
    	int [] guesses = generateArrayOfGuesses(secretWord);
    	//create scanner
    	Scanner read = new Scanner(System.in);
    	//write the beginning statements
    	System.out.println("Welcome to \"Guess the Word!\" ");
    	System.out.print("Your secret word has been generated. It has " + secretWord.length() + " characters. ");
    	System.out.println("You have " + lives + " lives. Good luck!");
    	System.out.println();
    	
    	while(lives>0 && isWordGuessed(guesses) == false) {
    		//boolean variable that will keep track if all the input conditions are met
    		boolean isValid = false;
    		//start of game
    		System.out.print("you have " + lives + " lives left. Please enter a character: ");
    		String c = read.nextLine();
    		
    		//create a char variable that will later store the char guessed
    		char guess = ' ';
    		
    		//check if the string is more than one character
    		//if its one character convert it into a char and check if 
    		//the char is a lower case letter of the english alphabet
    		if(c.length() == 1) {
    			//assign guess the letter the user guessed
    			guess = c.charAt(0);
    			if(isValidGuess(guess) == false) {
    				System.out.println("The character must be a lowercase letter of the English alphabet. Try again!");
    				System.out.println();

    			}
    			else
    				isValid = true;
    		}
    		else {
    			System.out.println("You can only enter one single character. Try again!");
				System.out.println();

    		}
    		//if the input conditions are all met then the user input can start affecting the score
    		if(isValid == true) {
    			if(checkAndUpdate(secretWord, guesses, guess)) {
    				System.out.println("Good job! The secret word contains the character '" + guess + "'");
    				System.out.println(getWordToDisplay(secretWord, guesses, guess));
    				System.out.println();
    			}
    			else {
    				System.out.println("There's no such character. Try again!");
    				System.out.println(getWordToDisplay(secretWord, guesses, guess));
    				System.out.println();
    				lives--;
    			}
    		}
    		
    		
    	}
    	//once out of the loop check if the player guessed it or did they die
    	if(isWordGuessed(guesses) == true) {
    		System.out.println("congratulations you guessed the secret word!");
    	}
    	else {
    		System.out.print("You have no lives left, better luck next time!");
    		System.out.println(" The secret word was: \"" + secretWord + "\"");
    	}
    }
}
























