package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrimeLeastCommonMultiple_21919_Silver3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());


        // 1. 소수 탐색
        Queue<Integer> prime = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (isPrime(arr[i])) {
                prime.add(arr[i]);
            }
        }
        if (prime.isEmpty()) System.out.println(-1);
        else {
            // 2. 최소 공배수 탐색
            long ans = prime.poll();
            while(!prime.isEmpty()) {
                int x = prime.poll();
                ans = lcm(Math.max(ans, x), Math.min(ans, x));
            }

            System.out.println(ans);
        }
    }

    private static long lcm(long max, long min) {
        return (max * min) / gcd(max, min);
    }

    private static long gcd(long max, long min) {
        if (max % min == 0) return min;
        return gcd(min, max % min);
    }

    private static boolean isPrime(int n) {
        for (int i = 2;i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
