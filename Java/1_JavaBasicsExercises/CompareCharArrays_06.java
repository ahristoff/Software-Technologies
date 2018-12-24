package JavaBasicsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompareCharArrays_06 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstWord = reader.readLine().replaceAll(" ", "");
        String secondWord = reader.readLine().replaceAll(" ", "");

        int result = firstWord.compareTo(secondWord);

        if(result == 0){
            System.out.println(firstWord);
            System.out.println(secondWord);
        }else if(result < 0){
            System.out.println(firstWord);
            System.out.println(secondWord);
        }else{
            System.out.println(secondWord);
            System.out.println(firstWord);
        }





    }


}
