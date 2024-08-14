package hobby.algorithm.bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek_1697 {

    private static int[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        board = new int[100001];
        Arrays.fill(board, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        board[n] = 0;

        while (board[k] == -1) {
            int x = queue.poll();
            int[] s = {x + 1, x -1, x * 2};
            for (int nx : s) {
                if (nx < 0 || nx >= board.length) continue;
                if (board[nx] != -1) continue;
                queue.offer(nx);
                board[nx] = board[x] + 1;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(board[k] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
