package t5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalTest {
	
	 private Cal c = new Cal();

	@Test
	void testAdd() {
		 assertEquals(5, c.add(2, 3));
	}

	@Test
	void testSubstract() {
		 assertEquals(-1, c.substract(2, 3));
	}
	
	@Test
	void testmultilicar() {
		 assertEquals(6, c.multiplicar(2, 3));
	}
	
	@Test
	void testdividir() {
		 assertEquals(2, c.dividir(6, 3));
	}
	
	@Test
	void testmodulo() {
		 assertEquals(1, c.modulo(4, 3));
	}

}
