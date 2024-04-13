package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.family;
import main.member;

@SuppressWarnings("unused")
class familyTest{
	
	@Test
	void test() {
		family f = new family();
		member m = new member("Margaret");
		f.add(m);
		assert(f.size() == 1);
		assert(f.get("Margaret").equals(m));
		assert(f.toString().equals("Margaret: parent1: null; parent2: null; Decesdants: ; "));
	}
	
	@Test
	void addTest() {
		family f = new family();
		member m = new member("Margaret");
		member p1 = new member("Henry");
		f.add(m);
		f.add(p1);
		f.addParent(1, "Margaret", "Henry");
		f.addDecesdants("Henry", "Margaret");
		assert(f.get("Margaret").getParent1().equals(p1));
		assert(f.get("Henry").getDecesdants().get(0).equals(m));
	}
}