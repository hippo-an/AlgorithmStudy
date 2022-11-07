package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Deck_10866_Silver4 {
    private static CustomDeck<Integer> deck = new CustomDeck<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push_front":
                    deck.pushFront(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deck.pushBack(Integer.parseInt(st.nextToken()));
                    break;
                case "front":
                    Integer front = deck.front();
                    sb.append(front == null ? -1 : front).append("\n");
                    break;
                case "back":
                    Integer back = deck.back();
                    sb.append(back == null ? -1 : back).append("\n");
                    break;
                case "size":
                    sb.append(deck.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deck.empty()).append("\n");
                    break;
                case "pop_front":
                    Integer popFront = deck.popFront();
                    sb.append(popFront == null ? -1 : popFront).append("\n");
                    break;
                case "pop_back":
                    Integer popBack = deck.popBack();
                    sb.append(popBack == null ? -1 : popBack).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    public static class CustomDeck<T> {
        private final List<T> elements;

        public CustomDeck() {
            this.elements = new LinkedList<>();
        }

        public void pushFront(T x) {
            elements.add(0, x);
        }

        public void pushBack(T x) {
            elements.add(x);
        }

        public T popFront() {
            if (this.elements.isEmpty()) return null;
            return elements.remove(0);
        }

        public T popBack() {
            if (this.elements.isEmpty()) return null;
            return elements.remove(elements.size() - 1);
        }

        public int size() {
            return this.elements.size();
        }

        public int empty() {
            if (this.elements.isEmpty()) return 1;
            return 0;
        }

        public T front() {
            if (this.elements.isEmpty()) return null;
            return this.elements.get(0);
        }

        public T back() {
            if (this.elements.isEmpty()) return null;
            return this.elements.get(size() - 1);
        }

    }
}
