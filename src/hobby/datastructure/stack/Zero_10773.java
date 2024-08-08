package hobby.datastructure.stack;

import java.io.*;
import java.util.Stack;

public class Zero_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(a);
            }
        }

        int sum = 0;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        bw.write(Integer.toString(sum));

        bw.flush();
        bw.close();
        br.close();
    }
}
