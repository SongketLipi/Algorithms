// Refer to `Introduction to Algorithms` (CLRS), page 935

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ModularExponentiation {
    private static int Exponentiate(int base, int power, int residue) {
        if (power == 0)
            return 1 % residue;
        int value = Exponentiate(base, power / 2, residue);
        value = (value * value) % residue;
        if (power % 2 == 1)
            value = (value * base) % residue;
        return value;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        System.out.println("Enter the number base (a): ");
        int base = in.nextInt();

        System.out.println("Enter the number power (n): ");
        int power = in.nextInt();

        System.out.println("Enter the number residue (m): ");
        int residue = in.nextInt();

        System.out.println("The result is: " + Exponentiate(base, power, residue));

    }
}
