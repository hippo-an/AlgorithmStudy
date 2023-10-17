package project_euler;

/**
 * 400만 보다 작은 피보나치 수에 대해 짝수의 합은?
 *
 * 피보나치 수열 =>  1, 1, 2, 3, 5, 8, 13, 21, 34 ...
 * 위와 같이 F(n) = F(n-1) + F(n-2) 와 같다.
 * 여기서 짝수에 대한 규칙은 매 n 이 3의 배수인 경우이다.
 *
 * 짝수인 수를 나열해보면 2, 8, 34, 144 ...  와 같은데 이는
 * E(n) = 4 * E(n-1) + E(n-2) 와 같다.
 *
 */
public class Problem2 {
    final static int limit = 4_000_000;
    final static int first = 1;
    final static int second = 1;
    static int totalSum = 0;
    public static void main(String[] args) {
//        fibonacci(first, second);
//        System.out.println(totalSum);
        fibonacci();
    }

    private static int fibonacci(int n1, int n2) {
        int sum = n1 + n2;

        if (sum >= limit) {
            return n2;
        }
        if ((sum) % 2 == 0) {
            totalSum += sum;
        }

        return fibonacci(n2, sum);
    }

    private static void fibonacci() {
        int a = 1;
        int b = 1;
        int c = a + b;

        while (c < limit) {
            totalSum += c;
            a = b + c;
            b = c + a;
            c = a + b;
        }

        System.out.println(totalSum);
    }
}
