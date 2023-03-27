package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InorderTraversal_22856_Gold4 {

    private static int N;
    private static List<List<Integer>> tree;
    private static int lastNode;
    private static int[] parents;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        parents = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            List<Integer> childs = tree.get(parent);
            childs.add(left);
            childs.add(right);

            if (left != -1) {
                parents[left] = parent;
            }

            if (right != -1) {
                parents[right] = parent;
            }

        }

        dfs(1);

        int move = 0;
        while (lastNode != 1) {
            move++;
            lastNode = parents[lastNode];
        }

        System.out.println((N - 1) * 2 - move);
        br.close();
    }

    private static void dfs(int n) {
        if (n == -1) {
            return;
        }

        List<Integer> elements = tree.get(n);

        Integer left = elements.get(0);
        Integer right = elements.get(1);

        dfs(left);
        lastNode = n;
        dfs(right);
    }
}
