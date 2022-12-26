package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SystemTransformation_11005_Bronze1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while (N > 0) {
            sb.append(parse(N % B));
            N /= B;
        }
        System.out.println(sb.reverse());
        br.close();
    }

    private static char parse(int i) {
        return i < 10 ? (char)(i + '0') : (char)(i - 10 + 'A');
    }
}
