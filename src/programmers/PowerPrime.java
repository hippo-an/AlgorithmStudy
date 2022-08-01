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

        int r = 1;
        for (int i = 3; i <= n; i += 2) {
            if (!memo[i]) {
                r++;
                for(int j=2*i;j<=n; j+=i) {
                    memo[j] = true;
                }
            }

        }


        return r;
    }
}
