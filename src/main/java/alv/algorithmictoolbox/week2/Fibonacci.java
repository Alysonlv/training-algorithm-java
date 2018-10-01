package alv.algorithmictoolbox.week2;
/*
 * Created by alysonlv - 28/09/2018
 */

import java.util.Scanner;

public class Fibonacci {

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        long[] fibonacci = new long[n + 1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        return fibonacci[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(fibonacci(n));
    }

}
