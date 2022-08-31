package newstep.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Virus_2606 {

    private static int N, E, cnt;
    private static List<Integer>[] graph;
    private static boolean[] selected;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        selected = new boolean[N + 1];

        for (int i = 1; i <= E; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            graph[x].add(y);
            graph[y].add(x);
        }


        dfs(1);
        System.out.println(cnt - 1);
    }

    private static void dfs(int n) {
        cnt++;
        selected[n] = true;

        for (int x : graph[n]) {
            if (!selected[x]) {
                dfs(x);
            }
        }
    }
}
