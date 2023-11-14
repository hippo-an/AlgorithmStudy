package acmicpc.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 9 개중 7개를 순서 없이 조합
public class SevenDwarf_2309_1 {
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr = new int[9];
    private static int sum = 0;
    private static int[] selected = new int[2];
    private static boolean finish;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        Arrays.fill(selected, -1);
        sum -= 100;
        find(0, 0);
        System.out.println(sb);
    }

    private static void find(int k, int start) {
        if (finish) {
            return;
        }

        if (k == 2) {
            if (arr[selected[0]] + arr[selected[1]] == sum) {
                for (int i = 0; i < 9; i++) {
                    if (i == selected[0] || i == selected[1]) {
                        continue;
                    }

                    sb.append(arr[i])
                            .append("\n");
                }
                finish = true;
            }

            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (selected[k] == -1) {
                selected[k] = i;
                find(k + 1, i + 1);
                selected[k] = -1;
            }
        }
    }
}
