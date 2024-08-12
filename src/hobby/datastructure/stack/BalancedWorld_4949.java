package hobby.datastructure.stack;

import java.io.*;
import java.util.Stack;

public class BalancedWorld_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;
        while (!(s = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();

            boolean flag = true;
            for (char c : s.toCharArray()) {
                if (c == '.') {
                    break;
                }
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        flag = false;
                        break;
                    }
                    stack.pop();
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                flag = false;
            }

            if (flag) {
                sb.append("yes");
            } else {
                sb.append("no");
            }
            sb.append("\n");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
