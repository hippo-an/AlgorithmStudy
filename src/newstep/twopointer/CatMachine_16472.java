package newstep.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CatMachine_16472 {

    private static int N, cnt = 0;

    private static int[] selected = new int[26];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String s = br.readLine();

        int len = s.length(), ans = 0;
        for (int R = 0, L = 0; R < len; R++) {
            selected[s.charAt(R) - 'a']++;
            if (selected[s.charAt(R) - 'a'] == 1)  cnt++;

            // 불가능하면, 가능할 때까지 L을 이동
            while (cnt > N) {
                char x = s.charAt(L++);
                selected[x - 'a']--;
                if (selected[x - 'a'] == 0)  // 인식해야 하는 알파벳에서 빠지는 순간
                    cnt--;
            }

            // 정답 갱신
            ans = Math.max(ans, R - L + 1);
        }

        System.out.println(ans);

    }
}
