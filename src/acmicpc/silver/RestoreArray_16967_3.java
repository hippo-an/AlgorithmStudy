package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RestoreArray_16967_3 {
    private static int h, w, x, y;
    private static int[][] arr;
    private static int[][] cross;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        arr = new int[h + x][w + y];
        cross = new int[h][w];

        for (int i = 0; i < h + x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w + y; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 교차 하는 곳의 정보 추출
        for (int i = x; i < h; i++) {
            for (int j = y; j < w; j++) {
                cross[i][j] = arr[i - x][j - y];
            }
        }

        StringBuilder sb = new StringBuilder();

        // 배열 인덱스로 조건에 맞는 값을 추가
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i >= x && j >= y) {
                    sb.append(arr[i][j] - cross[i][j]);
                } else {
                    sb.append(arr[i][j]);
                }

                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
