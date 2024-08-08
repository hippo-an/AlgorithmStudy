package hobby.datastructure.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Card2_2164 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while(queue.size() > 2) {
            queue.remove();
            queue.add(queue.remove());
        }

        if (queue.size() == 2) {
            queue.remove();
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(queue.poll().toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
