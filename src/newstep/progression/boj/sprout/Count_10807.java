package newstep.progression.boj.sprout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Count_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) list[i] = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 1; i <= N; i++) if (list[i] == k) cnt++;
        System.out.println(cnt);
    }
}
