package newstep.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Arrow_15970 {
    private static int N;
    private static Point[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new Point[N + 1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st= new StringTokenizer(br.readLine());

            Point point = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            arr[i] = point;
        }

        Arrays.sort(arr, 1, N + 1, ((p1, p2 )-> {
            if (p1.color == p2.color) {
                return p1.index - p2.index;
            }
            return p1.color - p2.color;
        }));

        int ans = arr[2].index - arr[1].index;

        for (int i = 2; i <= N - 1; i++) {
            Point front = arr[i - 1];
            Point middle = arr[i];
            Point rear = arr[i + 1];

            if (rear.color != middle.color) {
                ans += middle.index - front.index;
            } else if (front.color != middle.color) {
                ans += rear.index - middle.index;
            } else {
                ans += Math.min(middle.index - front.index, rear.index - middle.index);
            }
        }

        ans += arr[N].index - arr[N - 1].index;

        System.out.println(ans);

    }

    static class Point{
        int index;
        int color;

        public Point(int index, int color) {
            this.index = index;
            this.color = color;
        }
    }
}
