package inflearn.ch09_greedy;

/**
 * 원더랜드(최소스패닝트리 : 프림, PriorintyQueue)
 * 원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.
 * 원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지
 * 도로는 폐쇄하려고 한다.
 * 아래의 그림은 그 한 예를 설명하는 그림이다.
 * 17
 * 15 15
 * 위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시
 * 를 연결하는 방법을 찾아낸 것이다.
 * ▣ 입력설명
 * 첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다. 다음 E개의
 * 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다. 이는 A번 도시와 B번
 * 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.
 * ▣ 출력설명
 * 모든 도시를 연결하면서 드는 최소비용을 출려한다
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Wonderland_Prim {
    static int answer;
    static int[] ch;
    static List<ArrayList<Node>> list = new ArrayList<>();

    public static void main(String[] args) {
        Wonderland_Prim main = new Wonderland_Prim();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i <= n; i++) list.add(new ArrayList<Node>());

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            list.get(a).add(new Node(b, cost));
            list.get(b).add(new Node(a, cost));
        }

        ch = new int[n + 1];
        main.solution(n);

        System.out.println(answer);
    }

    private void solution(int n) {

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int end = curr.n;

            if (ch[end] == 0) {
                ch[end]= 1;
                answer += curr.cost;
                for (Node x : list.get(end)) {
                    if (ch[x.n] == 0) {
                        pq.offer(new Node(x.n, x.cost));
                    }
                }
            }
        }

    }


    private static class Node {
        int n, cost;

        Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }
    }
}
