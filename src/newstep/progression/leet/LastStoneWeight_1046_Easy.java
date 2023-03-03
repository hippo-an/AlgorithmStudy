package newstep.progression.leet;

import java.util.PriorityQueue;

public class LastStoneWeight_1046_Easy {


    public static void main(String[] args) {
        LastStoneWeight_1046_Easy a = new LastStoneWeight_1046_Easy();
        a.lastStoneWeight(new int[]{5, 2, 3, 6, 1, 357, 3, 5, 47, 345, 7, 3, 457, 357});

    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int a : stones) {
            pq.offer(a);
        }
        while (pq.size() > 1) {
            pq.offer(pq.poll() - pq.poll());
        }

        return pq.poll();
    }
}
