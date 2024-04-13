/**
 * This class the main class to run the program to extract family information from a external file 
 * and to check the decesdants and ancestors of a specific member
 * 
 * Known Bugs: None
 * 
 * @Author: Nana Li
 * kejiali@brandeis.edu
 * Jan.18th, 2024
 * COSI21A PA0
 * 
 * 
 */
package main;

import java.util.*;
import java.io.*;

public class Relatives {

	/**
	 * the main method to run the program
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//to call the instruction of this program
		String[] result = instruction();
		//to read the external file and create the family list
		family f = inputRead(result[0]);
		//to check which member's information should be checked and whether the player want to check
		if(result[1].toLowerCase().equals("quit")) {
			System.out.println("Quit the Game");
		}else if(!f.contains(result[1])){
			System.out.println("There's not this relative.");
		}else {
			//print out the result
			System.out.println("\n"+"Ancestors:");
			f.getAncestors(0, f.get(result[1]));
			System.out.println("\n" + "Decesdants:");
			f.getDecesdants(0, f.get(result[1]));
		}
	}

	/**
	 * instruction of this program
	 * @return String[]: String array storing the external file name and the name of the member who need to be checked
	 */
	public static String[] instruction() {
		Scanner console  = new Scanner(System.in);
		System.out.println("What is the input File?");
		String file = console.nextLine();
		System.out.println("Person's name?('quit' to end?)");
		String person = console.nextLine();
		String[] result = {file, person};
		return result;
	}
	
	/**
	 * to read the data from the external file and create a family
	 * @param file: String representing the external file
	 * @return family: the family need to be checked in this program
	 * @throws FileNotFoundException
	 */
	public static family inputRead(String file) throws FileNotFoundException {
		// to read the data from the external file
		Scanner input = new Scanner(new File(file));
		family Family = new family();
		String name  = input.nextLine();
		while(input.hasNextLine() && !name.equals("END")) {
			member newMember = new member(name);
			Family.add(newMember);
			name = input.nextLine();
		}
		String x = input.nextLine();
		while(input.hasNextLine() && !x.equals("END")) {
			String y = input.nextLine();
			String z = input.nextLine();
			Family.addParent(1, x, y);
			Family.addParent(2, x, z);
			Family.addDecesdants(y, x);
			Family.addDecesdants(z, x);
			x = input.nextLine();
		}
		return Family;
	
	}
}
