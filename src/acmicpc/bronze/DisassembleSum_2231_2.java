package acmicpc.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 분해합을 통해서 N 이 되는 숫자 중 가장 작은 최적화 문제
public class DisassembleSum_2231_2 {
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        int length = s.length();

        for (int i = n - length * 9; i < n; i++) {
            int sum = i + get(i);
            if (sum == n) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }

    private static int get(int i) {
        int ret = 0;
        while (i != 0) {
            ret += (i % 10);
            i /= 10;
        }
        return ret;
    }
}
