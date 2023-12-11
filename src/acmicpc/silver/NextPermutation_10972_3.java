package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NextPermutation_10972_3 {
    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (hasNextPermutation()) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
        br.close();
    }

    // 조건을 만족하는 다음 순열을 찾는다.
    private static boolean hasNextPermutation() {
        int i = arr.length - 1;

        // 1. A[i-1] < A [i]를 만족하는 가장 큰 i를 찾는다.
        while (i > 0 && arr[i - 1] > arr[i]) {
            i--;
        }

        if (i == 0) {
            return false;
        }
            
        // 2. j >= i 이면서 A[j] > A [i-1]을 만족하는 가장 큰 j를 찾는다.
        int j = arr.length - 1;
        while (j >= i - 1 && arr[i - 1] >= arr[j]) {
            j--;
        }

        // 3. A[i-1] 과 A[j] 를 swap
        swap(i - 1, j);

        // 4. A[i] 부터 마지막 인덱스까지 순열을 뒤집는다.
        j = arr.length - 1;
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }

    private static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}