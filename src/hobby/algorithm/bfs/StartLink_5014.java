package hobby.algorithm.bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class StartLink_5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if (s == g) {
            bw.write("0\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        int[] arr = new int[f + 10];
        Arrays.fill(arr, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        arr[s] = 0;

        while (!queue.isEmpty() && arr[g] == -1) {
            int x = queue.poll();
            int[] dir = {x + u, x - d};
            for (int nx : dir) {
                if (nx <= 0 || nx > f) continue;
                if (arr[nx] != -1) continue;
                queue.offer(nx);
                arr[nx] = arr[x] + 1;
            }
        }

        if (arr[g] == -1) {
            bw.write("use the stairs");
        } else {
            bw.write(arr[g] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
