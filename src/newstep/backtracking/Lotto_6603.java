package newstep.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Lotto_6603 {
    private static StringBuilder sb = new StringBuilder();
    private static int k;
    private static List<Integer> arr;
    private static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ===
        while(true) {
            String testCase=br.readLine();
            if ("0".equals(testCase)) break;

            String [] input=testCase.split(" ");
            k = Integer.parseInt(input[0]);
            selected = new int[7];

            arr = new ArrayList<>();
            arr.add(0);
            for (int i = 1; i <= k; i++) {
                arr.add(Integer.parseInt(input[i]));
            }

            recursiveFunction(1, 0);
            sb.append("\n");
        }
        System.out.println(sb.toString());

        // ===

    }

    private static void recursiveFunction(int k, int val) {
        if (k == 7) {
            for (int i = 1; i <= 6; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = val + 1; i < arr.size(); i++) {
                selected[k] = arr.get(i);
                recursiveFunction(k + 1, i);
                selected[k] = 0;
            }
        }
    }
}
