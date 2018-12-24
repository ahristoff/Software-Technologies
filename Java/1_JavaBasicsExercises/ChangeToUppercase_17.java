package JavaBasicsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeToUppercase_17 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        Pattern pattern = Pattern.compile("<upcase>(.*?)</upcase>");

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            text = text.replace(matcher.group(0), matcher.group(1).toUpperCase());
        }
        System.out.println(text);
    }
}
