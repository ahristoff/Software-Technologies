package JavaBasicsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EqualSums_11 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean foundIndex = false;

        for (int currentEl = 0; currentEl < numbers.length; currentEl++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int i = 0; i < currentEl; i++) {
                leftSum += numbers[i];
            }

            for (int i = currentEl + 1; i < numbers.length; i++) {
                rightSum += numbers[i];
            }

            if (leftSum == rightSum) {
                System.out.println(currentEl);
                foundIndex = true;
            }
        }

        if (!foundIndex) {
            System.out.println("no");
        }

    }
}
