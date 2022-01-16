package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

public class Parenthesis_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Character> ch = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            sb.append(getYesNo(ch, s));
            ch.clear();
        }
        System.out.println(sb.toString());
    }

    private static String getYesNo(Stack<Character> ch, String s) {
        for (char c : s.toCharArray()) {
            if(c == '(') ch.push(c);
            else if (ch.isEmpty()) {
                return "NO\n";
            } else ch.pop();
        }
        return ch.isEmpty() ? "YES\n" : "NO\n";
    }
}
