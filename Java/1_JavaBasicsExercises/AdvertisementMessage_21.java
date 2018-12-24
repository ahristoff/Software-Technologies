package JavaBasicsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class AdvertisementMessage_21 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());

        String[] Phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can't live without this product."};
        String[] Events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] Author = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] Cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        for (int i = 0; i < num; i++) {
            String phrase = randomText(Phrases);
            String events = randomText(Events);
            String author = randomText(Author);
            String cities = randomText(Cities);

            System.out.printf("%s %s %s %s\n", phrase, events, author, cities);
        }

    }

    public static String randomText(String[] words) {
        Random random = new Random();

        int randomIndex = random.nextInt(words.length);

        return words[randomIndex];
    }
}
