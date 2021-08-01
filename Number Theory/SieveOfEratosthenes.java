// Refer to `Programming Contest : Data Structures and Algorithms` (Md. Mahbubul Hassan Shanto), page 52

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;


public class SieveOfEratosthenes {

    private static Vector<Integer> primeNumbers; // Will contain all the prime number up to N
    private static boolean[] mark; // The array that we will be marking out the nonprimes

    private static void MarkNonPrimes(int number){
        mark = new boolean[number+1]; // The array to be marked
        
        primeNumbers = new Vector<Integer>();
        
        mark[0] = true; // 0 is not a prime
        mark[1] = true; // 1 is not a prime number
        
        if (number >= 2) 
            primeNumbers.add(2); // 2 is prime

        // We need to mark the mutiples of each prime found upto root(N) ; +1  to play safe
        int limit = (int)Math.pow(number, 1/2.0) + 1;
        
        for(int i = 3; i <= number; 
            // increment +2 because there are no such even prime numbers anymore
            i += 2
            )
            // if not marked then it is a prime number
            if(!mark[i]){
                primeNumbers.add(i); // add to the vector
                if( 
                    // We don't need mark the multiple of a prime number that is greater than root(N)
                    i <= limit
                    )
                    for(int j = i*i; j <= number; j += i*2)
                        mark[j] = true; // mark the multiples of the prime number upto N
            }
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        System.out.println("Enter the number : ");
        int number = in.nextInt();
        
        MarkNonPrimes(number);

        System.out.println("There prime numbers up to N are :");
        for (Integer prime : primeNumbers) {
            System.out.println(prime);
        }
        System.out.print("And "+ number + " is : ");
        if (
            /* 
                Don't do `!mark[number]` because we did not mark the multiple's of 2,
                    as well as checked Odds only.
                We skipped it to save computation time.

            */
            primeNumbers.contains(number)
            ) 
            System.out.println("Prime");
        else
            System.out.println("Not prime");
    }
    
}