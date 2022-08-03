package newstep.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Partial_1182 {

    private static int N, S, ans;
    private static int[] arr;
    private static boolean[] selected;
    public static void main(String[] args) throws IOException {
        input();

        // 부분 수열을 어떻게 구할까?
        recursiveFunction(1, 0);

        if (S == 0) ans--;

        System.out.println(ans);
    }

    static void recursiveFunction(int k, int value) {
        if (k == N + 1) {  // 부분 수열을 하나 완성 시킨 상태
            // value 가 S 랑 같은 지 확인하기
            if (value == S) {
                ans++;
            }
        } else {
            recursiveFunction(k + 1, value + arr[k]);
            recursiveFunction(k + 1, value);

        }
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        selected = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
