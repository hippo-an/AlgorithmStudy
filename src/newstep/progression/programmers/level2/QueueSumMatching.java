package newstep.progression.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class QueueSumMatching {

    public static void main(String[] args) {
        QueueSumMatching queueSumMatching = new QueueSumMatching();
        int ans = queueSumMatching.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2});
        System.out.println(ans);

    }
    public int solution(int[] queue1, int[] queue2) {
        long firstSum = 0;
        long secondSum = 0;

        Queue<Integer> firstQueue = new LinkedList<>();
        Queue<Integer> secondQueue = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            firstSum += queue1[i];
            secondSum += queue2[i];

            firstQueue.offer(queue1[i]);
            secondQueue.offer(queue2[i]);
        }

        if ((firstSum + secondSum) % 2 != 0) {
            return -1;
        }

        int answer = 0;
        while (firstSum != secondSum) {
            if (firstSum > secondSum) {
                Integer poll = firstQueue.poll();
                firstSum -= poll;
                secondSum += poll;
                secondQueue.offer(poll);
            } else {
                Integer poll = secondQueue.poll();
                firstSum += poll;
                secondSum -= poll;
                firstQueue.offer(poll);
            }

            answer++;
            if (answer > queue1.length * 3) {
                return -1;
            }
        }

        return answer;
    }

}
