package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Josepus_1158_Silver4 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder("<");

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int idx = K - 1;
        while (!list.isEmpty()) {
            Integer remove = list.remove(idx);
            idx = (idx + K - 1) % Math.max(list.size(), 1);
            sb.append(remove).append(list.isEmpty() ? "" : ", ");
        }

        sb.append(">");
        System.out.println(sb);
        br.close();
    }
}
