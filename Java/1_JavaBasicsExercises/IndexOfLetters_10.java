package JavaBasicsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IndexOfLetters_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        String words = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < text.length(); i++) {
            System.out.println(text.charAt(i) + " -> " + words.indexOf(text.charAt(i)));
        }
    }
}
