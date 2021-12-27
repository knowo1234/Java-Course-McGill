
import java.util.Scanner;
import java.util.Random;
public class WoolFactory{
  //The provided code generates random ages for sheep, and picks random names from the below array
  //You can modify this list of names as you wish (add/remove/replace elements).
  private static String[] namesForSheep = {"Cerdic","Cynric","Ceawlin","Ceol","Ceolwulf","Cynegils",
    "Cenwalh","Seaxburh","Aescwine","Centwine","Ceadwalla","Ine","Aethelheard","Cuthred","Cynewulf",
    "Berhtric","Egbert","Aethelwulf","Aethelbald","Aethelberht","Aethelred","Hengest","Aesc","Octa",
    "Eormenric","Aethelbert I","Eadbald","Earconbert","Egbert I","Hlothere","Oswine","Wihtred",
    "Aethelbert II","Sigered","Egbert II","Eadberht II","Cuthred","Baldred","Aethelfrith","Edwin","St. Oswald",
    "Oswiu","Ecgfrith","Aldfrith","Osred I","Cenred","Osric","Ceolwulf","Eadberht",
    "Aethelwald","Alhred","Aethelred I","Aelfwald I","Eardwulf","Eanred","George V","Edward VIII",
    "George VI","Elizabeth II"};
  private static Random r = new Random(123);
  
  //returns a random String from the above array. 
  private static String getRandomName(){
    int index = r.nextInt(namesForSheep.length);
    return namesForSheep[index];
  }
  //returns a random age for a sheep from 1 to 10
  private static int getRandomAge(){
    return r.nextInt(10)+1;
  }
  //End of provided name/age generation code. 
  
  public static void main(String[] args){
    //Student Name: Kuba Nowosielski
    //Student Number: 260854650
    //Your code goes here.
	
	//create scanner
    Scanner read = new Scanner(System.in);
    //get the name of the farm
    System.out.println("What is the name of the farm?");
    String nameFarm = read.nextLine();
    
    //get the name and breed of the dog to later initlize Dog with
    System.out.println("What is the name of the dog?");
    String nameDog = read.nextLine();
    System.out.println("What breed is " + nameDog + "?");
    String breed = read.nextLine();
    
    //get number of sheep to later initialize Sheep with
    System.out.println("And how many sheep do you have?");
    int numOfSheep = read.nextInt();
    
    //initialize and populate sheep array
    Sheep[] sheep = new Sheep[numOfSheep];
    for(int i = 0;i<sheep.length;i++) {
    	sheep[i] = new Sheep(getRandomName(), getRandomAge());
    }
    //initialize Sheep, Dog, and Farm
    Dog dog = new Dog(nameDog, breed);
    Farm farm = new Farm(nameFarm, dog, sheep);
    
    //get amount of money made
    double pounds = farm.getWool();
    
    
    //print everything out
    farm.printFarm();
    System.out.println("We just sheared " + pounds + "lbs of wool for a value of $" + pounds *1.45);
  }
}
















