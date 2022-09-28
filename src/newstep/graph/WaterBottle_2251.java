package newstep.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WaterBottle_2251 {
    private static int[] max = new int[3];  // from 과 to 의 인덱스 접근을 위한 배열
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] possible;  // a가 0 일때 3에 남아있는 물의 높이들 - true 인 경우 a 가 0 일 때 남아있는 c 의 물 높이
    private static boolean[][][] visited;  // 이미 방문한 곳인지 확인

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = -0; i < 3; i++) max[i] = Integer.parseInt(st.nextToken());
        visited = new boolean[201][201][201];
        possible = new boolean[201];

        WaterBottle init = new WaterBottle(new int[]{0, 0, max[2]});
        bfs(init.state[0], init.state[1], init.state[2]);

        for (int i = 0; i <= 200; i++) {
            if (possible[i]) sb.append(i).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static void bfs(int a, int b, int c) {
        Queue<WaterBottle> Q = new LinkedList<>();
        Q.add(new WaterBottle(new int[]{a, b, c}));
        visited[a][b][c] = true;

        while (!Q.isEmpty()) {
            WaterBottle poll = Q.poll();

            if (poll.state[0] == 0) possible[poll.state[2]] = true;

            // 2중 루프를 돌면서 6가지 케이스에 대해 모두 탐색
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;  // from 과 to 가 같으면 물을 옮겨줄 수 없음

                    WaterBottle nBottle = poll.move(from, to);  // 물을 옮긴 후 새로운 상태의 물통의 높이들 (a, b, c) -> (a`, b`, c`)
                    if (!visited[nBottle.state[0]][nBottle.state[1]][nBottle.state[2]]) {
                        Q.add(nBottle);
                        visited[nBottle.state[0]][nBottle.state[1]][nBottle.state[2]] = true;
                    }
                }
            }
        }
    }

    private static class WaterBottle {
        int[] state;
        public WaterBottle (int[] state) {
            this.state = state;
        }

        public WaterBottle move(int from, int to) {
            // 0 - a, 1 - b, 2 - c
            int[] newState = new int[]{state[0], state[1], state[2]};
            if (newState[from] + newState[to] <= max[to]) {
                newState[to] = newState[from] + newState[to];
                newState[from] = 0;
            } else {
                newState[from] -= (max[to] - newState[to]);
                newState[to] = max[to];
            }
            return new WaterBottle(newState);
        }
    }
}
