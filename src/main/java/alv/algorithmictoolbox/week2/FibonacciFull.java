package alv.algorithmictoolbox.week2;
/*
 * Created by alysonlv - 27/09/2018
 */

import java.util.Arrays;

public class FibonacciFull {

    public static long[] fibonacci(int size) {
        long[] fibonacci = new long[size];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i < size; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        return fibonacci;
    }

    public static Integer naiveFibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        } else {
            return naiveFibonacciRecursive(n - 1) + naiveFibonacciRecursive(n - 2);
        }
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("The " + n + " FibonacciFull number is " + naiveFibonacciRecursive(n));
        n = 3;
        System.out.println("The " + n + " FibonacciFull number is " + naiveFibonacciRecursive(n));
        n = 20;
        System.out.println("The " + n + " FibonacciFull number is " + naiveFibonacciRecursive(n));

        System.out.println("Sequences");
        n = 20;
        System.out.println("With " + n + ":" + Arrays.toString(fibonacci(n)));
        n = 30;
        System.out.println("With " + n + ":" + Arrays.toString(fibonacci(n)));
        n = 50;
        System.out.println("With " + n + ":" + Arrays.toString(fibonacci(n)));
        n = 100;
        System.out.println("With " + n + ":" + Arrays.toString(fibonacci(n)));
    }
}
