package JavaBasicsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class URLParser_16 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        if(!text.contains("://")) {
            System.out.printf("[protocol] = \"\"\n");
            System.out.printf("[server] = \"%s\"\n", text);
            System.out.printf("[resource] = \"\"");
            return;
        }

        String[] url = text.split("://");
        int index = url[1].indexOf("/");

        if(index == -1){
            System.out.printf("[protocol] = \"%s\"\n", url[0]);
            System.out.printf("[server] = \"%s\"\n", url[1]);
            System.out.printf("[resource] = \"\"");
            return;
        }

        String server = url[1].substring(0, index);
        String resource = url[1].substring(index + 1);

        System.out.printf("[protocol] = \"%s\"\n", url[0]);
        System.out.printf("[server] = \"%s\"\n", server);
        System.out.printf("[resource] = \"%s\"", resource);

    }
}
