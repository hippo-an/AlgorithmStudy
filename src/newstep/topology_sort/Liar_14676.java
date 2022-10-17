package newstep.topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Liar_14676 {
    private static int N, M, K;
    private static List<Integer>[] graph;
    private static int[] ind, cnt, sat;
    private static StringTokenizer st;
    private static boolean liarFlag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();
        ind = new int[N + 1];
        cnt = new int[N + 1];
        sat = new int[N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            ind[y]++;
        }

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == 1){
                // x 의 선행 건물들이 모두 지어졌는 지 확인하기
                if (sat[y] < ind[y]) liarFlag = true;
                cnt[y]++;
                // x 가 처음 지어진 것이라면 x가 영향을 주는 건물들에 "너희의 선행 건물 중 하나가 처음 지어졌어" 라고 알려주기
                if (cnt[y] == 1) {
                    for (int t: graph[y]) sat[t]++;
                }
            }
            else{
                // x 라는 건물이 한 개 이상 지어져 있는 지 확인하기
                if (cnt[y] == 0) liarFlag = true;
                cnt[y]--;
                // x 가 더 이상 남아있지 않다면, "너희의 선행 건물 중 하나가 사라졌어" 라고 알려주기
                if (cnt[y] == 0) {
                    for (int t: graph[y]) sat[t]--;
                }
            }
        }

        System.out.println(liarFlag ? "Lier!" : "King-God-Emperor");
    }
}
