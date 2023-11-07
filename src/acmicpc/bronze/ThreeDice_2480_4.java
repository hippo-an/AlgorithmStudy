package acmicpc.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ThreeDice_2480_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        cal(a, b, c);
    }

    private static void cal(int a, int b, int c) {
        int price;
        if (a == b && b == c) {
            price = 10000 + (a * 1000);
        } else if (a == b) {
            price = 1000 + (a * 100);
        } else if (c == b) {
            price = 1000 + (b * 100);
        } else if (a == c) {
            price = 1000 + (a * 100);
        } else {
            price = Math.max(a, Math.max(b, c)) * 100;
        }
        System.out.println(price);
    }
}
