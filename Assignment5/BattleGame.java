//name: Kuba Nowosielski
//ID: 260854650
import java.util.Random;
import java.util.Scanner;

public class BattleGame {	
	//attribute
	private static Random r = new Random();
	
	//method to play th game
	public static void playGame(String playerFile, String monsterFile, String spellFile) {
		//initializes characters in game
		Character player = FileIO.readCharacter(playerFile);
		Character monster = FileIO.readCharacter(monsterFile);
			
		//check if characters exist, if there is no name there must be no character
		try {
			if(player.getName().equals(null) || monster.getName().equals(null)) {
				System.out.println("The game cannot be played");
				return;
			}
		}
		catch(NullPointerException e) {
			System.out.println("The game cannot be played\n\nOne of the characters is invalid");
			return;
		}
		
		//check if spells were provided
		boolean noSpells = FileIO.readSpells(spellFile).isEmpty();
		if(noSpells) {
			System.out.println("The game will be played without spells.\n");
		}
		else  {
			Character.setSpells(FileIO.readSpells(spellFile));
		}
			
		//display character names
		displayCharacters(player, monster);
		
		//display available spells
		if(!noSpells) {
			System.out.print("------here are the available spells------");
			Character.displaySpells();
		}
		
		//create scanner
		Scanner sc = new Scanner(System.in);
		
		//as long as both characters have over 0 health the game continues
		while(player.getCurrHealth() > 0 && monster.getCurrHealth() > 0) {
			
			//take user input
			System.out.print("\nEnter command: ");
			String input = sc.nextLine();
			
			//if spells were not provided and the user enter a spell 
			//i will ask him for another command
			if((!(input.equals("attack") || input.equals("quit")) && noSpells)) {
				System.out.println("No spells were provided type \"attack\" to fight: ");
				input = sc.nextLine();
			}
			
			//if we have spells, this executes when a spell is provided by user
			if(((!(input.equals("attack") || input.equals("quit")) && (!noSpells)))) {
				int seed = r.nextInt();
				player.castSpell(input, seed);
					
				if(player.castSpell(input, seed)<= 0) {
					System.out.println("Player tried to cast " + input +", but failed.");						
					monsterAttack(player, monster);
				}
				
				else {
					spellAttack(player, monster, input, seed);
				}				
				player.castSpell(input, seed);
				
			}	
				
			
			
			//if its not a spell but attack this happens
			if(input.equals("attack")) {
				//player attacking monster
				playerAttack(player, monster);
				
				//monster attacking player
				monsterAttack(player, monster);
				
			}
			
			if(input.equals("quit")) {
				System.out.println("GoodBye");
				return;
			}
		}
		
		whoWon(player, monster, playerFile, monsterFile);

}
	//method that displays both characters
	private static void displayCharacters(Character player, Character monster) {
		System.out.println(player);
		System.out.println("Attack: " + player.getAttackValue());
		System.out.println("Wins: " + player.getNumWins());
		System.out.println();
		System.out.println(monster);
		System.out.println("Attack: " + monster.getAttackValue());
		System.out.println("Wins: " + monster.getNumWins());
		System.out.println();
	}
	
	//method that makes the player attack the monster
	private static void playerAttack(Character player, Character monster) {
		//create random seed for attackDamage
		int ADplayer = r.nextInt();
		double damage = player.getAttackDamage(ADplayer);
		//make damage string and print out how much damage the character did
		String attackStrPlayer = String.format("%1$,.2f", damage);
		System.out.println(player.getName() + " does damage: " + attackStrPlayer);
		//make the enemy take damage
		monster.takeDamage(Double.parseDouble(attackStrPlayer));
		//check if monster is still alive, if its dead player won
		if(monster.getCurrHealth() > 0)
			System.out.println(monster + "\n");
	}
	
	//method that makes the monster attack the player
	private static void monsterAttack(Character player, Character monster) {
		//create random seed for attackDamage
		int ADmonster = r.nextInt();
		double damage = monster.getAttackDamage(ADmonster);
		//make damage string and print out how much damage the character did
		String attackStrMonster = String.format("%1$,.2f", damage);
		System.out.println(monster.getName() + " does damage: " + attackStrMonster);	
		//make enemy take damage
		player.takeDamage(Double.parseDouble(attackStrMonster));
		//check if player is dead, if so player lost the game
		if(player.getCurrHealth() > 0)
			System.out.println(player);
	}
	
	//method which facilitates the spell attacks
	private static void spellAttack(Character player, Character monster, String input, int seed) {
		System.out.println(player.getName() + " casts " + input + " dealing " + player.castSpell(input, seed) + " damage!" );
		monster.takeDamage(player.castSpell(input, seed));
		if(monster.getCurrHealth() > 0) {
			System.out.println(monster + "\n");
			monsterAttack(player, monster);
		}
	}
	//this method announces the winner and increases their winnings
	private static void whoWon(Character player, Character monster, String playerFile, String monsterFile) {
		if(player.getCurrHealth() <= 0) {
			monster.increaseWins();
			System.out.println("Oh no! you lost!\n" + monster.getName() + "-the monster- has won: " + monster.getNumWins() + " times");
			FileIO.writeCharacter(monster, monsterFile);
		}
		else if(monster.getCurrHealth() <= 0) {
			player.increaseWins();
			System.out.println(player.getName() + " has slain the monster!\n" + player.getName() + " has won: " + player.getNumWins() + " times");
			FileIO.writeCharacter(player, playerFile);

		}
			
	}
	
}
