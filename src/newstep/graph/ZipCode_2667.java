package newstep.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class ZipCode_2667 {

    private static int N, gnt;
    private static int[][] graph;
    private static boolean[][] selected;
    private static List<Integer> ans = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        selected = new boolean[N + 1][N + 1];

        String s;
        for (int x = 1; x <= N; x ++) {
            s = br.readLine();
            for (int y = 1; y <= N; y++) {
                graph[x][y] = s.charAt(y - 1) - '0';

            }
        }


        for (int x = 1, idx = 0; x <= N; x ++) {
            for (int y = 1; y <= N; y++) {
                if (graph[x][y] == 1 && !selected[x][y]) {
                    gnt = 0;
                    dfs(x, y);
                    ans.add(gnt);
                }
            }
        }

        Collections.sort(ans);

        sb.append(ans.size()).append("\n");
        for (int cnt : ans) sb.append(cnt).append("\n");
        System.out.println(sb.toString());
    }

    private static void dfs(int x, int y) {
        selected[x][y] = true;
        gnt++;
        if (x + 1 <= N && graph[x+1][y] == 1 && !selected[x+1][y]) dfs(x+1, y);
        if (graph[x-1][y] == 1 && !selected[x-1][y]) dfs(x-1, y);
        if (y + 1 <= N && graph[x][y+1] == 1 && !selected[x][y+1]) dfs(x, y+1);
        if (graph[x][y-1] == 1 && !selected[x][y-1]) dfs(x, y-1);
    }
}
