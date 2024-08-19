package hobby.algorithm.sort;

import java.io.*;
import java.util.StringTokenizer;

public class MergeArray_11728 {
    static int[] arrA = new int[1_000_005];
    static int[] arrB = new int[1_000_005];
    static int[] arrC = new int[2_000_010];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }


        int idxA = 0;
        int idxB = 0;

        for (int i = 0; i < n + m; i++) {
            if (idxA == n) {
                arrC[i] = arrB[idxB++];
            } else if (idxB == m) {
                arrC[i] = arrA[idxA++];
            } else if (arrA[idxA] <= arrB[idxB]) {
                arrC[i] = arrA[idxA++];
            } else {
                arrC[i] = arrB[idxB++];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n + m; i++) {
            sb.append(arrC[i]).append(" ");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
