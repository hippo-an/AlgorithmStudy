package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Josephus_11866_Silver5 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= N; i++) que.offer(i);

        int cnt = 1;
        List<Integer> list = new ArrayList<>();

        while (!que.isEmpty()) {
            Integer poll = que.poll();
            if (cnt == K)  {
                cnt = 1;
                list.add(poll);
                continue;
            }

            que.offer(poll);
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < N; i++) {
            sb.append(list.get(i));
            if (i != N - 1) sb.append(", ");
            else sb.append(">");
        }

        System.out.println(sb);

    }
}
