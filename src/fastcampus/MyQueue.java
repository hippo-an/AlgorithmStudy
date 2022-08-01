package fastcampus;

import java.util.ArrayList;
import java.util.List;

public class MyQueue<T> {
    private final List<T> queue = new ArrayList<>();


    public boolean enqueue(T element) {
        return queue.add(element);
    }

    public T dequeue() {
        if (queue.isEmpty()) return null;

        return queue.remove(0);
    }

    public static void main(String[] args) {
        MyQueue<Integer> q = new MyQueue<>();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
