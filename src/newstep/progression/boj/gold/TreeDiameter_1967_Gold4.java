package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeDiameter_1967_Gold4 {

    private static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer[]>[] tree = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree[f].add(new Integer[]{t, w});
            tree[t].add(new Integer[]{f, w});
        }

        for (int i = 1; i <= n; i++) {
            dfs(tree, i, 0, 0);
        }

        System.out.println(ans);
        br.close();
    }

    private static void dfs(List<Integer[]>[] tree, int from, int prev, int sum) {

        for (Integer[] element : tree[from]) {
            if (element[0] != prev) {
                dfs(tree, element[0], from, sum + element[1]);
            }
        }

        if (sum > ans) {
            ans = sum;
        }
    }
}
