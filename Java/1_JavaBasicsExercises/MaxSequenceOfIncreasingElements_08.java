package JavaBasicsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSequenceOfIncreasingElements_08 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxCount = 0;
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            int count = 0;
            for (int j = i; j < numbers.length - 1; j++) {
                if(numbers[j] < numbers[j + 1]){
                    count++;
                    if(count > maxCount){
                        maxCount = count;
                        index = i;
                    }
                }else{
                    break;
                }
            }
        }

        for (int i = 0; i <= maxCount; i++) {
            if(i < maxCount){
                System.out.print(numbers[index + i] + " ");
            }else{
                System.out.print(numbers[index + i]);
            }

        }

    }
}
