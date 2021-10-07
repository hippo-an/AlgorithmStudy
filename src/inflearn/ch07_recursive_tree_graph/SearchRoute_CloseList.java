package inflearn.ch07_recursive_tree_graph;

/**
 * 경로 탐색(인접리스트)
 * 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프
 * 로그램을 작성하세요. 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는
 * 1 2 3 4 5
 * 1 2 5
 * 1 3 4 2 5
 * 1 3 4 5
 * 1 4 2 5
 * 1 4 5
 * 총 6 가지입니다.
 * ▣ 입력설명
 * 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연
 * 결정보가 주어진다.
 * ▣ 출력설명
 * 총 가지수를 출력한다.
 * ▣ 입력예제 1
 * 5 9
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 3
 * 2 5
 * 3 4
 * 4 2
 * 4 5
 * ▣ 출력예제 1
 * 6
 */
// 정점의 갯수가 많을 경우 인접 리스트를 사용한다.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchRoute_CloseList {

    static List<ArrayList<Integer>> g;
    static int[] ch;
    static int n, m, answer = 0;

    public static void main(String[] args) {
        SearchRoute_CloseList main = new SearchRoute_CloseList();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        g = new ArrayList<ArrayList < Integer >>();

        for(int i = 0 ; i <= n; i++) {
            g.add(new ArrayList<Integer>());
        }

        ch = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            g.get(a).add(b);
        }

        ch[1] = 1;
        main.dfs(1);
        System.out.println(answer);

    }

    private void dfs(int v) {
        if(v == n) answer++;
        else {
            for (int nv : g.get(v)) {
                if(ch[nv] == 0) {
                    ch[nv] = 1;
                    dfs(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

}
