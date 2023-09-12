import java.util.Scanner;

public class cipher {
    public static void main(String[] args){
        char[] alphabet = new char[26];
        int[] values = new int[26];

        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('A' + i);
            values[i] = i;
        }

            // Print the alphabet and corresponding values
            for (int i = 0; i < 26; i++) {
                System.out.println(alphabet[i] + " -> " + values[i]);
            } 

    }
    
}

//display alphabet amd value..
