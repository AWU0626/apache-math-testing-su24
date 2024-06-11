import static org.junit.Assert.*;

import java.math.BigInteger;

import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.fraction.Fraction;
import org.junit.Test;

public class MyFractionsTest {
	static MyFractions fractions = new MyFractions();

	@Test(expected = NullArgumentException.class)
	public void testF1NullF2Null() {
		MyFractions.addSub(null, null, false);
	}

	@Test(expected = NullArgumentException.class)
	public void testF1Null() {
		MyFractions.addSub(null, Fraction.ONE_HALF, false);
	}

	@Test(expected = NullArgumentException.class)
	public void testF2Null() {
		MyFractions.addSub(Fraction.ONE_HALF, null, false);
	}

	@Test(expected = MathArithmeticException.class)
	public void testOverflowNumerator() {
		Fraction f1 = new Fraction(Integer.MAX_VALUE, 1);
		MyFractions.addSub(f1, Fraction.TWO, true);
	}

	@Test(expected = MathArithmeticException.class)
	public void testOverflowDenominator() {
		Fraction f1 = new Fraction(1, Integer.MAX_VALUE);
		Fraction f2 = new Fraction(1, Integer.MAX_VALUE - 1);
		MyFractions.addSub(f1, f2, true);
	}

	@Test
	public void testF1IsZeroOnFalse() {
		Fraction answer = MyFractions.addSub(Fraction.ZERO, Fraction.ONE_HALF, false);
		assertEquals(new Fraction(-0.5), answer);
	}

	@Test
	public void testF1IsZeroOnTrue() {
		Fraction answer = MyFractions.addSub(Fraction.ZERO, Fraction.ONE_HALF, true);
		assertEquals(Fraction.ONE_HALF, answer);
	}

	@Test
	public void testF2IsZero() {
		Fraction answer = MyFractions.addSub(Fraction.ONE_HALF, Fraction.ZERO, true);
		assertEquals(Fraction.ONE_HALF, answer);
	}

	@Test
	public void testCoPrimeDenominatorAddition() {
		Fraction answer = MyFractions.addSub(Fraction.ONE_HALF, Fraction.ONE_THIRD, true);
		assertEquals(new Fraction(5, 6), answer);
	}

	@Test
	public void testCoPrimeDenominatorSubtraction() {
		Fraction answer = MyFractions.addSub(Fraction.ONE_HALF, Fraction.ONE_THIRD, false);
		assertEquals(new Fraction(1, 6), answer);
	}

	@Test
	public void testBigFractionAddition() {
		Fraction f1 = new Fraction(
				Integer.MAX_VALUE - 1,
				Integer.MAX_VALUE - 1);

		Fraction f2 = new Fraction(
				Integer.MAX_VALUE,
				Integer.MAX_VALUE);

		Fraction answer = MyFractions.addSub(f1, f2, true);
		assertEquals(Fraction.TWO, answer);
	}

	@Test
	public void testBigFractionSubtraction() {
		Fraction f1 = new Fraction(
				Integer.MAX_VALUE - 1,
				Integer.MAX_VALUE - 1);

		Fraction f2 = new Fraction(
				Integer.MAX_VALUE,
				Integer.MAX_VALUE);

		Fraction answer = MyFractions.addSub(f1, f2, false);
		assertEquals(Fraction.ZERO, answer);
	}

	@Test
	public void testBigIntegerArithmetic() {
		// Create large fractions
		Fraction f1 = new Fraction(BigInteger.valueOf(Long.MAX_VALUE).intValue(), Integer.MAX_VALUE);
		Fraction f2 = new Fraction(BigInteger.valueOf(Long.MAX_VALUE).intValue(), Integer.MAX_VALUE);
		Fraction result = MyFractions.addSub(f1, f2, false);

		BigInteger expectedNumerator = BigInteger.ZERO,
				expectedDenominator = BigInteger.valueOf(Integer.MAX_VALUE)
						.multiply(BigInteger.valueOf(Integer.MAX_VALUE));

		Fraction expectedFraction = new Fraction(expectedNumerator.intValue(), expectedDenominator.intValue());

		assertEquals(expectedFraction, result);
	}
}
