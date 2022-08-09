package newstep.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FileArrangement_20291 {
    private static int N;
    private static Map<String, Integer> map = new TreeMap<>();  // 노드를 정렬해주는 트리맵
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String key = br.readLine().split("\\.")[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
