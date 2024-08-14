package hobby.algorithm.recursion;

import java.io.*;
import java.util.StringTokenizer;

public class Multiply_1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long result = powMod(a, b, c);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    // 해당 방식은 절차적인 접근법으로 o(b) 로 문제 해결이 가능하다.
    // 다만 일반적으로 1억이 1초의 연산시간을 가진다고 생각하면 문제 조건 자체가
    // 2^31 - 1 이므로 o(b) 연산으로는 100% 시간초과
    private static long powModTimeout(int a, int b, int c) {
        long val = 1;
        while (b-- > 0) {
            val = (val * a) % c;
        }
        return val;
    }

    // 재귀를 활용한 합의 공식
    // 2^1000 = 2^500 * 2^500 = 2^250 * 2^250 * 2^250 * 2*250 =
    // 2^125 * 2^125 * 2^125 * 2^125 * 2^125 * 2^125 * 2^125 * 2^125 =
    // 2^62 * 2 * 2^62 * 2 * 2^62 * 2 * 2^62 * 2 * 2^62 * 2 * 2^62 * 2
    // * 2^62 * 2 * 2^62 * 2 * 2^62 * 2 * 2^62 * 2 * 2^62 * 2 * 2^62 * 2
    // * 2^62 * 2 * 2^62 * 2 * 2^62 * 2 * 2^62 * 2 *
    private static long powMod(int a, int b, int c) {
        if (b == 1) {
            return a % c;
        }

        long v = powMod(a, b / 2, c);
        v = v * v % c;
        if (b % 2 == 0) {
            return v;
        }
        return v * a % c;
    }
}
