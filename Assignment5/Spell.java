//name: Kuba Nowosielski
//ID: 260854650
import java.util.Random;

public class Spell {
	//attributes
	private String name;
	private double minDmg;
	private double maxDmg;
	private double chance;
	
	//constructor that takes in the name of the spell as well as its stats
	public Spell(String name, double minDmg, double maxDmg, double chance) {
		if(minDmg < 0 || minDmg > maxDmg || chance < 0 || chance > 1)
			throw new IllegalArgumentException("Incorrect parameters");
		else {
			this.name = name;
			this.minDmg = minDmg;
			this.maxDmg = maxDmg;
			this.chance = chance;
			
		}
	}
	
	//methods
	//get methods
	public String getName() {
		return this.name;
	}
	public double getMagicDamage(int seed) {
		Random threshold = new Random(seed);
		if(threshold.nextDouble() > this.chance) {
			return 0.0;
		}
		else {
			double spellDmg = threshold.nextDouble()*(maxDmg-minDmg) + minDmg;
			return spellDmg;
		}
	}
	//toString method displaying the spell
	public String toString() {
		String c = String.format("%1$,.2f", chance*100);
		String s = "\nSpell: " + this.name + "\n Minimum DMG: " + this.minDmg + " Maximum DMG: "+ this.maxDmg + " Chance: " + c + "%";
		return s;
	}
}
