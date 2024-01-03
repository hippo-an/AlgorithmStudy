package acmicpc.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Anagram_1919_2 {
    private static final int[] arr = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f = br.readLine();
        String s = br.readLine();

        for (int i = 0; i < f.length(); i++) {
            arr[f.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']--;
        }
        int ans = 0;
        for (int a : arr) {
            ans += Math.abs(a);
        }

        System.out.println(ans);

        br.close();
    }
}
