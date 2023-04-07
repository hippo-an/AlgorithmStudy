package newstep.concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*

임계경로 - 모든 작업들의 선행과 후행 작업에 대해 고려하여, 가장 오랜시간이 걸리는 경로를 나타내는 것

 1 - 2 - 3 - 4 - 7
   \    /   /
      5 - 6

    여기서 각 간선마다 가중치가 존재한다고 하자.
    가중치가 존재하는 경우 1에서 7까지 임계경로를 확인하는 법은 역추적을 이용해서 확인할 수 있다.

 */
public class TopologySortCriticalPath {
    private static final int N = 7;
    // 연결 요소 그래프
    private static final List<List<ToEdge>> graph = new ArrayList<>();

    // 역추적을 위한 reverseGraph
    private static final List<List<ToEdge>> reverseGraph = new ArrayList<>();

    // 진입 차수
    private static int[] inDegree;

    // 각 노드별 임계치
    private static int[] result;

    // 역추적 시 방문 여부를 확인하기 위한 배열
    private static boolean[] visited;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        initGraph();
        topologySort();
        backTracking();
    }

    private static void backTracking() {
        Queue<Integer> q = new LinkedList<>();

        // 마지막 노드인 7을 역추적의 시작 노드로 삽입
        q.offer(7);
        visited[7] = true;
        sb.append("7").append(" -> ");

        while (!q.isEmpty()) {
            int now = q.poll();
            List<ToEdge> edges = reverseGraph.get(now);

            for (ToEdge edge : edges) {
                int from = edge.to;
                int weight = edge.weight;

                // 이미 구해놓은 임계치를 가지고 역산하여 그래프 추적
                if (result[from] + weight == result[now]) {
                    sb.append("(").append(weight).append(")").append(" -> ")
                      .append(from).append(" -> ");

                    if (!visited[from]) {
                        q.offer(from);
                        visited[from] = true;
                    }
                }
            }
        }

        // 7 -> (11) -> 4 -> (10) -> 6 -> (11) -> 5 -> (6) -> 1 ->
        System.out.println(sb);
    }

    private static void topologySort() {
        Queue<Integer> q = new LinkedList<>();

        // 진입 차수가 0인 노드 번호를 큐에 삽입
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int now = q.poll();
            List<ToEdge> edges = graph.get(now);

            for (ToEdge toEdge : edges) {
                int to = toEdge.to;
                int weight = toEdge.weight;

                // 임계치 업데이트
                result[to] = Math.max(result[now] + weight, result[to]);

                // 새롭게 진입차수가 0이 된 노드를 큐에 삽입
                if (--inDegree[to] == 0) {
                    q.offer(to);
                }
            }
        }

        // [0, 0, 3, 14, 27, 6, 17, 38]
        System.out.println(Arrays.toString(result));
    }

    private static void initGraph() {
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        inDegree = new int[N + 1];
        result = new int[N + 1];
        visited = new boolean[N + 1];

        graph.get(1).add(new ToEdge(2, 3));
        reverseGraph.get(2).add(new ToEdge(1, 3));
        inDegree[2]++;

        graph.get(1).add(new ToEdge(5, 6));
        reverseGraph.get(5).add(new ToEdge(1, 6));
        inDegree[5]++;

        graph.get(2).add(new ToEdge(3, 5));
        reverseGraph.get(3).add(new ToEdge(2, 5));
        inDegree[3]++;

        graph.get(3).add(new ToEdge(4, 7));
        reverseGraph.get(4).add(new ToEdge(3, 7));
        inDegree[4]++;

        graph.get(4).add(new ToEdge(7, 11));
        reverseGraph.get(7).add(new ToEdge(4, 11));
        inDegree[7]++;

        graph.get(5).add(new ToEdge(3, 8));
        reverseGraph.get(3).add(new ToEdge(5, 8));
        inDegree[3]++;

        graph.get(5).add(new ToEdge(6, 11));
        reverseGraph.get(6).add(new ToEdge(5, 11));
        inDegree[6]++;

        graph.get(6).add(new ToEdge(4, 10));
        reverseGraph.get(4).add(new ToEdge(6, 10));
        inDegree[4]++;

    }

    private static class ToEdge {
        int to;
        int weight;

        public ToEdge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}