package newstep.progression.leet;

import java.util.Stack;

public class BackspaceStringCompare_844_Easy {
    public boolean backspaceCompare(String s, String t) {
        return compute(s).equals(compute(t));
    }

    private Stack<Character> compute(String t) {
        Stack<Character> stack = new Stack<>();
        for (char c : t.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()){
                stack.pop();
            }
        }
        return stack;
    }
}
