package JavaBasicsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FitStringIn20Chars_14 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        if (text.length() > 20) {
            System.out.println(text.substring(0, 20));
        } else {
            int count = 20 - text.length();
            System.out.println(text + newString("*", count));
        }
    }

    public static String newString(String symbol, int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append(symbol);
        }
        return sb.toString();
    }
}
