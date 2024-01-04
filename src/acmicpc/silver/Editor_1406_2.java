package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Editor_1406_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String origin = br.readLine();

        final List<Character> editor = new LinkedList<>();

        for (char c : origin.toCharArray()) {
            editor.add(c);
        }

        ListIterator<Character> cursor = editor.listIterator(editor.size());

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String c = st.nextToken();


            switch (c) {
                case "P":
                    char a = st.nextToken().toCharArray()[0];

                    cursor.add(a);
                    break;
                case "L":
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                    }
                    break;
                case "D":
                    if (cursor.hasNext()) {
                        cursor.next();
                    }
                    break;
                case "B":
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char c : editor) {
            sb.append(c);
        }

        System.out.println(sb);

        br.close();
    }
}
