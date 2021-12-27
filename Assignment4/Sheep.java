import java.util.Random;
//kuba nowosielski
//260854650
public class Sheep {
	
	private String name;
	private int age;
	private boolean hasWool;
	private static Random numberGenerator = new Random(123);
	
	
	public Sheep(String name, int age) {
		this.name = name;
		this.age = age;
		hasWool = true;
	}
	
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	public double shear() {
		//if the sheep has no wool
		if(this.hasWool == false) {
			return 0.0;
		}
		else {
			double x = 4 * numberGenerator.nextDouble() +6;
			this.hasWool = false;
			return x;
			
		}
	}
}
