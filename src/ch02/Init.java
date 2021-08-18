package ch02;

import java.util.Arrays;

public class Init {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};

        int[] b = a.clone();

        a[0] = 7;

        System.out.println("a == b ?? => " + Arrays.equals(a, b));

        for (int i : a) {
            System.out.println("a = " + i);
        }
        System.out.println("=====================");
        for (int i : a) {
            System.out.println("a = " + i);
        }
    }
}
