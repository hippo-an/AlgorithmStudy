package newstep.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StepUp_2579_Silver3 {
    private static int[] dx;
    private static int[] dy;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dx = new int[N + 1];
        dy = new int[N + 1];

        arr = new int[N + 1];
        for (int i = 1;i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dx[1] = 1;
        dx[2] = 1;
        dy[2] = 1;

        for (int i = 3;i <= N; i++) {
            dx[i] = dy[i - 1];
            dy[i] = dx[i - 2] + dy[i - 2];
        }

        System.out.println();

    }
}
