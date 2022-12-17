package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LIS_11053_Silver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 배열 생성 및 동적 배열 생성
        int[] arr = new int[N + 1];
        int[] dy = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 동적 배열 채우기 - 재귀
//        for (int i = 1; i <= N; i++) {
//            recursiveFunction(arr, dy, i);
//        }

        // 동적 배열 채우기 - 반복문
        for (int i = 1; i <= N; i++) {
            // 자기 자신의 원소를 포함하는 경우는 반드시 들어가기 때문에 최소 1의 길이를 가진다.
            dy[i] = 1;

            for (int k = 1; k < i; k++) {
                if (arr[k] < arr[i]) {
                    dy[i] = Math.max(dy[i], dy[k] + 1);
                }
            }
        }

        // 최대 값 구하기
        int max = Integer.MIN_VALUE;
        for (int i = 1;i <= N;i ++) {
            max = Math.max(max, dy[i]);
        }
        System.out.println(max);
        br.close();
    }

    private static int recursiveFunction(int[] arr, int[] dy, int i) {
        if (dy[i] == 0) {
            dy[i] = 1;

            for (int k = 1; k < i; k++) {
                if (arr[k] < arr[i]) {
                    dy[i] = Math.max(dy[i], recursiveFunction(arr, dy, k) + 1);
                }
            }
        }
        return dy[i];
    }
}
