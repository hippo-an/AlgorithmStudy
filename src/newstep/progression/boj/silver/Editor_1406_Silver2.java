package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Editor_1406_Silver2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String init = br.readLine();
        int cnt = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char c : init.toCharArray()) {
            left.push(c);
        }

        for (int i = 1; i <= cnt; i++) {
            String cmd = br.readLine();

            if (cmd.startsWith("P")) {
                char word = cmd.split(" ")[1].charAt(0);
                left.push(word);
            } else if (cmd.startsWith("L")) {
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
            } else if (cmd.startsWith("B")) {
                if (!left.isEmpty()) {
                    left.pop();
                }
            } else if (cmd.startsWith("D")) {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            }
        }

        while(!left.empty()){
            right.push(left.pop());
        }


        StringBuilder sb = new StringBuilder();
        while(!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);
        br.close();
    }
}
