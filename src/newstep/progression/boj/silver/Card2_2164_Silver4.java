package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Card2_2164_Silver4 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1;i <= N; i++) {
            que.offer(i);
        }

        while (que.size() > 1) {
            Integer x = que.poll();

            Integer y = que.poll();
            que.offer(y);
        }

        System.out.println(que.peek());
    }
}
