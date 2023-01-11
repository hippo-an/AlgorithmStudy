package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeDiameter_1167_Gold2 {

    private static int ans = Integer.MIN_VALUE;
    private static int v;
    private static int leafIdx;
    private static List<Integer[]>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        v = Integer.parseInt(br.readLine());

        graph = new List[v + 1];

        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());

            while (true) {
                int node = Integer.parseInt(st.nextToken());

                if (node == -1) {
                    break;
                }

                int weight = Integer.parseInt(st.nextToken());
                graph[idx].add(new Integer[]{node, weight});
            }
        }

        dfs(1, 0, 0);
        dfs(leafIdx, 0, 0);

        System.out.println(ans);
        br.close();
    }

    private static void dfs(int i, int prev, int sum) {

        for (Integer[] element : graph[i]) {
            if (element[0] != prev) {

                if (ans < sum + element[1]) {
                    ans = sum + element[1];
                    leafIdx = element[0];
                }

                dfs(element[0], i, sum + element[1]);
            }
        }

    }

}
