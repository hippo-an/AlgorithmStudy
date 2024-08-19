package hobby.algorithm.simulation;

import java.io.*;
import java.util.*;

// cctv 최대 갯수 : 8 -> 모든 cctv 가능성 전부 확인 4^8 = 2^16
// 5번은 회전에 의미가 없다 trbl 전부


public class Surveillance_15683 {
    private static int[][] board = new int[10][10];
    private static int[][] sur = new int[10][10];
    // 하, 우, 상, 좌
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    private static int n, m;
    private static final List<Integer> cctv = new ArrayList<>();

    // x, y 가 array 를 벗어났는지 확인하기 위한 용도
    private static boolean outOfBound(int a, int b) {
        return a < 0 || a >= n || b < 0 || b >= m;
    }

    // dir 로 진행하며 감시가 가능한 부분에 대한 마크
    private static void upd(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (outOfBound(x, y) || sur[x][y] == 6) return;
            if (sur[x][y] != 0) continue;
            sur[x][y] = -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int blindSpot = 0;


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                // cctv 인덱스를 list 에 저장하는 이유는 cctv 의 인덱스를 얻고,
                // 개별 cctv 에 대한 모든 방향을 4진수를 통해서 확인하기 위해
                if (board[i][j] != 0 && board[i][j] != 6) {
                    cctv.add(i);
                    cctv.add(j);
                }

                // 문제 조건에 cctv 의 최소 갯수가 없기 때문에 안전하게 입력된 빈칸의 갯수로 맞춰둔다.
                if (board[i][j] == 0) {
                    blindSpot++;
                }
            }
        }

        // 1 << 0 00000001 = 1
        // 1 << 1 00000010 = 2
        // 1 << 2 00000100 = 4
        // 1 << 3 00001000 = 8

        // 1 << 2 * 0 00000001 = 1
        // 1 << 2 * 1 00000100 = 4
        // 1 << 2 * 2 00010000 = 16
        // 1 << 2 * 3 01000000 = 64


        for (int tmp = 0; tmp < (1 << (2 * (cctv.size() / 2))); tmp++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sur[i][j] = board[i][j];
                }
            }

            int brute = tmp;

            for (int i = 0; i < cctv.size(); i += 2) {
                int dir = brute % 4;
                brute /= 4;

                int x = cctv.get(i);
                int y = cctv.get(i + 1);

                if (board[x][y] == 1) {
                    upd(x, y, dir);
                } else if (board[x][y] == 2) {
                    upd(x, y, dir);
                    upd(x, y, dir + 2);
                } else if (board[x][y] == 3) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                } else if (board[x][y] == 4) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                    upd(x, y, dir + 2);
                } else if (board[x][y] == 5) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                    upd(x, y, dir + 2);
                    upd(x, y, dir + 3);
                }
            }

            int val = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (sur[i][j] == 0) {
                        val++;
                    }
                }
            }

            blindSpot = Math.min(blindSpot, val);

        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(blindSpot + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
