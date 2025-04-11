package src;

import java.util.ArrayList;

/**
 * The Polynom class represents a polynomial using a list of terms.
 * The terms are stored in descending order by power.
 */
public class Polynom {
    public ArrayList<Term> terms;

    /**
     * Constructs a Polynom from arrays of coefficients and powers.
     * @param coefficients the array of coefficients
     * @param powers the array of powers
     * @throws IllegalArgumentException if arrays are not the same length
     */
    public Polynom(double[] coefficients, int[] powers) {
        if (coefficients.length != powers.length) {
            throw new IllegalArgumentException("Arrays must be of the same length.");
        }

        terms = new ArrayList<Term>();

        for (int i = 0; i < coefficients.length; i++) {
            addTermSorted(new Term(coefficients[i], powers[i]));
        }
    }

    /**
     * Adds a term to the list, keeping the list sorted by descending power.
     * @param newTerm the term to add
     */
    private void addTermSorted(Term newTerm) {
        int index = 0;
        while (index < terms.size() && newTerm.getPower() < terms.get(index).getPower()) {
            index++;
        }
        terms.add(index, newTerm);
    }

    /**
     * Returns a readable string representation of the polynomial,
     * formatted like a mathematical expression (e.g., "3x^2 - 2x + 1").
     *
     * @return the string representation of the polynomial
     */
    public String toString() {
        if (terms.isEmpty()) {
            return "0";
        }

        String result = "";

        for (int i = 0; i < terms.size(); i++) {
            Term term = terms.get(i);
            double coeff = term.getCoefficient();
            int power = term.getPower();

            if (coeff == 0) {
                continue; // skip zero terms
            }

            String sign = "";
            if (result.length() > 0) {
                sign = (coeff > 0) ? " + " : " - ";
            } else {
                if (coeff < 0) {
                    sign = "-";
                }
            }

            double absCoeff = Math.abs(coeff);
            String coeffStr = "";

            if (power == 0) {
                coeffStr = String.valueOf(absCoeff);
            } else if (power == 1) {
                coeffStr = (absCoeff == 1.0) ? "x" : absCoeff + "x";
            } else {
                coeffStr = (absCoeff == 1.0) ? "x^" + power : absCoeff + "x^" + power;
            }

            result += sign + coeffStr;
        }

        return result.trim();
    }


    /**
     * Returns a new Polynom that is the sum of this polynomial and another polynomial.
     * The sum is computed by combining terms with the same power.
     *
     * @param other the polynomial to add
     * @return a new Polynom representing the sum
     */
    public Polynom plus(Polynom other) {
        ArrayList<Term> resultTerms = new ArrayList<Term>();

        int i = 0; // index for this.terms
        int j = 0; // index for other.terms

        while (i < this.terms.size() && j < other.terms.size()) {
            Term t1 = this.terms.get(i);
            Term t2 = other.terms.get(j);

            if (t1.getPower() > t2.getPower()) {
                resultTerms.add(new Term(t1.getCoefficient(), t1.getPower()));
                i++;
            } else if (t1.getPower() < t2.getPower()) {
                resultTerms.add(new Term(t2.getCoefficient(), t2.getPower()));
                j++;
            } else { // powers are equal
                double sumCoeff = t1.getCoefficient() + t2.getCoefficient();
                if (sumCoeff != 0) {
                    resultTerms.add(new Term(sumCoeff, t1.getPower()));
                }
                i++;
                j++;
            }
        }

        // Add remaining terms (if any)
        while (i < this.terms.size()) {
            Term t1 = this.terms.get(i);
            resultTerms.add(new Term(t1.getCoefficient(), t1.getPower()));
            i++;
        }

        while (j < other.terms.size()) {
            Term t2 = other.terms.get(j);
            resultTerms.add(new Term(t2.getCoefficient(), t2.getPower()));
            j++;
        }

        // Convert the ArrayList<Term> to coefficient and power arrays
        double[] coeffs = new double[resultTerms.size()];
        int[] powers = new int[resultTerms.size()];

        for (int k = 0; k < resultTerms.size(); k++) {
            coeffs[k] = resultTerms.get(k).getCoefficient();
            powers[k] = resultTerms.get(k).getPower();
        }

        return new Polynom(coeffs, powers);
    }
    /**
     * Returns a new Polynom that is the difference between this polynomial and another.
     * The difference is computed by subtracting coefficients of terms with the same power.
     *
     * @param other the polynomial to subtract
     * @return a new Polynom representing the difference
     */
    public Polynom minus(Polynom other) {
        ArrayList<Term> resultTerms = new ArrayList<Term>();

        int i = 0; // index for this.terms
        int j = 0; // index for other.terms

        while (i < this.terms.size() && j < other.terms.size()) {
            Term t1 = this.terms.get(i);
            Term t2 = other.terms.get(j);

            if (t1.getPower() > t2.getPower()) {
                resultTerms.add(new Term(t1.getCoefficient(), t1.getPower()));
                i++;
            } else if (t1.getPower() < t2.getPower()) {
                resultTerms.add(new Term(-t2.getCoefficient(), t2.getPower())); // subtracting: 0 - other
                j++;
            } else { // powers are equal
                double diffCoeff = t1.getCoefficient() - t2.getCoefficient();
                if (diffCoeff != 0) {
                    resultTerms.add(new Term(diffCoeff, t1.getPower()));
                }
                i++;
                j++;
            }
        }

        // Add remaining terms (if any)
        while (i < this.terms.size()) {
            Term t1 = this.terms.get(i);
            resultTerms.add(new Term(t1.getCoefficient(), t1.getPower()));
            i++;
        }

        while (j < other.terms.size()) {
            Term t2 = other.terms.get(j);
            resultTerms.add(new Term(-t2.getCoefficient(), t2.getPower()));
            j++;
        }

        // Convert the ArrayList<Term> to coefficient and power arrays
        double[] coeffs = new double[resultTerms.size()];
        int[] powers = new int[resultTerms.size()];

        for (int k = 0; k < resultTerms.size(); k++) {
            coeffs[k] = resultTerms.get(k).getCoefficient();
            powers[k] = resultTerms.get(k).getPower();
        }

        return new Polynom(coeffs, powers);
    }
    /**
     * Returns the derivative of this polynomial.
     * The derivative is computed by applying the rule: d/dx(a*x^n) = a*n*x^(n-1)
     *
     * @return a new Polynom representing the derivative
     */
    public Polynom derivative() {
        ArrayList<Term> derivedTerms = new ArrayList<Term>();

        for (int i = 0; i < terms.size(); i++) {
            Term t = terms.get(i);
            if (t.getPower() != 0) {
                double newCoefficient = t.getCoefficient() * t.getPower();
                int newPower = t.getPower() - 1;
                derivedTerms.add(new Term(newCoefficient, newPower));
            }
            // If power is 0, derivative is 0 (i.e., constant term disappears)
        }

        // Convert list to arrays
        double[] coeffs = new double[derivedTerms.size()];
        int[] powers = new int[derivedTerms.size()];

        for (int i = 0; i < derivedTerms.size(); i++) {
            coeffs[i] = derivedTerms.get(i).getCoefficient();
            powers[i] = derivedTerms.get(i).getPower();
        }

        return new Polynom(coeffs, powers);
    }
    /**
     * Compares this polynomial to another object.
     * Returns true if the other object is also a Polynom
     * and contains the same terms in the same order.
     *
     * @param obj the object to compare
     * @return true if the polynomials are equal, false otherwise
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Polynom)) {
            return false;
        }

        Polynom other = (Polynom) obj;

        if (this.terms.size() != other.terms.size()) {
            return false;
        }

        for (int i = 0; i < terms.size(); i++) {
            Term t1 = this.terms.get(i);
            Term t2 = other.terms.get(i);

            if (t1.getCoefficient() != t2.getCoefficient() || t1.getPower() != t2.getPower()) {
                return false;
            }
        }

        return true;
    }


}
