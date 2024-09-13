package hobby.algorithm.simulation;

import java.io.*;
import java.util.*;

public class Sticker_18808 {
    static int n, m, k;
    static int[][] board;
    static boolean[] selected;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int r, c;
    static int[][] sticker;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[45][45];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            sticker = new int[r][c];

            for (int x = 0; x < r; x++) {
                st = new StringTokenizer(br.readLine());

                for (int y = 0; y < c; y++) {
                    sticker[x][y] = Integer.parseInt(st.nextToken());
                }
            }


            for (int rotate = 0; rotate < 4; rotate++) {
                boolean alreadyStick = false;
                for (int x = 0; x <= n - r; x++) {
                    if (alreadyStick) {
                        break;
                    }
                    for (int y = 0; y <= m - c; y++) {
                        // board[x][y] == 0 의 조건이 들어가는 경우 답이 다르게 나오는데,
                        // 스티커의 시작점이 반드시 0 일 필요는 없다.
                        // 스티커 모양에 따라 보드에 영향을 받기때문에,
                        // 여기에 board[x][y] == 0 이란 조건은 올바르지 않다.
                        if (stickable(x, y)) {
                            alreadyStick = true;
                            break;
                        }
                    }
                }

                if  (alreadyStick) {
                    break;
                }

                rotate();
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += board[i][j];
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // board (x, y)
    static boolean stickable(int x, int y) {

        // sticker index
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[x + i][y + j] == 1 && sticker[i][j] == 1) {
                    return false;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (sticker[i][j] == 1) {
                    board[x + i][y + j] = 1;
                }
            }
        }

        return true;
    }

    static void rotate() {
        int[][] temp = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp[i][j] = sticker[i][j];
            }
        }

        sticker = new int[c][r];

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                sticker[i][j] = temp[r - 1 - j][i];
            }
        }

        int t = r;
        r = c;
        c = t;
    }
}
