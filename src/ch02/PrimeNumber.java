package ch02;

public class PrimeNumber {

    public static void main(String[] args) {

//        primeNumber1();

//        primeNumber2();

        primeNumber3();


    }

    private static void primeNumber3() {

        int counter = 0;
        int countPrimeNumber = 0;
        int[] prime = new int[500];

        prime[countPrimeNumber++] = 2;
        prime[countPrimeNumber++] = 3;

        for (int n = 5; n <= 1000; n += 2) {
           boolean flag = false;

            for (int i = 1; prime[i] * prime[i] <= n; i++) {
                counter += 2;

                if (n % prime[i] == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                prime[countPrimeNumber++] = n;
                counter++;
            }
        }

        for (int i = 0; i < countPrimeNumber; i++) {
            System.out.println(prime[i]);
        }

        System.out.println("연산 수행 횟수 : " + counter);

    }

    private static void primeNumber2() {

        int counter = 0;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;
        for (int n = 3; n <= 1000; n += 2) {
            int i;

            for (i = 1; i < ptr; i++) {
                counter++;
                if (n % prime[i] == 0) {
                    break;
                }
            }
            if (ptr == i) {
                prime[ptr++] = n;
            }
        }

        for (int i = 0; i < ptr; i++) {
            System.out.println(prime[i]);
        }

        System.out.println("나눗셈 수행 횟수 : " + counter);

    }

    private static void primeNumber1() {
        int counter = 0;

        for (int n = 2; n <= 1000; n++) {
            /*
            n = 2, 3, 4, 5, 6, 7, ...., 1000
             */
            int i;

            for (i = 2; i < n; i++) {
                counter++;
                if (n % i == 0) {
                    break;
                }
            }

            if (n == i) {
                System.out.println(n);
            }
        }

        System.out.println("나눗셈 수행 횟수 : " + counter);
    }
}
