package boj.basicmath1;

/**
 * 문제
 *
 *
 * 위의 그림과 같이 육각형으로 이루어진 벌집이 있다.
 * 그림에서 보는 바와 같이 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다.
 * 숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지
 * (시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오. 예를 들면, 13까지는 3개, 58까지는 5개를 지난다.
 *
 * 입력
 * 첫째 줄에 N(1 ≤ N ≤ 1,000,000,000)이 주어진다.
 *
 * 출력
 * 입력으로 주어진 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나는지 출력한다.
 *
 * 예제 입력 1
 * 13
 * 예제 출력 1
 * 3
 */

// 1 - 1 - 1
// 2 3 4 5 6 7 - 6 - 2
// 8 9 10 11 12 13 14 15 16 17 18 19 - 12 - 3
// 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 - 18 - 4

import java.io.*;

public class Honeycomb_2292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 1;
        int tmp = 2;

        if (n != 1) {
            while (tmp <= n) tmp += (cnt++ * 6);
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();

    }
}
