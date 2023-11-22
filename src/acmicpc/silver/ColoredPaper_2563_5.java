package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ColoredPaper_2563_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = 100;
        int blackSize = 10;
        boolean[][] board = new boolean[size][size];

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int xOff = Integer.parseInt(st.nextToken());
            int yOff = Integer.parseInt(st.nextToken());

            for (int x = xOff; x < xOff + blackSize; x++) {
                for (int y = yOff; y < yOff + blackSize; y++) {
                    board[x][y] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (board[i][j]) {
                    count++;
                }
            }
        }

        System.out.println(count);

        br.close();
    }
}
