package newstep.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cousin_9489 {
    private static StringTokenizer st;
    private static final StringBuilder sb = new StringBuilder();

    private static int N, K;
    private static int[] nums, par;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            initInput(br);
            if (N == 0 && K == 0) break;

            int idx = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
                if (nums[i] == K) idx = i;
            }

            // 각 노드의 부모 노드 인덱스를 계산하자. 루트 노드가 1번 노드임을 주의하라.
            // 편의상 0번 정점의 부모를 -1 로 하자.
            par[0] = -1;
            par[1] = 0;

            // last := 이번에 자식 정점들을 찾을 노드의 인덱스
            // Hint) 사촌 := 부모의 부모는 동일하나 부모는 다른 정점의 개수
            // Hint) par 배열을 가득 채워보자.

            for (int i = 2,  last = 0; i <= N; i++) {
                if (nums[i-1] + 1 < nums[i]) last++;
                par[i] = last;
            }

            int cnt = 0;

            for (int i = 1; i <= N; i++) {
                if (par[par[i]] == par[par[idx]] && par[i] != par[idx]) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    private static void initInput(BufferedReader br) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        par = new int[N + 1];
    }
}
