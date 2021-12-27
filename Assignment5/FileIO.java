//name: Kuba Nowosielski
//ID: 260854650
import java.io.*;
import java.util.ArrayList;

public class FileIO {
 //method that reads characters from a file
 public static Character readCharacter(String fileName) {
  Character character = null;
  String line;
  String name = null;
  Double attackValue = 0.0;
  Double maxHP = 0.0;
  Integer wins = 0;
  try {
   //create reader and buffer
   FileReader fr = new FileReader(fileName);
   BufferedReader br = new BufferedReader(fr);
   //read the first line to make sure it is not null
   line = br.readLine();
   //make a loop that will go through the lines and store the values 
   //in the approperiate variables
   for(int i = 0; line != null; i++) {
    if(i == 0) {
     name = line;
    }
    else if(i==1) {
     attackValue = Double.parseDouble(line);
    }
    else if(i==2) {
     maxHP = Double.parseDouble(line);
    }
    else if(i==3) {
     wins = Integer.parseInt(line);
    }
    line = br.readLine();
   }
   //close
   br.close();
   fr.close();
   //set up character from file
   character = new Character(name, attackValue, maxHP, wins);
   //return ready character
   return character; 

  } 
  //in case the file is not there
  catch (FileNotFoundException e) {
   System.out.println("File was not found");
   return null;
   
  }
  //in case anything else goes wrong
  catch (IOException e) {
   System.out.println("Something went wrong");
   return null;
  }
 }
 //method that reads the spells from the file of spells provided
 public static ArrayList<Spell> readSpells(String filename) {
  ArrayList<Spell> spells = new ArrayList<Spell>();
  try {
   FileReader fr = new FileReader(filename);
   BufferedReader br = new BufferedReader(fr);
   String line = br.readLine();
   //loop through each line and gather the info about each spell then store all the info into an arraylist of spells
   for(int i = 0;line != null;i++) {
   
    String name = line.split("\t")[0];
    double minDmg = Double.parseDouble(line.split("\t")[1]);
    double maxDmg = Double.parseDouble(line.split("\t")[2]);
    double chance = Double.parseDouble(line.split("\t")[3]);
    Spell magic = new Spell(name, minDmg, maxDmg, chance);
    spells.add(magic);
    line = br.readLine();
   
   }
   //close
   br.close();  
   fr.close();
   //set up character from file
   return spells; //arraylist of spells
  }   
  //in case the file is not there
  catch (FileNotFoundException e) {
   System.out.println("File was not found");
   return null;
  
  }
  //in case anything else goes wrong
  catch (IOException e) {
   System.out.println("Something went wrong");
   return null;
  }
 }
 //method that writes the end game character to file
 public static void writeCharacter(Character character, String file) {
  try {
   //create filewriter and bufferedwriter
   FileWriter fw = new FileWriter(file);
   BufferedWriter bw = new BufferedWriter(fw);
   //write each component to file and make new line
   bw.write(character.getName());
   bw.newLine();
   bw.write(Double.toString(character.getAttackValue()));
   bw.newLine();
   bw.write(Double.toString(character.getMaxHealth()));
   bw.newLine();
   bw.write(Integer.toString(character.getNumWins()));
   //close BW and FW
   bw.close();
   fw.close();
   System.out.println("Succesfully wrote to file!");
  } catch (IOException e) {
   System.out.println("Couldn't write to file");
  }
 }
}
