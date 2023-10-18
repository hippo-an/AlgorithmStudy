package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class HumanComputerInteraction_16139_1 {
    private static int[][] arr = new int[200001][26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for (int i = 1; i <= str.length(); i++) {
            char c = str.charAt(i - 1);

            for (int j = 0; j < 26; j++) {
                final int add = j == c - 'a' ? 1 : 0;
                arr[i][j] = arr[i - 1][j] + add;
            }
        }

        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int idx = st.nextToken().charAt(0) - 'a';
            int from = Integer.parseInt(st.nextToken()) + 1;
            int to = Integer.parseInt(st.nextToken()) + 1;

            sb.append(arr[to][idx] - arr[from - 1][idx]).append("\n");
        }

        System.out.println(sb);
    }
}