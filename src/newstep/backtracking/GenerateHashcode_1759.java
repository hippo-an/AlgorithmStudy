package newstep.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출력형식에 주의하자
 * 입력과 출력을 잘 보고 실수하는 부분을 줄이자.
 * 전역에서 공통으로 사용되는 vc 와 cc 를 사용했는데 그렇게 되면 전체 카운트 관리가 안되기 때문에
 * 하나의 케이스마다 짝수와홀수를 확인하는 방법으로....
 * 배열을 활용하면 반복을 돌면서 카운트를 확인할 때 반복을 줄일 수 있지 않을까?!
 */
public class GenerateHashcode_1759 {

    private static int L, C;
    private static char[] arr, selected;

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();

        recursiveFunction(1, 0);

        System.out.println(sb.toString());
    }

    private static boolean isVowel(char x) {
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }

    private static void recursiveFunction(int k, int val) {
        if (k == L + 1) {
            int vc = 0, cc = 0;
            for (int i = 1; i <= L; i++) {
                if (isVowel(selected[i])) vc++;
                else cc++;
            }

            if (vc >= 1 && cc >= 2) {
                for (int i = 1; i <= L; i++) sb.append(selected[i]);
                sb.append('\n');
            }
        } else {
            for (int i = val + 1 ; i <= C; i++) {
                selected[k] = arr[i];
                recursiveFunction(k + 1, i);
                selected[k] = 0;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C + 1];
        selected = new char[L + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr, 1, C + 1);
    }
}
