package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RotatingQueue_1021_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        int count = 0;

        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int key = Integer.parseInt(st.nextToken());
            int index = 0;

            for (Integer element : deque) {
                if (element == key) {
                    break;
                }
                index++;
            }

            while (deque.getFirst() != key) {
                if (deque.size() / 2 >= index) {
                    deque.addLast(deque.pollFirst());
                } else {
                    deque.addFirst(deque.pollLast());
                }
                count++;
            }
            deque.pollFirst();
        }
        System.out.println(count);

        br.close();
    }
}
