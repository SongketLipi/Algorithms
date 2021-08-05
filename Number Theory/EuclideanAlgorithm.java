// Refer to `Introduction to Algorithms` (CLRS), page 935

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EuclideanAlgorithm {
    // The Euclidian method to compute greatest common divisor
    private static int Euclid(int a, int b){
        if (b == 0)
            return a;
        else
            return Euclid(b, a%b);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        System.out.println("Enter the number a: ");
        int numberA = in.nextInt();

        System.out.println("Enter the number b: ");
        int numberB = in.nextInt();

        System.out.println("The GCD is: " + Euclid(numberA, numberB));
    }
}
