package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LeftCompany_14501_2 {
    private static int n;
    private static int[] t;
    private static int[] p;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        t = new int[n];
        p = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        br.close();


//        bitShift();
        for (int i = 0; i < n; i++) {
            find(i, 0);
        }

        System.out.println(ans);
    }

    // 모든 경우에 대해 조건적으로 처리를 하고 말지를 결정하기때문에
    // 조건에 맞는 반복을 하는 경우보다 확인하는 경우의 수가 많다.
    private static void bitShift() {
        for (int i = 1; i < Math.pow(2, n); i++) {
            int res = 0;
            for (int k = 0; k < n; k++) {
                int time = k + t[k] - 1;
                if ((i & (1 << k)) != 0 && time < n) {
                    res += p[k];
                    k = time;
                }
            }

            ans = Math.max(res, ans);
        }
    }

    // 조건에 맞는 경우만 재귀적으로 찾아 가기 때문에 확인하는 경우의 수가
    // 비트 연산보다 적다.
    private static void find(int idx, int sum) {
        if (idx + t[idx] > n) {
            return;
        }

        sum += p[idx];
        idx += t[idx];

        for (int i = idx; i < n; i++) {
            find(i, sum);
        }

        ans = Math.max(sum, ans);
    }
}
