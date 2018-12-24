package JavaBasicsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseCharacters_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstLetter = reader.readLine();
        String secondLetter = reader.readLine();
        String thirdLetter = reader.readLine();

        System.out.printf("%s%s%s", thirdLetter, secondLetter, firstLetter);
    }
}
