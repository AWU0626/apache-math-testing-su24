import static org.junit.Assert.*;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.junit.Test;

public class MySorterTest {
	MySorter sorter = new MySorter();
	double[] x;
	double[] y;

	public void createSimpleArray() {
		x = new double[] { 3, 6 };
		y = new double[] { 4, 1 };
	}

	public void createComplexArray() {
		x = new double[] { 3, 16, 4, 10 };
		y = new double[] { 10, 16, 9, 3 };
	}

	@Test(expected = NullArgumentException.class)
	public void testNullInputs() {
		MySorter.sortInPlace(
				null,
				MySorter.OrderDirection.DECREASING,
				(double[]) null);
	}

	@Test(expected = NullArgumentException.class)
	public void testNullArrayX() {
		y = new double[3];
		MySorter.sortInPlace(
				null,
				MySorter.OrderDirection.DECREASING,
				(double[]) y);
	}

	@Test(expected = NullArgumentException.class)
	public void testNullArrayY() {
		x = new double[3];
		MySorter.sortInPlace(
				x,
				MySorter.OrderDirection.DECREASING,
				(double[]) null);
	}

	@Test(expected = DimensionMismatchException.class)
	public void testDimensionMisMatch() {
		x = new double[3];
		y = new double[4];
		MySorter.sortInPlace(
				x,
				MySorter.OrderDirection.DECREASING,
				(double[]) y);
	}

	@Test
	public void testSimpleSortDecreasing() {
		createSimpleArray();
		MySorter.sortInPlace(
				x,
				MySorter.OrderDirection.DECREASING,
				(double[]) y);

		double[] expectedArrX = new double[] { 6, 3 };
		double[] expectedArrY = new double[] { 1, 4 };

		assertArrayEquals(expectedArrX, x, 3);
		assertArrayEquals(expectedArrY, y, 3);
	}

	@Test
	public void testSimpleSortIncreasing() {
		createSimpleArray();
		MySorter.sortInPlace(
				x,
				MySorter.OrderDirection.INCREASING,
				(double[]) y);

		double[] expectedArrX = new double[] { 3, 6 };
		double[] expectedArrY = new double[] { 4, 1 };

		assertArrayEquals(expectedArrX, x, 3);
		assertArrayEquals(expectedArrY, y, 3);
	}

	@Test
	public void testComplexSortDecreasing() {
		createComplexArray();
		MySorter.sortInPlace(
				x,
				MySorter.OrderDirection.DECREASING,
				(double[]) y);

		double[] expectedArrX = new double[] { 16, 10, 4, 3 };
		double[] expectedArrY = new double[] { 16, 3, 9, 10 };

		assertArrayEquals(expectedArrX, x, 3);
		assertArrayEquals(expectedArrY, y, 3);
	}

	@Test
	public void testComplexSortIncreasing() {
		createComplexArray();
		MySorter.sortInPlace(
				x,
				MySorter.OrderDirection.INCREASING,
				(double[]) y);

		double[] expectedArrX = new double[] { 3, 4, 10, 16 };
		double[] expectedArrY = new double[] { 10, 3, 9, 16 };

		assertArrayEquals(expectedArrX, x, 3);
		assertArrayEquals(expectedArrY, y, 3);
	}
}
