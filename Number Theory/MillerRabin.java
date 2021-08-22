//Refer to `Introduction to Algorithms` (CLRS), page 969-970

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MillerRabin {
    // A slave method to compute a^d % n
    static int ComputePower(int a, int d, int n) {
        int result = 1;
        a = a % n;
        while (d > 0) {
            // Is d is odd?
            if (d % 2 == 1)
                result = (result * a) % n;
            // make d even; floor(Odd/2) == even
            d = d / 2; // Odd becomes even
            a = (a * a) % n;
        }

        return result; // value of (a^d % n)
    }

    // A slave method that serves as an witness
    static boolean MiillerTestWtiness(int d, int n) {
        int a = 2 + (int)
        // Take a random integer
        (Math.random() % (
        // handle n <=4
        n - 4));
        // Compute a^d % n
        int x = ComputePower(a, d, n);

        if (x == 1 || x == n - 1)
            return true;

        while (d != n - 1) {
            x = ((int) Math.pow(x, 2)) % n;
            d *= 2;

            // is Math.pow(x,2) % == 1
            if (x == 1)
                return false;
            // Witness says it can be a prime
            if (x == n - 1)
                return true;
        }
        return false;
    }

    static boolean ProbablyPrime(int number, int numberOfIterations) {
        if (number <= 1 || number == 4)
            return false;
        if (number == 3 || number == 2)
            return true;

        // Find r such that n = 2^d * r + 1

        int d = number - 1;

        while (d % 2 == 0)
            d /= 2;

        // Ask for k witnesses
        for (int test = 0; test < numberOfIterations; test++)
            if (!MiillerTestWtiness(d, number))
                return false;

        return true;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        System.out.println("Please enter the number (n): ");
        int number = in.nextInt();

        System.out.println("Please enter how many iterations you want (k): ");
        int numberOfIterations = in.nextInt();

        if (ProbablyPrime(number, numberOfIterations))
            System.out.println("Probably prime!");
        else
            System.out.println("Not prime");
    }

}
