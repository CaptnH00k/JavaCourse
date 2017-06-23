package rationals;

import java.math.BigInteger;

public class Rational {

	/**
	 * @param args
	 */
	private long nominator; // reduced nominator 
	private long denominator; // reduced denominator
	

	/**
	 * Constructor for creating a new rational.
	 * Makes sure denominator is not zero and
	 * reduces the rational.
	 * @param nominator
	 * @param denominator
	 */
	public Rational(long nominator, long denominator) {
		if(denominator == 0) {
			throw new IllegalArgumentException("denominator divides by zero");
		}
		// reduce rational
		long greatestCommonDenominator = this.greatestCommonDenominator(nominator, denominator);
		this.nominator = nominator / greatestCommonDenominator;
		this.denominator = denominator / greatestCommonDenominator;
	}
	
	/**
	 * Calculate the greatest common denominator
	 * with the iterative euclid algorithm.
	 * https://de.wikipedia.org/wiki/Euklidischer_Algorithmus#Beschreibung_durch_Pseudocode_2
	 * @param nominator
	 * @param denominator
	 * @return
	 */
	public long greatestCommonDenominator(long nominator, long denominator) {
		long greatestCommonDenominator = nominator;
		long b = denominator;
		long h;
		while(b != 0) {
			h = greatestCommonDenominator % b;
			greatestCommonDenominator = b;
			b = h;
		}
		return greatestCommonDenominator;
	}
	
	public Rational add(Rational r) {
		long rNom = r.getNominator();
		long rDen = r.getDenominator();
		
		long gcd = this.greatestCommonDenominator(
			this.denominator,
			rDen
		);
		
		long rDenDivGcd = rDen / gcd;
		long denDivGcd = this.denominator / gcd;
		
		return new Rational(
			Math.addExact(
				Math.multiplyExact(this.nominator, rDenDivGcd),
				Math.multiplyExact(rNom, denDivGcd)
			),
			Math.multiplyExact(denDivGcd, rDen)			
		);
	}
	
	public Rational multiply(Rational r) {
		long rNom = r.getNominator();
		long rDen = r.getDenominator();
		
		long gcd1 = this.greatestCommonDenominator(this.nominator, rDen);
		long gcd2 = this.greatestCommonDenominator(this.denominator, rNom);
		
		return new Rational(
			Math.multiplyExact(this.nominator / gcd1, rNom / gcd2),
			Math.multiplyExact(this.denominator / gcd2, rDen / gcd1)
		);
	}
	
	public Rational invert(Rational r) {
		return new Rational(
				r.getDenominator(),
				r.getNominator()
		);
	}
	
	public double toDouble() {
		return (double) this.nominator / this.denominator;
	}
	
	public long getNominator() {
		return this.nominator;
		
	}
	public long getDenominator() {
		return this.denominator;
	}
	
	@Override
	public boolean equals(Object r) {
		if(this.getClass() == r.getClass()) {
			Rational rat = (Rational) r;
			if(this.nominator == rat.getNominator() &&
			   this.denominator == rat.getDenominator()) {
				return true;
			}
			   
		}
		return false;
	}
}
