package hobby.datastructure.stack;

import java.io.*;
import java.util.Stack;

public class Parenthesis_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        out: while (t-- > 0) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        stack.push(c);
                        break;
                    }
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                bw.write("YES");
            } else {
                bw.write("NO");
            }

            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
