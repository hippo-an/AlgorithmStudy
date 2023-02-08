package newstep.progression.boj.awesome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Minsang_21922_Gold5 {

    private static int N, M;
    private static int[][] seat;
    private static boolean[][][] visited;
    private static boolean [][] check;
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seat = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][4];
        check = new boolean[N + 1][N + 1];

        Queue<Node> startSeats = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                Minsang_21922_Gold5.seat[i][j] = Integer.parseInt(st.nextToken());
                if (Minsang_21922_Gold5.seat[i][j] == 9) {
                    startSeats.add(new Node(i, j, -1));
                }
            }
        }

        bfs(startSeats);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (check[i][j]) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }

    private static void bfs(Queue<Node> startSeats) {

        Queue<Node> seats = new LinkedList<>();

        while (!startSeats.isEmpty()) {
            Node node = startSeats.remove();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                process(seats, x, y, i);
            }
            check[x][y] = true;
        }

        while (!seats.isEmpty()) {
            Node node = seats.remove();
            int x = node.x;
            int y = node.y;
            int direction = seat[x][y] != 0 || seat[x][y] != 9
                ? checkDirection(x, y, node.dir)
                : node.dir;

            process(seats, x, y, direction);
        }
    }

    private static int checkDirection(int x, int y, int dir) {
        int type = seat[x][y];

        if (type == 1) {
            if (dir == 1) {
                return 3;
            } else if (dir == 3) {
                return 1;
            }
        } else if (type == 2) {
            if (dir == 0) {
                return 2;
            } else if (dir == 2) {
                return 0;
            }
        } else if (type == 3) {
            if (dir == 0) {
                return 1;
            } else if (dir == 1) {
                return 0;
            } else if (dir == 2) {
                return 3;
            } else if (dir == 3) {
                return 2;
            }
        } else if (type == 4) {
            if (dir == 0) {
                return 3;
            } else if (dir == 1) {
                return 2;
            } else if (dir == 2) {
                return 1;
            } else if (dir == 3) {
                return 0;
            }
        }
        return dir;
    }

    private static void process(Queue<Node> seats, int x, int y, int direction) {
        int nx = x + dir[direction][0];
        int ny = y + dir[direction][1];
        if (nx < 1 || ny < 1 || nx > N || ny > M) {
            return;
        }
        if (visited[nx][ny][direction]) {
            return;
        }
        visited[nx][ny][direction] = true;
        check[nx][ny] = true;
        seats.add(new Node(nx, ny, direction));
    }

    static class Node {
        int x;
        int y;
        int dir;

        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

}
