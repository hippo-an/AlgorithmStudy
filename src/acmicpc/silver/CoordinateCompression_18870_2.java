package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoordinateCompression_18870_2 {
    private static int N;
    private static int[] origin;
    private static int[] sorted;
    private static int[] index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        origin = new int[N];
        sorted = new int[N];
        index = new int[N];

        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
            sorted[i] = origin[i];
        }

        Arrays.sort(sorted);

        index[0] = sorted[0];
        int cnt = 0;
        int size = 1;

        for (int i = 1; i < N; i++) {
            if (sorted[i] != index[cnt]) {
                index[++cnt] = sorted[i];
                size++;
            }
        }


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(Arrays.binarySearch(index, 0, size, origin[i])).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}
