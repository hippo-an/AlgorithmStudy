package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RemoteController_1107_Gold5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[10];

        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= m; i++) {
                arr[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int min = Math.abs(n - 100);

        if (m == 10 || min == 0) {
            System.out.println(min);
        } else {
            // 0번 채널부터 999999번 채널까지 전부 탐색해본다 ( 범위는 50만 까지이지만 리모컨 채널 9번만 사용가능한 경우가 있기 때문에)
            for (int i = 0; i < 1000000; i++) {
                // 누른 버튼 횟수
                int len = check(i, arr);

                if (len > 0) {
                    // 위 아래 버튼을 눌러야 하는 횟수
                    int press = Math.abs(n - i);
                    min = Math.min(min, len + press);
                }
            }

            System.out.println(min);
        }

        br.close();
    }

    private static int check(int i, boolean[] arr) {
        if (i == 0) {
            if (arr[0]) {
                return 0;
            } else {
                return 1;
            }
        }

        int len = 0;

        while (i > 0) {
            if (arr[i % 10]) {
                return 0;
            }

            len += 1;
            i /= 10;
        }

        return len;
    }

}
