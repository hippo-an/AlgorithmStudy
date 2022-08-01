package newstep.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Operator_14888 {

    private static int N;
    private static int[] nums;
    private static int[] operators = new int[5];

    private static StringBuilder sb = new StringBuilder();

    private static int MAX = Integer.MIN_VALUE;
    private static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();

        recursiveFunction(1, nums[1]);

        sb.append(MAX).append("\n").append(MIN);

        System.out.println(sb.toString());
    }

    private static void recursiveFunction(int k, int value) {
        // 들어온 입력과 같은 경우
        if (k == N) {
            // min max update
            MIN = Math.min(value, MIN);
            MAX = Math.max(value, MAX);
        } else {
            for(int i = 1; i <= 4; i++) {
                if (operators[i] >= 1) {
                    operators[i]--;
                    recursiveFunction(k + 1, calculate(value, i, nums[k + 1]));
                    operators[i]++;
                }
            }
        }

    }

    private static int calculate(int operand1, int operator, int operand2) {
        if (operator == 1) return operand1 + operand2;
        else if (operator == 2) return operand1 - operand2;
        else if (operator == 3) return operand1 * operand2;
        else return operand1 / operand2;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }
    }
}
