package hobby.algorithm.bfs;

import java.io.*;
import java.util.StringTokenizer;

public class TermProject_9466 {

    private static int n, cnt;
    private static int[] visited;
    private static int[] arr;
    private static final int CYCLE_IN = -1;

    static boolean[] visitedDfs;
    static boolean[] finishedDfs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 5];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 순환이 일어나는 친구들에 대해서만 팀이된다.
            // 자신이 자신을 가르킬 수 있다.
            // 2차원 배열에서 돌아다닌다고 생각해보자
            // 행은 각각의 번호를 가진 친구들
            // 열은 해당 친구부터 이어지는 전체 리스트 목록?

            // 0 - 사이클 포함 안함
            // -1 - 사이클 포함
            // 1 ~ 해당 사이클의 시작점
            visited = new int[n + 5];
            visitedDfs = new boolean[n + 5];
            finishedDfs = new boolean[n + 5];
            cnt = n;

            for (int i = 1; i <= n; i++) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }

            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }


    // bfs 의 경우 외부 루프가 O(n) 그리고 각 학생에 대한 bfs O(n)으로
    // 최악의 경우 O(n^2) 이다.
    private static void bfs(int node) {
        visited[node] = node;
        int cur = node;
        while (true) {
            cur = arr[cur];
            if (visited[cur] == CYCLE_IN) {
                // 이미 사이클에 포함된 애가 있으니 해당 사이클은 만들어 질 수 없음
                return;
            } else if (visited[cur] == node) {
                break;
            }

            visited[cur] = node;
        }

        while (visited[cur] != CYCLE_IN) {
            visited[cur] = CYCLE_IN;
            cur = arr[cur];
            cnt--;
        }
    }

    // 노드 탐색 및 사이클 탐지
    private static void dfs(int node) {
        visitedDfs[node] = true;
        int next = arr[node];

        if (!visitedDfs[next]) {
            dfs(next);
        } else if (!finishedDfs[next]) {
            // 방문은 했지만 끝나지 않았다는 것은 탐색중인 경로에 방문한 노드를 다시 만났다는 의미
            // 다음 노드 부터 현재 노드 이전까지 순회하며 count 감소
            for (int i = next; i != node; i = arr[i]) {
                cnt--;
            }
            cnt--; // 현재 노드 포함
        }

        finishedDfs[node] = true;
    }
}
