package boj.basicmath1;

/**
 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 A와 B가 주어진다. (0 < A,B < 1010000)
 *
 * 출력
 * 첫째 줄에 A+B를 출력한다.
 *
 * 예제 입력 1
 * 9223372036854775807 9223372036854775808
 * 예제 출력 1
 * 18446744073709551615
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BigInteger_10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int max = Math.max(a.length(), b.length());

        int[] arr1 = new int[max + 1];
        int[] arr2 = new int[max + 1];

        for(int i = a.length() - 1, idx = 0; i >= 0; i--, idx++) arr1[idx] = a.charAt(i) - '0';

        for(int i = b.length() - 1, idx = 0; i >= 0; i--, idx++) arr2[idx] = b.charAt(i) - '0';


        for(int i = 0; i < arr1.length - 1; i++) {
            int tmp = arr1[i] + arr2[i];
            arr1[i] = tmp % 10;
            if(tmp > 9) arr1[i + 1] += 1;
        }

        StringBuilder sb = new StringBuilder();

        if(arr1[arr1.length - 1] > 0) sb.append(arr1[arr1.length - 1]);
        for(int i = arr1.length - 2; i >= 0; i--) sb.append(arr1[i]);

        System.out.println(sb.toString());
    }
}
