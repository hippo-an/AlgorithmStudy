package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackProgression_1874_Silver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x < max) {
                Integer pop = stack.pop();
                if (pop == x) sb.append("-\n");
                else break;
            } else {
                for (int i = max + 1; i <= x; i++) {
                    stack.push(i);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");

                max = x;
            }
        }

        if (stack.isEmpty()) { System.out.println(sb);}
        else { System.out.println("NO");}
    }
}
