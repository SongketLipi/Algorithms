import java.util.*;
import java.io.*;

public class LongestCommonSubsequence{

    private static int stringALength; // length of Strring A; global access
    private static int stringBlength; // length of Strring B; global acces
    
    // In Java, we can't directly iterate over the characters
    private static char[] stringACharacters; // global access
    private static char[] stringBCharacters; // global access

    // A slave method to go through chars to find out the LCS
    private static int GetLCSLength(int stringALength, int stringBlength){
        if (stringALength == 0 || stringBlength == 0)
            return 0;
        if (stringACharacters[stringALength-1] == stringBCharacters[stringBlength-1])
            return 1 + GetLCSLength( stringALength-1, stringBlength-1);
        else
            return max(GetLCSLength(stringALength, stringBlength-1),
                       GetLCSLength(stringALength-1, stringBlength)
            );
    }

    // Just a slave method to know if it's a suffix or not
    private static boolean IsSubsequence(int stringALength, int stringBlength){
        return (GetLCSLength(stringALength, stringBlength)
                == stringBlength)? true : false;

    }

    private static int max(int a, int b){
        return (a > b)? a : b;
    }



    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        System.out.println("Enter the String 1 : ");
        String stringA = in.nextLine();
        stringALength = stringA.length();
        stringACharacters = stringA.toCharArray();

        System.out.println("Enter the String 2 : ");
        String stringB = in.nextLine();
        stringBlength = stringB.length();
        stringBCharacters = stringB.toCharArray();

        System.out.println("Is String 2 a Subsequence of String 1 : "
                           + IsSubsequence(stringALength, stringBlength));

    }

}
