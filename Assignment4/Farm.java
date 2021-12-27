//kuba nowosielski
//260854650
public class Farm {
	private Sheep[] sheep;
	private Dog dog;
	private String name;
	
	public Farm(String name, Dog dog, Sheep[] sheep) {
		this.name = name;
		this.dog = dog;
		this.sheep = sheep;
		if(sheep.length > dog.herd())
			throw new IllegalArgumentException("This dog can't handle " + sheep.length + " sheep!");
		
	}
	public String getName() {
		return this.name;
	}
	public int getNumSheep() {
		return this.sheep.length;
	}
	public void printFarm() {
		System.out.println("Farm: " + name + " Dog: " + dog.getName());
		for(int i = 0;i<sheep.length;i++) {
			System.out.println(sheep[i].getName() + " " + sheep[i].getAge());
		}
	}
	public double getWool() {
		double pounds = 0;
		for(int i = 0;i<sheep.length;i++) {
			pounds += sheep[i].shear();
		}
		return pounds;
	}
}
