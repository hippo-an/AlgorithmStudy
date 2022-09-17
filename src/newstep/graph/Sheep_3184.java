package newstep.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Sheep_3184 {

    private static int R, C, sheep, wolf;
    private static char[][] graph;
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R + 1][C + 1];
        visited = new boolean[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            String s = br.readLine();
            for (int j = 1; j <= C; j++) {
                graph[i][j] = s.charAt(j - 1);
            }
        }

        int x = 0, y = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                char c = graph[i][j];

                if (!visited[i][j] && c != '#') {
                    sheep = 0;
                    wolf = 0;
                    dfs(i, j, c);
                    if (sheep > wolf) x += sheep;
                    else y += wolf;
                }
            }
        }

        System.out.println(x + " " + y);
    }

    private static void dfs(int x, int y, char c) {
        visited[x][y] = true;
        if (c == 'v') wolf++;
        else if (c == 'o') sheep++;

        for (int[] direction : dir) {
            int nx = x + direction[0];
            int ny = y + direction[1];

            if (nx < 1 || ny < 1 || nx > R || ny > C) continue;
            if (visited[nx][ny]) continue;
            if (graph[nx][ny] == '#') continue;
            dfs(nx, ny, graph[nx][ny]);
        }
    }
}
