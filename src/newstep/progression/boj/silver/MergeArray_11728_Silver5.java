package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class MergeArray_11728_Silver5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] aArr = new int[N + 1];
        int[] bArr = new int[M + 1];

        StringTokenizer a = new StringTokenizer(br.readLine());
        StringTokenizer b = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            aArr[i] = Integer.parseInt(a.nextToken());
        }

        for (int i = 1; i <= M; i++) {
            bArr[i] = Integer.parseInt(b.nextToken());
        }


        List<Integer> ans = new ArrayList<>();

        int ap = 1;
        int bp = 1;

        while (ap <= N && bp <= M) {
            if (aArr[ap] < bArr[bp]) {
                while (ap <= N && (aArr[ap] < bArr[bp] || bp > M)) {
                    ans.add(aArr[ap]);
                    ap++;
                }
            } else {
                while (bp <= M && (aArr[ap] >= bArr[bp] || ap > N)) {
                    ans.add(bArr[bp]);
                    bp++;
                }
            }
        }

        if (ap <= N) {
            while(ap <= N) {
                ans.add(aArr[ap]);
                ap++;
            }
        } else {
            while(bp <= M) {
                ans.add(bArr[bp]);
                bp++;
            }
        }


        Collections.sort(ans);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i)).append(" ");
        }

        System.out.println(sb);
        br.close();
    }

}
