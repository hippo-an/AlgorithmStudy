package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BuildCity_21924_Gold4 {
    private static int N, M, answer;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];

        // 최초 노드에 대한 부모 노드 번호 추가
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 우선 순위 큐의 정렬에 따른 조건 추가
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (n1, n2) -> {
                if (n1.distance == n2.distance) {
                    return n1.nodeA - n2.nodeA;
                }
                return n1.distance - n2.distance;
            }
        );

        long ans = 0L;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            Node node = new Node(nodeA, nodeB, distance);
            pq.offer(node);
            ans += distance;
        }

        int edgeCount = 0;
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int nodeA = poll.nodeA;
            int nodeB = poll.nodeB;

            if (getParent(nodeA) != getParent(nodeB)) {
                unionParent(nodeA, nodeB);
                ans -= poll.distance;
                edgeCount++;
            }
        }

        if (edgeCount == N - 1) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }

        br.close();
    }

    // 재귀를 통해 부모를 찾아온다.
    private static int getParent(int n) {
        if (parent[n] == n) {
            return n;
        }
        return getParent(parent[n]);
    }

    private static void unionParent(int n1, int n2) {
        n1 = getParent(n1);
        n2 = getParent(n2);

        if (n1 < n2) {
            parent[n2] = n1;
        } else {
            parent[n1] = n2;
        }
    }


    public static class Node {
        int nodeA;
        int nodeB;
        int distance;

        public Node(int nodeA, int nodeB, int distance) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.distance = distance;
        }
    }

}
