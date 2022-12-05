package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BuyCard_11052_Silver1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] p = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        // i 개의 카드를 살 때 필요 한 최대 금액
        int[] dy = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            dy[i] = p[i];
            for (int k = 1; k < i; k++) {
                dy[i] = Math.max(dy[i], p[k] + dy[i - k]);
            }
        }

        System.out.println(dy[N]);
    }
}
