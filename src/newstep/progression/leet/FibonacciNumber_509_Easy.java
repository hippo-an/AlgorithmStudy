package newstep.progression.leet;

public class FibonacciNumber_509_Easy {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dy = new int[30];
        dy[0] = 1;
        dy[1] = 1;

        for (int i = 2; i < n; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }

        return dy[n - 1];
    }
}
