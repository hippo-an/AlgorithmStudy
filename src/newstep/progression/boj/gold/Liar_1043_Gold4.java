package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Liar_1043_Gold4 {

    private static int n, m;
    private static int[] parent;
    private static List<List<Integer>> parties = new ArrayList<>();
    private static List<Integer> truthPeople = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        // union find 용 parent 배열 초기화
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        // 진실을 알고 있는 제이슨들 추가
        int e = 0;
        for (int i = 1; i <= k; i++) {
            e = Integer.parseInt(st.nextToken());
            truthPeople.add(e);
        }

        for (int i = 1; i < k; i++) {
            union(truthPeople.get(i - 1), truthPeople.get(i));
        }

        for (int i = 0; i <= m; i++) {
            parties.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            List<Integer> partyPeople = parties.get(i);

            for (int j = 0; j < p; j++) {
                Integer n1 = Integer.parseInt(st.nextToken());
                partyPeople.add(n1);
            }

            if (p <= 1) {
                continue;
            }

            for (int j = 0; j < p - 1; j++) {
                Integer n1 = partyPeople.get(j);
                Integer n2 = partyPeople.get(j + 1);
                union(n1, n2);
            }
        }

        int baseParent = find(e);
        if (baseParent == 0) {
            System.out.println(m);
            return;
        }

        int cnt = m;
        for (int i = 1; i <= m; i++) {
            List<Integer> partyPeople = parties.get(i);
            for (Integer person : partyPeople) {
                if (baseParent == find(person)) {
                    cnt--;
                    break;
                }
            }
        }

        System.out.println(cnt);
        br.close();
    }

    private static void union(Integer n1, Integer n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 == p2) {
            return;
        }

        if (p1 < p2) {
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
        }
    }

    private static int find(Integer n) {
        if (n == parent[n]) {
            return parent[n];
        }

        return parent[n] = find(parent[n]);
    }

}
