package newstep.progression.programmers.level1;

import java.util.Stack;

public class BurgerMaker {
    public static void main(String[] args) {
        BurgerMaker burgerMaker = new BurgerMaker();
        System.out.println(burgerMaker.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
    }
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);
            // 조건에 맞는다면 4개를 pop 한다.

            if (stack.size() >= 4) {
                int b1 = stack.pop();  // 1
                int b2 = stack.pop();  // 3
                int b3 = stack.pop();  // 2
                int b4 = stack.pop();  // 1

                if (b1 == 1 && b2 == 3&& b3 == 2&& b4 == 1) {
                    answer++;
                } else {
                    stack.push(b4);
                    stack.push(b3);
                    stack.push(b2);
                    stack.push(b1);
                }
            }
        }

        return answer;
    }
}
