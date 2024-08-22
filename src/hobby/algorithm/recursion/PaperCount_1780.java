package hobby.algorithm.recursion;

import java.io.*;
import java.util.StringTokenizer;

public class PaperCount_1780 {
    private static int[][] arr;
    private static int zeroCount = 0;
    private static int oneCount = 0;
    private static int minusCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 5][n + 5];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 0, n);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(minusCount + "\n");
        bw.write(zeroCount + "\n");
        bw.write(oneCount + "\n");
        bw.flush();
        bw.close();
        br.close();

    }

    private static void recursive(int r, int c, int n) {

        if (check(r, c, n)) {
            int sv = arr[r][c];

            if (sv == -1) {
                minusCount++;
            } else if (sv == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
            return;
        }

        int newNum = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                recursive(r + i * newNum, c + j * newNum, newNum);
            }
        }
    }

    private static boolean check(int r, int c, int n) {
        int sv = arr[r][c];

        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (arr[i][j] != sv) {
                    return false;
                }
            }
        }

        return true;
    }
}
