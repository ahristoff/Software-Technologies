package JavaBasicsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VowelOrDigit_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char symbol =  reader.readLine().charAt(0);
        String volews = "aeiouAEIOU";

        if(Character.isDigit(symbol)){
            System.out.println("digit");
        }else if(volews.indexOf(symbol) != -1){
            System.out.println("vowel");
        }else{
            System.out.println("other");
        }

    }
}
