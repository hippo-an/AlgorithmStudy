package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class KeyLogger_5397_2 {

    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            String origin = br.readLine();

            List<Character> password = new LinkedList<>();
            ListIterator<Character> cursor = password.listIterator();

            char[] keyLog = origin.toCharArray();
            for (char c : keyLog) {
                if (c == '-') {
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                } else if (c == '<') {
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                    }
                } else if (c == '>'){
                    if (cursor.hasNext()) {
                        cursor.next();
                    }
                } else {
                    cursor.add(c);
                }
            }


            for (char c : password) {
                sb.append(c);
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
