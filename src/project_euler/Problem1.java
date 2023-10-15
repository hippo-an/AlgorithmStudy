package project_euler;

/**
 * 1000 이하의 숫자 중 3 혹은 5의 배수의 합 찾기
 */
public class Problem1 {
    public static final long target = 999;
    public static void main(String[] args) {
        final long ans = sumDivisibleBy(3) + sumDivisibleBy(5) - sumDivisibleBy(15);
        System.out.println(ans);
    }

    private static long sumDivisibleBy(final int n) {
        final long p = target/ n;
        return n * (p * (p + 1) / 2);
    }
}
