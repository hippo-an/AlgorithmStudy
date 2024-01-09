package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Queue2_18258_4 {
    private static int[] cq = new int[2000009];
    private static int head, tail = 0;

    private static void push(int x) {
        cq[tail++] = x;
    }

    private static int pop() {
        return head == tail ? -1 : cq[head++];
    }

    private static int empty() {
        return head == tail ? 1 : 0;
    }

    private static int size() {
        return tail - head;
    }

    private static int front() {
        return head == tail ? -1 : cq[head];
    }

    private static int back() {
        return head == tail ? -1 : cq[tail - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop())
                            .append("\n");
                    break;
                case "size":
                    sb.append(size())
                            .append("\n");
                    break;
                case "empty":
                    sb.append(empty())
                            .append("\n");
                    break;
                case "front":
                    sb.append(front())
                            .append("\n");
                    break;
                case "back":
                    sb.append(back())
                            .append("\n");
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}
