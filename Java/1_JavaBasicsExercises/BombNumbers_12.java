package JavaBasicsExercises;

import java.util.Arrays;
import java.util.Scanner;

public class BombNumbers_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] searchingNumbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int specialNumber = searchingNumbers[0];
        int power = searchingNumbers[1];

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == specialNumber){
                numbers[i] = 0;

                int minLeft = Math.max(0, i - power);
                int minRight = Math.min(i + power, numbers.length - 1);

                for (int j = minLeft; j < i; j++) {
                    numbers[j] = 0;
                }

                for (int j = i; j <= minRight; j++) {
                    numbers[j] = 0;
                }
            }
        }

        System.out.println(Arrays.stream(numbers).sum());
    }
}
