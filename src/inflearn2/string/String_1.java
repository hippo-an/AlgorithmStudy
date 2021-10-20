package inflearn2.string;

import java.io.*;
import java.util.Locale;

public class String_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().toUpperCase(Locale.ROOT);
        char c = br.readLine().charAt(0);
        c = Character.toUpperCase(c);
        int answer = 0;

        for(char x : str.toCharArray()) if(x == c) answer++;

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();


    }
}
