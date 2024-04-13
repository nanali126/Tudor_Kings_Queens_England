/**
 * This class is the object of member which stores family member's name, parent and decesdants
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

import java.util.ArrayList;

public class member {
	String name;
	member parent1;
	member parent2;
	ArrayList<member> decesdants;
	
	/**
	 * To construct the member with certain name
	 * @param name: the name  of the constructed member
	 */
	public member(String name) {
		this.name = name;
		this.decesdants = new ArrayList<member>();
	}
	
	/**
	 * to get the parent1 of this member
	 * @return member: member which is this member's parent1
	 */
	public member getParent1() {
		return parent1;
	}

	/**
	 * to get the parent2 of this member
	 * @return member: member which is this member's parent2
	 */
	public member getParent2() {
		return parent2;
	}
	
	/**
	 * to get the decesdants list of this member
	 * @return ArrayList<member>: to return the arraylist of decesdants of this member
	 */
	public ArrayList<member> getDecesdants(){
		return decesdants;
	}

	/**
	 * to set the parent1 of this member
	 * @param pmember: the member who is this member's parent1
	 */
	public void parent1(member parent) {
		this.parent1 = parent;
	}
	
	/**
	 * to set the parent2 of this member
	 * @param parent: the member who is this member's parent2
	 */
	public void parent2(member parent) {
		this.parent2 = parent;
	}
	
	/**
	 * to add the decesdant to the decesdants list
	 * @param decesdant: the member representing this member's decesdant
	 */
	public void addDecesdants(member decesdant) {
		this.decesdants.add(decesdant);
	}
	
	/**
	 * to return whether a member has the same name with another member
	 * @return boolean: whether a member has the same name with another member
	 */
	public boolean equals(Object o) {
		member other = (member) o;
		return other.name.equals(name);
		
	}
	
	/**
	 * to return the name of this member
	 * @return String: the String representing the name of this member
	 */
	public String name() {
		return name;
	}
	
	/**
	 * to return the String containning the information of this member
	 * @return String: String storing the information of this member
	 */
	public String toString() {
		String output = name + ": parent1: ";
		if(parent1 != null) {
			output=output+parent1.name()+"; ";
		}else {
			output = output+"null; ";
		}
		output = output + "parent2: ";
		if(parent2 != null) {
			output = output+parent2.name()+"; ";
		}else {
			output = output +"null; ";
		}
		output = output +"Decesdants: ";
		if(decesdants!=null) {
			for(int i = 0; i<decesdants.size(); i++) {
				output = output+decesdants.get(i).name() +" & ";
			}
		}
		return output;
		
	}

}
