package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SweetPotatoGahui_21772_Gold5 {

    private static final char WALL = '#';
    private static final char GAHUI = 'G';
    private static final char SP = 'S';
    private static int score = 0;
    private static int R, C, T;
    private static char[][] map;
    private static final int[][] dir = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {0, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new char[R + 1][C + 1];
        int gahuiX = 0, gahuiY = 0;

        for (int i = 1; i<= R; i++) {
            String s = br.readLine();
            for (int j = 1; j <= C; j++) {
                map[i][j] = s.charAt(j - 1);

                if (map[i][j] == GAHUI) {
                    gahuiX = i;
                    gahuiY = j;
                }
            }
        }

        dfs(gahuiX, gahuiY, 0, 0);

        System.out.println(score);
        br.close();
    }

    private static void dfs(int x, int y, int cnt, int times) {
        if (times == T) {
            score = Math.max(score, cnt);
            return;
        }

        for (int i = 0; i <= 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx < 1 || ny < 1 || nx > R || ny > C) {
                continue;
            }

            if (map[nx][ny] == WALL) {
                continue;
            }

            if (map[nx][ny] == SP) {
                map[nx][ny] = '.';
                dfs(nx, ny, cnt + 1, times + 1);
                map[nx][ny] = SP;
            } else {
                dfs(nx, ny, cnt, times + 1);
            }
        }
    }
}
