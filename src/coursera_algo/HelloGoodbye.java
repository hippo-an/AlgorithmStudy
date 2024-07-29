package coursera_algo;

public class HelloGoodbye {
    public static void main(String[] args) {
        String firstArg = args[0];
        String secondArg = args[1];

        System.out.printf("Hello %s and %s.\n", firstArg, secondArg);
        System.out.printf("Goodbye %s and %s.\n", secondArg, firstArg);
    }
}
