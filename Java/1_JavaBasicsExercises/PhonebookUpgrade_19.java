package JavaBasicsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class PhonebookUpgrade_19 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String info = reader.readLine();
        TreeMap<String, String> contact = new TreeMap<>();

        while (!info.equals("END")) {
            String[] infoSplit = info.split(" ");

            switch (infoSplit[0]) {
                case "A":
                    contact.put(infoSplit[1], infoSplit[2]);
                    break;
                case "S":
                    if (contact.containsKey(infoSplit[1])) {
                        System.out.printf("%s -> %s\n", infoSplit[1], contact.get(infoSplit[1]));
                    } else {
                        System.out.printf("Contact %s does not exist.\n", infoSplit[1]);
                    }
                    break;
                case "ListAll":
                    contact.entrySet().stream().forEach(e -> {
                        System.out.printf("%s -> %s\n", e.getKey(), e.getValue());
                    });
                    break;
            }
            info = reader.readLine();
        }
    }
}
