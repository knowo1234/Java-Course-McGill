//name: Kuba Nowosielski
//ID: 260854650
import java.util.ArrayList;
import java.util.Random;

public class Character {
	//attributes
	private String name;
	private double attackValue;
	private double maxHP;
	private double currentHP;
	private int wins;
	private static ArrayList<Spell> spells = new ArrayList<Spell>();
	
	//constructor that takes in the name of the character their attackvalue, maxHP and amount of wins
	public Character(String name, double attackValue, double maxHP, int wins) {
		this.name = name;
		this.attackValue = attackValue;
		this.maxHP = maxHP;
		this.currentHP = maxHP;
		this.wins = wins;
	}
	
	//methods
	//get methods
	public String getName() {
		return this.name;
	}
	public double getAttackValue() {
		return this.attackValue;
	}
	public double getMaxHealth() {
		return this.maxHP;
	}
	public double getCurrHealth() {
		return this.currentHP;
	}
	public int getNumWins() {
		return this.wins;
	}
	//set methods
	public static void setSpells(ArrayList<Spell> spell) {
		for(int i = 0;i<spell.size();i++) {
			spells.add(spell.get(i)); 
		}
	}
	//display method that displays the spells
	public static void displaySpells() {
		//loop through arraylist and display the spells
		for(int i = 0;i<spells.size();i++) {
			System.out.println(spells.get(i));
		}
	}
	//cast spells
	public double castSpell(String chosenSpell, int x) {
		for(int i = 0; i<spells.size();i++) {
			if(chosenSpell.equalsIgnoreCase(spells.get(i).getName())) {
				return (spells.get(i).getMagicDamage(x));
			}
			
		}
		return -1;
	}
	//toString method
	public String toString() {
		String s = "Name: " + this.name +"\nhealth: " + this.currentHP;
		return s;
	}
	//method that shows how much damage a character does when they attack
	public double getAttackDamage(int seed) {
		Random AD = new Random(seed);
		double damage = this.attackValue * (AD.nextDouble()*0.3 + 0.7);
		return damage;
	}
	//method that subtracts damage done from characters health
	public double takeDamage(double damageDone) {
		this.currentHP = this.currentHP - damageDone;
		return this.currentHP;
	}
	//method that increases wins
	public void increaseWins() {
		this.wins++;
	}
	
	
	
	
	
	
	
}
