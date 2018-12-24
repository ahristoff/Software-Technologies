package JavaBasicsExercises;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CensorEmailAddress_15 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String searchingEmail = scanner.nextLine();
        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile(searchingEmail);

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String[] word = matcher.group(0).split("@");
            String leftPart = word[0].replace(word[0], newString("*", word[0].length()));
            String result = leftPart + "@" + word[1];

            text = text.replace(matcher.group(0), result);
        }

        System.out.println(text);
    }

    public static String newString(String symbol, int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append("*");
        }
        return sb.toString();
    }
}
