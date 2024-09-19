package hobby.exercisebook.koi_elementary_school_140;

import java.io.*;
import java.util.StringTokenizer;

/*
1) x, y 의 축이나 방향이 뒤집혀서 나오는 경우 문제를 풀때 영향을 미치는지 생각해보고 문제를 풀자.
2) x2, y2 의 값이 포함되는 경우 원하는 칸을 초과해서 색칠하기 때문에 포함하지 않는 것이 중요하다.
 */
public class SquareAreaSum_2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[][] board = new boolean[105][105];

        for (int i = 1; i <= 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    if (!board[x][y]) {
                        board[x][y] = true;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 105; i++) {
            for (int j = 0; j < 105; j++) {
                if (board[i][j]) {
                    ans++;
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
