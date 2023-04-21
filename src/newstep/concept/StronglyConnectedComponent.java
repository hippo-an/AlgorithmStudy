package newstep.concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedComponent {

    public static final int SIZE = 8;
    private static int[] lowLinks;
    private static int id = 0;
    private static Stack<Integer> stack;
    private static List<List<Integer>> graph;
    private static boolean[] finished;
    private static List<List<Integer>> scc;

    public static void main(String[] args) {
        lowLinks = new int[SIZE + 1];
        stack = new Stack<>();
        graph = new ArrayList<>();
        finished = new boolean[SIZE + 1];
        scc = new ArrayList<>();

        for (int i = 0; i <= SIZE; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2);
        graph.get(2).add(3);
        graph.get(3).add(1);
        graph.get(2).add(4);
        graph.get(4).add(5);
        graph.get(5).add(6);
        graph.get(6).add(7);
        graph.get(7).add(8);
        graph.get(8).add(5);

        for (int i = 1; i <= SIZE; i++) {
            if (lowLinks[i] == 0) {
                dfs(i);
            }
        }
        System.out.println("=== Low Link Id ===");
        System.out.println(Arrays.toString(lowLinks));

        System.out.println("=== SCC ===");
        for (List<Integer> list : scc) {
            System.out.println(list);
        }

    }

    public static int dfs(int v) {
        System.out.println("this is vertex : " + v);
        // 노드에 고유한 번호를 부여
        lowLinks[v] = ++id;

        // 링크 id 초기화
        int linkId = lowLinks[v];

        // 스택에 정점을 넣어 추후 연결 요소의 확인에 사용한다.
        stack.push(v);

        // 인접 노드 탐색
        List<Integer> nodes = graph.get(v);
        for (Integer node : nodes) {
            // 인접 노드가 아직 방문하지 않은 노드라면
            if (lowLinks[node] == 0) {
                // 재귀 호출을 통해 가장 낮은 링크 id 를 찾는다.
                linkId = Math.min(linkId, dfs(node));
            } else if (!finished[node]) {
                // 방문했지만 아직 재귀 호출이 끝나지 않은 경우
                linkId = Math.min(linkId, lowLinks[node]);
            }
        }

        // 가장 작은 링크 id 가 자기 자신이라면 연결 요소를 찾은 것이다.
        if (linkId == lowLinks[v]) {
            List<Integer> connectedComponent = new ArrayList<>();
            while (true) {
                int t = stack.pop();
                connectedComponent.add(t);
                lowLinks[t] = linkId;
                finished[t] = true;
                if (t == v) {
                    break;
                }
            }
            scc.add(connectedComponent);
        }

        return linkId;
    }
}
