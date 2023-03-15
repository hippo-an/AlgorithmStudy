package newstep.progression.programmers.level2;

public class PrimeCountInK {

    public static void main(String[] args) {
        PrimeCountInK primeCountInK = new PrimeCountInK();
        int solution = primeCountInK.solution(437674, 3);
        System.out.println(solution);

    }

    public int solution(int n, int k) {
        String nToK = nToK(n, k);
        int len = 0;

        int ans = 0;
        while (len < nToK.length()) {
            if (nToK.charAt(len) != '0') {
                StringBuilder sb = new StringBuilder();

                while (len < nToK.length() && nToK.charAt(len) != '0') {
                    sb.append(nToK.charAt(len));
                    len++;
                }

                if (!sb.toString().equals("")
                    && checkPrime(Long.parseLong(sb.toString()))) {
                    ans++;
                }
            } else {
                len++;
            }
        }

        return ans;
    }

    private boolean checkPrime(long val) {
        for (long i = 2; i * i <= val; i++) {
            if (val % i == 0) {
                return false;
            }
        }
        return val != 1;
    }

    private String nToK(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            sb.append(n % k);
            n = n / k;
        }

        return sb.reverse().toString();
    }

    public int solutionBp(int n, int k) {

        int ans = 0;
        String temp[] = Integer.toString(n, k).split("0");

        Loop : for(String t : temp) {
            if(t.length() == 0) continue;
            long a = Long.parseLong(t);
            if(a == 1) continue;
            for(int i=2; i<=Math.sqrt(a); i++)
                if(a%i == 0) continue Loop;

            ans++;
        }
        return ans;
    }
}
