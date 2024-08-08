package hobby.datastructure.deque;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SpinningQueue_1021 {
    private static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        Deque<Integer> deq = new ArrayDeque<>();
        m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            deq.addLast(i);
        }

        st = new StringTokenizer(br.readLine());

        int count = 0;
        while (st.hasMoreTokens()) {
            int s = Integer.parseInt(st.nextToken());
            int idx = 0;
            for (Integer e : deq) {
                if (e == s) {
                    break;
                }
                idx++;
            }


            while(deq.getFirst() != s) {
                if (deq.size() / 2 >= idx)  {
                    deq.addLast(deq.pollFirst());
                } else {
                    deq.addFirst(deq.pollLast());
                }
                count++;
            }

            deq.removeFirst();
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
        br.close();

    }

    private static class Deq {
        private final int[] deq;
        private int  head, tail, size;

        public Deq(int n) {
            this.head = 0;
            this.tail = 0;
            this.deq = new int[n];
        }

        private int indexOf(int n) {
            for (int i = head; i < tail; i++) {
                if (deq[i] == n) return i - head;
            }
            return -1;
        }
        private int size() {
            return size;
        }

        private void pushFront(int n) {
            size++;
            deq[--head] = n;
        }

        private void pushBack(int n) {
            size++;
            deq[tail++] = n;
        }

        private int popFront(){
            size--;
            return deq[head++];
        }

        private int popBack(){
            size--;
            return deq[tail-- - 1];
        }

        private int front() {
            return deq[head];
        }

        private int rightSpin() {
            pushFront(popBack());
            return front();
        }

        private int leftSpin() {
            pushBack(popFront());
            return front();
        }


        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = head; i < tail; i++) {
                sb.append(deq[i]).append(" ");
            }
            return sb.toString();
        }
    }
}
