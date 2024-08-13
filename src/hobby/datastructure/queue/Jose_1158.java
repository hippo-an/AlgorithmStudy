package hobby.datastructure.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Jose_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =  new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder("<");

        Queue<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.offer(i);
        }

        while (!list.isEmpty()) {
            int cnt = k;
            while (cnt-- > 1) {
                list.offer(list.poll());
            }
            Integer pop = list.poll();
            sb.append(pop).append(list.isEmpty() ? "" : ", ");
        }
        sb.append(">");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}
