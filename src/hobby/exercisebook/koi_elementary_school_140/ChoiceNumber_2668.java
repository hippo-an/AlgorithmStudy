package hobby.exercisebook.koi_elementary_school_140;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// 생각한점
/*
1. max, min 을 찾는다고 해서 항상 값의 비교가 일어난다는 고정관념을 깨자.
2. 1차원 배열에서 재귀 dfs 와 floyd's cycle detection algorithm 을 통해 사이클 존재 여부 구현을 연습하자.
3.  for (int i = nextIdx; i != idx; i = arr[i]) {
        ans++;
        ansList.add(i);
    }
    ans++;
    ansList.add(idx);
    역 탐색을 위한 해당 코드의 구조를 잘 기억하고 1차원 배열 순환에서 잘 사용해먹자.
 */
public class ChoiceNumber_2668 {
    static int n, ans;
    static int[] arr;
    static boolean[] visited, finished;
    static List<Integer> ansList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        visited = new boolean[n + 1];
        finished = new boolean[n + 1];

        ans = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }


        Collections.sort(ansList);
        StringBuilder sb = new StringBuilder();
        for (Integer x : ansList) {
            sb.append(x);
            sb.append("\n");
        }

        bw.write(ans + "\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int idx) {
        visited[idx] = true;
        int nextIdx = arr[idx];

        if (!visited[nextIdx]) {
            dfs(nextIdx);
        } else if (!finished[nextIdx]) {
            for (int i = nextIdx; i != idx; i = arr[i]) {
                ans++;
                ansList.add(i);
            }
            ans++;
            ansList.add(idx);
        }

        finished[idx] = true;
    }
}
