package acmicpc.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Tower_2493_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 5];
        int[] ans = new int[n + 5];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> t = new Stack<>();

        for (int i = n; i > 0; i--) {
            int now = arr[i];

            while (!t.isEmpty()) {
                Integer index = t.peek();
                int prev = arr[index];

                if (now > prev) {
                    t.pop();
                    ans[index] = i;
                } else {
                    break;
                }
            }
            t.push(i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(ans[i])
                    .append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}
