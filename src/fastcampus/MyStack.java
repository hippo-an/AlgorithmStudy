package fastcampus;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
    private final List<T> stack = new ArrayList<>();


    public void push(T element) {
        stack.add(element);
    }

    public T pop() {
        if (stack.isEmpty()) return null;
        return stack.remove(stack.size() - 1);
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }


}
