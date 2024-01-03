package acmicpc.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Strfry_11328_2 {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();

            arr = new int[26];

            for (int i = 0; i < first.length(); i++) {
                arr[first.charAt(i) - 'a']++;
                arr[second.charAt(i) - 'a']--;
            }

            boolean flag = false;

            for (int j : arr) {
                if (j != 0) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                System.out.println("Impossible");
            } else {
                System.out.println("Possible");
            }
        }


        br.close();
    }
}
