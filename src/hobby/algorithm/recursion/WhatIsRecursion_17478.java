package hobby.algorithm.recursion;

import java.io.*;

public class WhatIsRecursion_17478 {
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");

        question(sb, N);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void question(StringBuilder sb, int n) {
        if (n == 0) {
            underline(sb, n);
            sb.append("\"재귀함수가 뭔가요?\"");
            ls(sb);

            underline(sb, n);
            sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            ls(sb);

            underline(sb, n);
            sb.append("라고 답변하였지.");
            ls(sb);
            return;
        }

        underline(sb, n);
        sb.append("\"재귀함수가 뭔가요?\"");
        ls(sb);
        underline(sb, n);
        sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        ls(sb);
        underline(sb, n);
        sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        ls(sb);
        underline(sb, n);
        sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        ls(sb);

        question(sb, n - 1);

        underline(sb, n);
        sb.append("라고 답변하였지.");
        ls(sb);
    }

    private static void underline(StringBuilder sb, int n) {
        sb.append("_".repeat((N - n) * 4));
    }

    private static void ls(StringBuilder sb) {
        sb.append(System.lineSeparator());
    }
}
