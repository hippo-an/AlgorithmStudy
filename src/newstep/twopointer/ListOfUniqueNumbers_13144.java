package newstep.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ListOfUniqueNumbers_13144 {

    private static int N;
    private static int[] arr;
    private static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        selected = new boolean[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;
        for (int L = 1, R = 0; L <= N; L++) {
            while (R + 1 <= N && !selected[arr[R + 1]] ) {
                R++;
                selected[arr[R ]] = true;
            }

            ans += R - L + 1;
            selected[arr[L]] = false;
        }

        System.out.println(ans);
    }
}
