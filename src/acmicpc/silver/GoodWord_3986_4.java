package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class GoodWord_3986_4 {
    private static final char A = 'A';
    private static final char B = 'B';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        while (n-- > 0) {
            String word = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (char c : word.toCharArray()) {

                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }

                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }
        }

        System.out.println(answer);
        br.close();
    }
}
