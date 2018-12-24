package JavaBasicsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSequenceOfEqualElements_07 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int index = 0;
        int maxCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            int count = 0;
            for (int j = i; j < numbers.length; j++) {
                if(numbers[i] == numbers[j]){
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

        for (int i = 0; i < maxCount; i++) {
            if(i < maxCount - 1){
                System.out.print(numbers[index + i] + " ");
            }else{
                System.out.print(numbers[index + i]);
            }
        }

    }
}
