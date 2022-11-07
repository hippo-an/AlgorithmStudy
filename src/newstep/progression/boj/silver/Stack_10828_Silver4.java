package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Stack_10828_Silver4 {
    private static CustomStack<Integer> stack = new CustomStack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "top":
                    Integer top = stack.top();
                    sb.append(top == null ? -1 : top).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty()).append("\n");
                    break;
                case "pop":
                    Integer pop = stack.pop();
                    sb.append(pop == null ? -1 : pop).append("\n");
                    break;

            }
        }

        System.out.println(sb);
    }

    public static class CustomStack<T> {
        private final List<T> elements;
        private int nextIdx;

        public CustomStack() {
            this.elements = new LinkedList<>();
            this.nextIdx = 0;
        }

        public void push(T x) {
            elements.add(nextIdx, x);
            nextIdx++;
        }

        public T pop() {
            if (this.elements.isEmpty()) return null;

            return elements.remove(--nextIdx);
        }

        public int size() {
            return this.elements.size();
        }

        public int empty() {
            if (this.elements.isEmpty()) return 1;
            return 0;
        }

        public T top() {
            if (this.elements.isEmpty()) return null;
            return this.elements.get(nextIdx-1);
        }
    }
}
