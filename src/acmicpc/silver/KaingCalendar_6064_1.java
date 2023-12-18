package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// TODO : 중국인의 나머지 정리 학습해보기....ㅜㅜ
public class KaingCalendar_6064_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(solve(m, n, x, y))
                    .append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    // 중국인의 나머지 정리를 이용했다.
    // 나머지 연산으로 고민을 엄청하다가 결국 해법을 봤는데 사실 이해가 잘 된다.
    // 다른 방법이나 규칙을 찾아서 풀 수 있을 것 같았는데 모듈러 연산으로 간단하게 풀릴 것 같아 시도했다.
    // 이 부분에 대해서는 추후 더 찾아봐야겠다. 관련 키워드: 중국인의 나머지 정리, 유클리드 확장 함수
    private static int solve(int m, int n, int x, int y) {
        int lcm = lcm(m, n);

        for (int i = x; i <= lcm; i += m) {
            if ((i - y) % n == 0) {
                return i;
            }
        }
        return -1;
    }

    private static int lcm(int m, int n) {
        return m * n / gcd(Math.max(m, n), Math.min(m, n));
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
