package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort_2750 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tmp = 0;
        StringBuilder sb = new StringBuilder();
        // selection sort
        for( int i = 0; i < n; i++) {

            for(int j = i + 1; j < n; j++) {
                if(arr[i] > arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
