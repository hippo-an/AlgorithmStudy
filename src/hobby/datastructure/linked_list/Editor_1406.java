package hobby.datastructure.linked_list;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Editor_1406 {

    private static final LinkedList<Character> editor = new LinkedList<>();
    private static int cur;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String initial = br.readLine();
        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < initial.length(); i++) {
            editor.add(initial.charAt(i));
        }
        cur = initial.length();

        ListIterator<Character> cursor = editor.listIterator(initial.length());

        while (c-- > 0) {
            String l = br.readLine();
            char command = l.charAt(0);
            if (command == 'P') {
                cursor.add(l.charAt(2));
            } else if (command == 'L') {
                if (cursor.hasPrevious()) {
                    cursor.previous();
                }
            } else if (command == 'D') {
                if (cursor.hasNext()) {
                    cursor.next();
                }
            } else if (command == 'B'){
                if (cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (char s : editor) {
            bw.write(s);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
