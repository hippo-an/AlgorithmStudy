package newstep.concept;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 1 - 2 - 3 - 4 - 7
   \    /   /
      5 - 6
 */
public class TopologySort {

    private static final int N = 7;
    private static final List<List<Integer>> graph = new ArrayList<>();
    private static int[] inDegree;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        initGraph();
        topologySort();
    }

    private static void topologySort() {
        Queue<Integer> q = new LinkedList<>();

        // 진입 차수가 0인 노드를 큐에 삽입
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");

            List<Integer> edges = graph.get(now);
            for (int i = 0; i < edges.size(); i++) {
                int edge = edges.get(i);
                inDegree[edge]--;
                if (inDegree[edge] == 0) {
                    q.offer(edge);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] != 0) {
                System.out.println("사이클이 발생했습니다.");
                return;
            }
        }

        System.out.println(sb.toString());
    }

    private static void initGraph() {
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        inDegree = new int[N + 1];

        graph.get(1).add(2);
        inDegree[2]++;
        graph.get(1).add(5);
        inDegree[5]++;
        graph.get(2).add(3);
        inDegree[3]++;
        graph.get(3).add(4);
        inDegree[4]++;
        graph.get(4).add(7);
        inDegree[7]++;
        graph.get(5).add(3);
        inDegree[3]++;
        graph.get(5).add(6);
        inDegree[6]++;
        graph.get(6).add(4);
        inDegree[4]++;

        // 사이클을 발생시키는 경우
//        graph.get(7).add(1);
//        inDegree[1]++;
    }

}
