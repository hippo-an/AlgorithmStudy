package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero_10773_Silver4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stk = new Stack<>();
        long ans = 0;
        for (int i = 1;i <= K; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0 && !stk.isEmpty()) {
                Integer pop = stk.pop();
                ans -= pop;
            }
            else if (x != 0) {
                stk.push(x);
                ans += x;
            }
        }

        System.out.println(ans);
        br.close();
    }
}
