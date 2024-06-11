
import static org.junit.Assert.*;

import org.junit.Test;

public class MyPrimeTest {

	MyPrime prime = new MyPrime();

	@Test
	public void test2() {
		assertEquals(2, MyPrime.nextPrime(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegative() {
		MyPrime.nextPrime(-1);
	}

	@Test
	public void testEdgeInput0() {
		assertEquals(2, MyPrime.nextPrime(0));
	}

	@Test
	public void testEdgeInput2() {
		assertEquals(2, MyPrime.nextPrime(2));
	}

	@Test
	public void testEvenInput4() {
		assertEquals(5, MyPrime.nextPrime(4));
	}

	@Test
	public void testNonPrimeOddInput9() {
		assertEquals(11, MyPrime.nextPrime(9));
	}

	@Test
	public void testNonPrimeOddInput35() {
		assertEquals(37, MyPrime.nextPrime(35));
	}

	@Test
	public void testLargeNonPrimeOddInput93() {
		assertEquals(97, MyPrime.nextPrime(93));
	}

	@Test
	public void testLargeNonPrimeOddInput201() {
		assertEquals(211, MyPrime.nextPrime(201));
	}
}
