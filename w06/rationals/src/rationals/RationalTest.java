package rationals;

import org.junit.Test;
import static org.junit.Assert.*;

public class RationalTest {
	@Test 
	public void testReducing() {
		Rational r = new Rational(4, 2);
		assertEquals(r.getNominator(), 2);
		assertEquals(r.getDenominator(), 1);
	}
	
	@Test
	public void testAddingPrecicely() {
		Rational r1 = new Rational(10000000000l, 1);
		Rational r2 = new Rational(1, 2);
		assertEquals(new Rational(20000000001l, 2), r1.add(r2));
	}
	
	@Test
	public void testMultiplyingPrecicly() {
		Rational r1 = new Rational(10000000000l, 1);
		Rational r2 = new Rational(1, 2);
		assertEquals(new Rational(10000000000l, 2), r1.multiply(r2));
		
	}
	
	@Test
	public void testMultiplyingWithOverflowPrevention() {
		new Rational(9223372036854775772l, 9223372036854775771l).multiply(new Rational(9223372036854775773l, 9223372036854775772l));
	}
	
	@Test(expected = ArithmeticException.class)
	public void testAddingWithOverflow() {
		new Rational(9223372036854775772l, 9223372036854775771l).add(new Rational(9223372036854775773l, 9223372036854775772l));
		
	}
	
	@Test
	public void testAddingEdgeCaseModulusNotPositive() {
		new Rational(67, 50).add(new Rational(-67, 50));
	}
	
	
	@Test
	public void testInvert() {
		Rational r = new Rational(1, 2);
		assertEquals(
			new Rational(2, 1),
			r.invert(r)
		);
	}

	@Test
	public void testUniqueNominator() {
		Rational r1 = new Rational(1, 2);
		Rational r2 = new Rational(2, 4);
		assertEquals(r1.getNominator(), r2.getNominator());
		assertEquals(r1.getDenominator(), r2.getDenominator());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowingWithDenominatorZero() {
		new Rational(1, 0);
	}
}