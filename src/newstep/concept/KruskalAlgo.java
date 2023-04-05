package newstep.concept;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalAlgo {

    private static final int n = 7;
    private static int[] parent;
    private static List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) {

        edges.add(new Edge(1, 1, 7, 12));  // 선택
        edges.add(new Edge(2, 1, 4, 28));
        edges.add(new Edge(3, 1, 2, 67));
        edges.add(new Edge(4, 1, 5, 17));  // 선택
        edges.add(new Edge(5, 2, 4, 24));  // 선택
        edges.add(new Edge(6, 2, 5, 62));
        edges.add(new Edge(7, 3, 5, 20));  // 선택
        edges.add(new Edge(8, 3, 6, 37));
        edges.add(new Edge(9, 4, 7, 13));  // 선택
        edges.add(new Edge(10, 5, 6, 45));
        edges.add(new Edge(11, 5, 7, 73));
        edges.add(new Edge(12, 6, 7, 23));  // 선택

        parent = new int[n + 1];

        // union find 를 위해 부모 노드 배열 최초 자기 자신으로 초기화
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        // 더 작은 간선의 가중치를 먼저 선택하기 위해 가중치를 기준으로 오름차순 정렬
        // 혹은 우선순위 큐 등의 자료구조를 활용하여 정렬 과정 생략 가능
        edges.sort(Comparator.comparingInt(o -> o.weight));

        int sum = 0;
        final List<Edge> selected = new ArrayList<>();

        // 모든 간선을 확인하며 사이클이 발생하지 않는 경우에만 해당 간선을 선택 (union)
        for (Edge edge : edges) {
            int p1 = find(edge.n1);
            int p2 = find(edge.n2);

            if (p1 != p2) {
                union(p1, p2);
                sum += edge.weight;
                selected.add(edge);
            }
        }

        System.out.println(sum);
        System.out.println(selected);
    }

    // 부모 노드의 값을 받아 바로 union 작업 수행
    private static void union(int p1, int p2) {
        if (p1 < p2) {
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
        }
    }

    // path compression 적용한 find
    private static int find(int n) {
        if (parent[n] == n) {
            return parent[n];
        }
        return parent[n] = find(parent[n]);
    }

    // 두개의 노드와 간선의 가중치를 가지는 엣지 클래스 정의
    private static class Edge {
        private final int id;
        private final int n1;
        private final int n2;
        private final int weight;

        public Edge(int id, int n1, int n2, int weight) {
            this.id = id;
            this.n1 = n1;
            this.n2 = n2;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{"
                + "id=" + id
                + ", weight=" + weight
                + '}';
        }
    }

}
