package acmicpc.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class FindMin_11003_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            // 인덱스 추가
            while (!deque.isEmpty() && deque.peekFirst() < i - l + 1) {
                deque.pollFirst();
            }

            // 큰 값들은 삭제
            while (!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]) {
                deque.pollLast();
            }

            // 범위내 가장 작은 값이 남는다.
            deque.offerLast(i);

            if (!deque.isEmpty()) {
                result[i] = arr[deque.peekFirst()];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j : result) {
            sb.append(j).append(" ");
        }
        System.out.println(sb);

        br.close();
    }
}
