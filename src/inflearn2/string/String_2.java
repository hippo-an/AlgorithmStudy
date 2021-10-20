package inflearn2.string;

import java.io.*;

public class String_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringBuffer sb = new StringBuffer();
        for(char x : s.toCharArray()) {
            if(Character.isUpperCase(x)) sb.append(Character.toLowerCase(x));
            else sb.append(Character.toUpperCase(x));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
