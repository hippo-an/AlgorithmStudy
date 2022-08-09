package programmers;

public class PowerPrime {

    public static void main(String[] args) {

        PowerPrime powerPrime = new PowerPrime();

        System.out.println(powerPrime.solution(10));
        System.out.println(powerPrime.solution(5));
    }
    private static boolean[] memo;


    public int solution(int n) {
        memo = new boolean[n + 1];

        memo[0] = memo[1] = true;

        int r = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!memo[i]) {
                for(int j=i*i;j<=n; j+=i) {
                    memo[j] = true;
                }
            }
        }

        for (boolean b : memo) {
            if (!b) r++;
        }


        return r;
    }
}
