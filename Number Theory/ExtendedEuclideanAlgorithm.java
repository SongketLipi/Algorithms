// Refer to `Introduction to Algorithms` (CLRS), page 937

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger; // Required for passing int by ref

// A helper class to construct representation `ax + by = d`
class AxBy {
    int a;
    int b;
    int x;
    int y;

    AxBy(int a, int b, int x, int y) {
        this.a = a;
        this.b = b;
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return a + " --- " + x + " --- " + b + " --- " + y;
    }
}

public class ExtendedEuclideanAlgorithm {
    private static Vector<AxBy> representations = new Vector<>(); // A vector to store representations

    private static int EuclidExtended(int a, int b, AtomicInteger x, AtomicInteger y) {
        // base case
        if (a == 0) {
            x.set(0); // ax = 0
            y.set(1); // by = d
            return b; // b = d
        }

        // X Y pass by reference integers
        AtomicInteger xPrime = new AtomicInteger();
        AtomicInteger yPrime = new AtomicInteger();

        // d not reached, do recursion
        int d = EuclidExtended(b % a, a, xPrime, yPrime);

        x.set(yPrime.get() - (b / a) * xPrime.get()); // Coefficient of A
        y.set(xPrime.get()); // // Coefficient of B

        representations.add(new AxBy(a, b, x.get(), y.get())); // Add to representation vector

        return d; // return GCD = d
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        System.out.println("Enter the number a: ");
        int numberA = in.nextInt();

        System.out.println("Enter the number b: ");
        int numberB = in.nextInt();

        // Create 2 pass by ref integers for recursion state updates
        AtomicInteger coefficientX = new AtomicInteger();
        AtomicInteger coefficientY = new AtomicInteger();

        System.out.println("The GCD is: " + EuclidExtended(numberA, numberB, coefficientX, coefficientY));
        System.out.println("a --- x --- b --- y");
        for (AxBy representation : representations) {
            System.out.println(representation.toString());
        }
    }
}