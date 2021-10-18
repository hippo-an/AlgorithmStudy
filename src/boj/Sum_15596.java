package boj;

public class Sum_15596 {
    private long sum(int[] a) {
        long answer = 0l;
        for(int x : a) answer += x;
        return answer;
    }
}
