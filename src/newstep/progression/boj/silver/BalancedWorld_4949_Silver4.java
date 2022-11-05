package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedWorld_4949_Silver4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (".".equals(s)) break;

            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for (char x : s.toCharArray()) {
                if ('(' == x || '[' == x) {
                    stack.push(x);
                } else if (')' == x || ']' == x) {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }

                    if (stack.peek() == '(' && x == ')') {
                        stack.pop();
                    } else if (stack.peek() == '[' && x == ']') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag && stack.isEmpty()) sb.append("yes").append("\n");
            else sb.append("no").append("\n");

        }

        System.out.println(sb);
    }
}
