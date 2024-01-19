package acmicpc.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LoopGarden_6198_5 {
    private static int n;
    private static int[] heights;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        long result = countVisibleGardens();
        System.out.println(result);

        br.close();

    }
    static long countVisibleGardens() {
        long count = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // 현재 내 높이보다 낮은 빌딩은 내가 안보이니까 스택에서 꺼냄
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }
            count += stack.size();
            stack.push(i);
        }

        return count;
    }

}
