package acmicpc.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Physical_25314_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder("long ".repeat(Integer.parseInt(br.readLine()) / 4));
        sb.append("int");
        System.out.println(sb);
        br.close();
    }
}
