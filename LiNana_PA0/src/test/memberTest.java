package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.member;

@SuppressWarnings("unused")
class memberTest {

	@Test
	void test() {
		member m = new member("Margaret");
		assert("Margaret".equals(m.name()));
	}
	
	@Test
	void addParentTest() {
		member m = new member("Margare");
		member p1 = new member("Henry");
		member p2 = new member("Margaret I");
		m.parent1(p1);
		m.parent2(p2);
		assert("Henry".equals(m.getParent1().name()));
		assert("Margaret I".equals(m.getParent2().name()));
		
	}
	
	@Test
	void addDecesdantsTest() {
		member m = new member("Margaret");
		member decesdant1 = new member("Henry VII");
		member decesdant2 = new member("Margaret I");
		m.addDecesdants(decesdant1);
		m.addDecesdants(decesdant2);
		assert("Henry VII".equals(m.getDecesdants().get(0).name()));
		assert("Margaret I".equals(m.getDecesdants().get(1).name()));
	}
	
	@Test
	void toStringTest() {
		member m = new member("Margaret");
		member p1 = new member("Henry");
		member p2 = new member("Margaret I");
		member d = new member("Henry VII");
		m.parent1(p1);
		m.parent2(p2);
		m.addDecesdants(d);
		System.out.println(m.toString());
		assert(m.toString().equals("Margaret: parent1: Henry; parent2: Margaret I; Decesdants: Henry VII & "));
	}

}
