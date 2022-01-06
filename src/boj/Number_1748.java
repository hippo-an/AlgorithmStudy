package boj;

/*
문제
1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.

1234567891011121314151617181920212223...

이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 100,000,000)이 주어진다.

출력
첫째 줄에 새로운 수의 자릿수를 출력한다.

예제 입력 1
5
예제 출력 1
5
예제 입력 2
15
예제 출력 2
21
예제 입력 3
120
예제 출력 3
252
 */

import java.io.*;
public class Number_1748 {

    public static void main(String[] args) throws IOException {
        Number_1748 main = new Number_1748();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        long cnt = 0;
        for (int i = 1; i < s.length(); i++) {
            cnt +=  i * 9L * Math.pow(10, i-1);
        }
        cnt += (Long.parseLong(s) - Math.pow(10, s.length() - 1) + 1) * s.length();

        System.out.println(cnt);
        br.close();
    }

    public void goodCase () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int start = 1, len = 1; start <= n; start *= 10, len++) {
            int end = start * 10 - 1;
            if (end > n) end = n;
            ans += len * (end - start + 1);
        }

        System.out.println(ans);
    }
}
