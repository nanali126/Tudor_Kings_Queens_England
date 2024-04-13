/**
 * This class is the object of family which stores many mambers of this family
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

public class family {
	ArrayList<member> list;
	
	/**
	 * to construct a new family
	 */
	public family() {
		this.list = new ArrayList<member>();
	}
	
	/**
	 * to return how many members in this family
	 * @return int: int representing how many members in this family
	 */
	public int size() {
		return list.size();
	}
	
	/**
	 * to add new member into this family
	 * @param m: the member need to be added into this family
	 */
	public void add(member m) {
		list.add(m);
	}
	
	/**
	 * to return the index of member with specific name
	 * @param name: the name need to be found in the family member list
	 * @return int: the int representing the index of where the member with name in the family member list
	 */
	public int find(String name) {
		member m = new member(name);
		int i = 0;
		while(i<list.size() && !list.get(i).equals(m)) {
			i++;
		}
		return i;
	}
	
	/**
	 * to return whether the member with specific name existing in this family member list
	 * @param name: the name need to be found in the family member list
	 * @return boolean: whether the member with specific name existing in this family member list
	 */
	public boolean contains(String name) {
		member m = new member(name);
		return list.contains(m);
	}
	
	/**
	 * to get the meber from the family member list with specifc name
	 * @param name: the name need to be found in the family member list
	 * @return member: the meber from the family member list with specifc name
	 */
	public member get(String name) {
		int i = find(name);
		return list.get(i);
	}
	
	/**
	 * to set the specifc member 's parent
	 * @param i: to determine to set parent1 or parent2
	 * @param name: String representing the member who need to be set
	 * @param parent: String representing the specifc member's parent
	 */
	public void addParent(int i, String name, String parent) {
		//to check whether the parent is unknow
		if(!name.equals("unknown") && !parent.equals("unknown")) {
			//to store the index of the determined member
			int a = find(name);
			//to get the member of determined member
			member m = list.get(a);
			//use the condition to check the parent is parent1 or parent2
			if(i == 1) {
				if(parent.equals("unknown")) {
					m.parent1(null);
				}else{
					m.parent1(get(parent));
				}
			}else if(i == 2) {
				if(parent.equals("unknown")) {
					m.parent2(null);
				}else {
					m.parent2(get(parent));
				}
			}
			//to replace the adjusted member into the original list
			list.set(a, m);
		}
		
	}
	
	/**
	 * to set specific member's decesdants
	 * @param name: String representing the member who need to be set
	 * @param decesdant: String repsentng the determined member's decesdant
	 */
	public void addDecesdants(String name, String decesdant) {
		//to check whether the decesdant is unknow
		if(!name.equals("unknown") && !decesdant.equals("unknown")) {
			//to store the index of determined member
			int a = find(name);
			member m = list.get(a);
			m.addDecesdants(get(decesdant));
			//to replace the adjusted member into the original list
			list.set(a, m);
		}
		
	}
	
	/**
	 * to print out all decesdants of the specific member
	 * @param i: help to determine how many tabs need to be printed
	 * @param m: the member who need to be checked
	 */
	public void getDecesdants(int i, member m) {
		String output = "";
		for(int a = 0; a<=i; a++) {
			output = output+"\t";
		}
		output = output + m.name();
		System.out.println(output);
		i++;
		//use recursion to print out all decesdants
		if(m.decesdants != null) {
			for(int j = 0; j< m.decesdants.size(); j++) {
				getDecesdants(i,m.decesdants.get(j));
			}
		}
		
	}
	
	/**
	 * to print out all parents of the specifc member
	 * @param i: help to determin how many tabs need to be printed
	 * @param m: the member who need to be checked
	 */
	public void getAncestors(int i, member m) {
		String output = "";
		for(int a = 0; a<=i; a++) {
			output = output +"\t";
		}
		output = output + m.name();
		System.out.println(output);
		i++;
		//use recursion to print out all ancestors
		if(m.parent1 != null) {
			getAncestors(i, m.parent1);
		}
		if(m.parent2 != null) {
			getAncestors(i, m.parent2);
		}
		
	}
	
	/**
	 * to return the String of every member's information stored in the family member list
	 * @return String: String storing every member's information stored in the family member list
	 */
	public String toString() {
		String output = "";
		for(int i = 0; i<list.size(); i++) {
			output = output + list.get(i).toString()+"; ";
		}
		return output;
	}

}
