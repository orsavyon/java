package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read first polynomial
        System.out.print("Enter number of terms in first polynomial: ");
        int n1 = scanner.nextInt();
        double[] coeffs1 = new double[n1];
        int[] powers1 = new int[n1];

        for (int i = 0; i < n1; i++) {
            System.out.print("Enter coefficient #" + (i + 1) + ": ");
            coeffs1[i] = scanner.nextDouble();
            System.out.print("Enter power #" + (i + 1) + ": ");
            powers1[i] = scanner.nextInt();
        }

        Polynom p1 = new Polynom(coeffs1, powers1);

        // Read second polynomial
        System.out.print("\nEnter number of terms in second polynomial: ");
        int n2 = scanner.nextInt();
        double[] coeffs2 = new double[n2];
        int[] powers2 = new int[n2];

        for (int i = 0; i < n2; i++) {
            System.out.print("Enter coefficient #" + (i + 1) + ": ");
            coeffs2[i] = scanner.nextDouble();
            System.out.print("Enter power #" + (i + 1) + ": ");
            powers2[i] = scanner.nextInt();
        }

        Polynom p2 = new Polynom(coeffs2, powers2);

        // Display polynomials
        System.out.println("\nFirst polynomial:      " + p1);
        System.out.println("Second polynomial:     " + p2);

        // Plus
        Polynom sum = p1.plus(p2);
        System.out.println("\nSum:                   " + p1 + " + " + p2 + " = " + sum);

        // Minus
        Polynom diff = p1.minus(p2);
        System.out.println("Difference:            " + p1 + " - " + p2 + " = " + diff);

        // Derivatives
        Polynom p1Deriv = p1.derivative();
        Polynom p2Deriv = p2.derivative();
        System.out.println("\nDerivative of first:   " + p1Deriv);
        System.out.println("Derivative of second:  " + p2Deriv);

        // Equals
        boolean isEqual = p1.equals(p2);
        System.out.println("\nAre the polynomials equal? " + (isEqual ? "Yes" : "No"));

        scanner.close();
    }
}
