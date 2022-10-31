package newstep.progression.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BodyFrame_7568_Silver5 {
    private static int[][] arr;
    private static int[] result;
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][2];
        result = new int[N + 1];

        for (int i = 1;i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1;i <= N; i++) {
            int[] a = arr[i];
            int cnt = 1;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (a[0] < arr[j][0] && a[1] < arr[j][1]) cnt++;
            }

            sb.append(cnt).append(" ");
        }

        System.out.println(sb);
    }
}
