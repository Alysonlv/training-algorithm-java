package alv.algorithmictoolbox.week2;
/*
 * Created by alysonlv - 28/09/2018
 */

import java.util.Scanner;

public class FibonacciSumLastDigit {

    public static int getFibonacciLastDigitFast(int n) {
        if (n <= 1) {
            return n;
        }

        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            result[i] = (result[i - 1] + result[i - 2]) % 10;
        }

        return result[n];
    }

    public static int getFibonacciSumFast(long n) {
        int newN = (int) ((n + 2) % 60);
        int newLast = getFibonacciLastDigitFast(newN);

        if (newLast == 0) {
            return 9;
        } else {
            return newLast - 1;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumFast(n);
        System.out.println(s);
    }
}
