package ezsw.kakao.k2021;

import java.util.ArrayList;
import java.util.List;

public class MinimizeSalesDrop {

    int[] s;
    List<List<Integer>> children = new ArrayList<>();
    int[][] cost = new int[300000][2];
    static final int INF = 987654321;

    public int solution(int[] sales, int[][] links) {

        s = sales;

        for (int i = 0; i < sales.length; i++) {
            children.add(new ArrayList<>());
        }

        for (int[] link : links) {
            children.get(link[0] - 1).add(link[1] - 1);
        }

        traversal(0);

        return Math.min(cost[0][0], cost[0][1]);
    }

    private void traversal(int node) {
        cost[node][0] = 0;
        cost[node][1] = s[node];

        if(children.get(node).isEmpty()) return;


        int extraCost = INF;
        for (int child : children.get(node)) {
            traversal(child);

            if(cost[child][0] < cost[child][1]) {
                cost[node][0] += cost[child][0];
                cost[node][1] += cost[child][0];
                extraCost = Math.min(extraCost, cost[child][1] - cost[child][0]);
            } else {
                cost[node][0] += cost[child][1];
                cost[node][1] += cost[child][1];
                extraCost = 0;
            }
        }

        cost[node][0] += extraCost;

    }
}
