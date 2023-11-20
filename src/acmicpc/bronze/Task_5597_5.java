package acmicpc.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_5597_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[31];

        for (int i = 1; i <= 28; i++) {
            int a = Integer.parseInt(br.readLine());
            arr[a] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 30; i++) {
            if (arr[i] == 0) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }
}
