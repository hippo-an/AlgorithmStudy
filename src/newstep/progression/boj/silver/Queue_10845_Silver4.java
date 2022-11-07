package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Queue_10845_Silver4 {

    private static CustomQueue<Integer> queue = new CustomQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            switch (command) {
                case "push":
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "front":
                    Integer front = queue.front();
                    sb.append(front == null ? -1 : front).append("\n");
                    break;
                case "back":
                    Integer back = queue.back();
                    sb.append(back == null ? -1 : back).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.empty()).append("\n");
                    break;
                case "pop":
                    Integer pop = queue.pop();
                    sb.append(pop == null ? -1 : pop).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    public static class CustomQueue<T> {
        private final List<T> elements;

        public CustomQueue() {
            this.elements = new LinkedList<>();
        }

        public void push(T element) {
            elements.add(element);
        }

        public T pop() {
            if (this.elements.isEmpty()) return null;
            return this.elements.remove(0);
        }

        public int size() {
            return this.elements.size();
        }

        public int empty() {
            return this.elements.isEmpty() ? 1 : 0;
        }

        public T front() {
            if (this.elements.isEmpty()) return null;
            return this.elements.get(0);
        }

        public T back() {
            if (this.elements.isEmpty()) return null;
            return this.elements.get(this.elements.size() - 1);
        }
    }
}
