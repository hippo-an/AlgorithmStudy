package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AgeSort_10814_Silver5 {
    private static Users[] arr;
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new Users[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Users(Integer.parseInt(st.nextToken()), st.nextToken(), i);
        }

        Arrays.sort(arr, 1, N + 1);

        for (int i = 1; i <= N; i++) {
            Users users = arr[i];
            sb.append(users.age).append(" ").append(users.name).append("\n");
        }

        System.out.println(sb);
    }

    public static class Users implements Comparable<Users> {
        int age;
        String name;
        int num;

        public Users(int age, String name, int num) {
            this.age = age;
            this.name = name;
            this.num = num;
        }


        @Override
        public int compareTo(Users o) {
            if (this.age == o.age) return this.num - o.num;
            return this.age - o.age;
        }

    }
}
