package ezsw;

public class Bit {
    /**
     * 원소가 n 개인 집합
     * -> 부분 집합의 총 갯수 - 1 << n
     *
     * i 번째 원소가 있는지 확인
     * >> 비트로 표현된 집합 & (1 << i) 결과가 0이 아니면 존재
     * >> e.g. 2번째 원소가 있는지 확인 -> 0101 & (1 << 2) = 0101 & 0100 = 0100
     *
     * i 번째 원소를 추가
     * >> 비트로 표현된 집합 | (1<<i)
     * >> e.g. 1번째 원소를 추가 -> 0101 | (1 << 1) = 0101 | 0010 = 0111
     *
     * i 번째 원소를 삭제
     * >> 비트로 표현된 집합 & ~(1<<i)
     * >> e.g. 2번째 원소를 삭제 -> 0101 & ~(1<<2) = 0101 & ~(0100) = 0101 & 1011 = 0001
     */

    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D'};

        printSubsets(data, data.length);
    }

    private static void printSubsets(char[] data, int n) {
        for (int i = 0; i < (1 << n); i++) {
            System.out.print("{");
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) {
                    System.out.print(data[j] + " ");
                }
            }
            System.out.println("}");
        }
    }
}
