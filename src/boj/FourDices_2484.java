package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FourDices_2484 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        String cnt = br.readLine();
        for (int i = 0; i < Integer.parseInt(cnt); i++) {
            String read = br.readLine();
            List<Integer> d = Arrays.stream(read.split(" ")).map(Integer::parseInt).sorted().collect(Collectors.toList());

            int tmp = 0;
            if(d.get(0).equals(d.get(3))) tmp = 50000 + (d.get(3) * 5000);
            else if(d.get(1).equals(d.get(2))) {
                if (d.get(0).equals(d.get(1)) || d.get(1).equals(d.get(3))) tmp = 10000 + d.get(2) * 1000;
                else tmp = 1000 + d.get(1)* 100;
            }
            else if (d.get(0).equals(d.get(1)) && d.get(2).equals(d.get(3))) tmp = 2000 + d.get(1) * 500 + d.get(2) * 500;
            else tmp = d.get(3)* 100;
            ans = Math.max(tmp, ans);
        }
        System.out.println(ans);
    }
}
