package newstep.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {

    private static int N, ANS;
    private static int[] COL;


    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(sb.readLine());
        COL = new int[N + 1];

        recursiveFunction(1);

        System.out.println(ANS);
    }

    private static void recursiveFunction(int row) {
        if (row == N + 1) {
            ANS++;
        } else {
            for (int c = 1; c <= N; c++) {
                boolean possible = true;
                for (int i = 1; i <= row - 1; i++) {  // 0, 1, 2, 3, 4, 5, 6, 7, ...
                    if (attackable(row, c, i, COL[i])) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    COL[row] = c;
                    recursiveFunction(row + 1);
                    COL[row] = 0;
                }
            }
        }
    }
    private static boolean attackable(int r1, int c1, int r2, int c2) {
        if (r1 == r2 || c1 == c2) return true;
        else if (r1 + c1 == r2 + c2) return true;
        else return r1 - c1 == r2 - c2;
    }
}
