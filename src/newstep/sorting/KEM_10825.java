package newstep.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class KEM_10825 {

    private static int N;
    private static Student[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Student[N + 1];
        StringTokenizer st = null;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, 1, N + 1);

        for (int i = 1; i <= N; i++) {
            sb.append(arr[i].name).append("\n");
        }

        System.out.println(sb.toString());
    }

    static class Student implements Comparable<Student> {
        String name;
        int k;
        int e;
        int m;

        public Student (String name, int k, int e, int m) {
            this.name = name;
            this.k = k;
            this.e = e;
            this.m = m;
        }

        @Override
        public int compareTo(Student o) {
            if (k != o.k) return o.k - k;
            else if (e != o.e) return e - o.e;
            else if (m != o.m) return o.m - m;
            else return name.compareTo(o.name);
        }
    }
}
