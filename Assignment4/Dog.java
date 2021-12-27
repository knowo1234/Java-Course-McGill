//kuba nowosielski
//260854650
public class Dog {
	private String name;
	private String breed;

	public Dog(String name, String breed) {
		this.name = name;
		this.breed = breed;
	}
	public String getName() {
		return this.name;
	}
	public int herd() {
		String breed = this.breed.toLowerCase();
		if(breed.contains("collie"))
			return 20;
		else if(breed.contains("shepard"))
			return 25;
		else if(breed.contains("kelpie") || breed.contains("teruven"))
			return 30;
		else
			return 10;
	}

}
