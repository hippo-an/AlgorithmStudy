package hobby.basic;

import java.io.*;

public class OX_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            int score = 0;
            int cont = 0;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == 'O') {
                    score += ++cont;
                } else {
                    cont = 0;
                }
            }

            bw.write(score + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
