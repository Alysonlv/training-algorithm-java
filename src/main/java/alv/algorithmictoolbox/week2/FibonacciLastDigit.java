package alv.algorithmictoolbox.week2;
/*
 * Created by alysonlv - 28/09/2018
 */

import java.util.Scanner;

public class FibonacciLastDigit {

    public static int getFibonacciLastDigit(int n) {
        if (n <= 1) {
            return n;
        }

        int[] fibonacci = new int[n + 1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % 10;
        }
        return fibonacci[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigit(n);
        System.out.println(c);
    }
}
