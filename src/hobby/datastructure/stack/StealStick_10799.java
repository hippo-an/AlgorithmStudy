package hobby.datastructure.stack;

import java.io.*;
import java.util.Stack;

public class StealStick_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();


        int totalCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(') {
                stack.push(current);
            } else {
                // 첫번째 닫힘 괄호
                if (s.charAt(i - 1) == '(') {
                    stack.pop();
                    totalCount += stack.size();
                } else {
                    stack.pop();
                    totalCount++;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(totalCount));
        bw.flush();
        bw.close();
    }
}
