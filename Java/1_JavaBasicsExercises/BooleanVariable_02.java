package JavaBasicsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BooleanVariable_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean convertValue = Boolean.parseBoolean(reader.readLine());

        String result = convertValue ? "Yes" : "No";

        System.out.println(result);

    }
}
