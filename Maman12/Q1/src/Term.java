package src;

/**
 * The Term class represents a single term in a polynomial.
 * Each term has a coefficient and a power.
 */
public class Term {
    private double coefficient;
    private int power;

    /**
     * Constructs a Term with a coefficient and a power.
     * @param coefficient the coefficient of the term
     * @param power the power of the term
     */
    public Term(double coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    /**
     * Gets the coefficient of the term.
     * @return the coefficient
     */
    public double getCoefficient() {
        return coefficient;
    }

    /**
     * Gets the power of the term.
     * @return the power
     */
    public int getPower() {
        return power;
    }

    /**
     * Returns a string representation of the term.
     * Format: "<coefficient>, <power>"
     * @return the string representation
     */
    public String toString() {
        return coefficient + ", " + power;
    }
}
