package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class FamilyRoot_21276_Gold3 {

    private static int n, m;
    private static String[] human;
    static HashMap<String, Integer> map;
    static List<List<Integer>> list;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 석호촌에 살고 있는 사람의 수
        human = new String[n];
        inDegree = new int[n];

        // 사람들의 이름을 입력받아 정렬
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            human[i] = st.nextToken();
        }
        Arrays.sort(human);

        // 사람들의 이름에 인덱스 부여
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(human[i], i);
        }

        // 계보 정보를 저장할 list 생성
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        // 가문의 정보 입력받기
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int child = map.get(st.nextToken()); // 자손 인덱스
            int anc = map.get(st.nextToken()); // 조상 인덱스

            list.get(anc).add(child); // 조상이 자손을 가르킴
            inDegree[child]++; // 자손의 차수 세기
        }

        // 위상정렬
        topologySort();
        br.close();

    }

    static void topologySort() {
        Queue<Integer> q = new LinkedList<>(); // 위상정렬을 위한 큐
        List<Integer> root = new ArrayList<>(); // 시조들의 이름을 저장할 리스트

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                root.add(i);
                q.offer(i);
            }
        }

        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }

        // 위상정렬
        while (!q.isEmpty()) {
            int cur = q.poll();

            // cur 인덱스의 자식 조사
            for (int next : list.get(cur)) {
                if (--inDegree[next] == 0) {
                    children.get(cur).add(next);
                    q.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.size()).append("\n");

        for (int idx : root) {
            sb.append(human[idx]).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < n; i++) {
            sb.append(human[i]).append(" ").append(children.get(i).size()).append(" ");
            children.get(i).sort(null); // i인덱스의 자식을 오름차순으로 정렬
            for (int idx : children.get(i)) {
                sb.append(human[idx]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
