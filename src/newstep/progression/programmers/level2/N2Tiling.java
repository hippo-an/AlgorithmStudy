package newstep.progression.programmers.level2;

public class N2Tiling {

    public static void main(String[] args) {

    }

    public int solution(int n) {

        int[] arr = new int[60001];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3;i <= 60000; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
        }

        return arr[n];
    }

}
