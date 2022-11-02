package newstep.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Plus1236_15991_Silver1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] arr = new long[100000 + 1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 2;
        arr[4] = 3;
        arr[5] = 3;
        arr[6] = 6;

        for (int i = 7; i <= 100000; i++) {
            arr[i] = (arr[i - 2] + arr[i - 4] + arr[i - 6]) % 1000000009;
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(arr[Integer.parseInt(br.readLine())])
                    .append("\n");
        }

        System.out.println(sb);
    }
}
