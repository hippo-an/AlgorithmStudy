package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LightBulb_21918_Bronze2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1;i <= M;i ++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            process(arr, a, x, y);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1;i <= N; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }

    private static void process(int[] arr, int a, int x, int y) {
        if (a == 1) {
            arr[x] = y;
        } else if (a == 2) {
            for (int i = x; i <= y; i++) {
                arr[i] = arr[i] == 1 ? 0 : 1;
            }
        } else if (a == 3) {
            for (int i = x; i <= y; i++) {
                arr[i] = 0;
            }
        } else {
            for (int i = x; i <= y; i++) {
                arr[i] = 1;
            }
        }
    }
}
