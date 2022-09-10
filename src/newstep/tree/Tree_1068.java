package newstep.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tree_1068 {

    private static int N, erased, root;
    private static List<Integer>[] child;
    private static int[] leaf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        child = new ArrayList[N];
        leaf = new int[N];

        for (int i = 0; i < N; i++) {
            child[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) root = i;
            else child[parent].add(i);
        }

        erased = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            if (child[i].contains(erased)) {
                child[i].remove(child[i].indexOf(erased));
            }
        }

        if (root != erased) dfs(root);
        System.out.println(leaf[root]);
    }

    private static void dfs(int x) {
        if (child[x].isEmpty()) leaf[x] = 1;
        for (int y : child[x]) {
            dfs(y);
            leaf[x] += leaf[y];
        }
    }
}
