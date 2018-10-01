package alv.algorithmictoolbox.week2;
/*
 * Created by alysonlv - 28/09/2018
 */

import java.util.Scanner;

public class LeastCommonMultiple {

    private static long euclidGcd(long a, long b) {
        long divisor = a >= b ? a : b;
        long dividend = a <= b ? a : b;

        while (divisor != 0) {
            long remainder = dividend % divisor;
            dividend = divisor;
            divisor = remainder;
        }
        return dividend;
    }

    private static long leastCommonMultipleExecutor(long a, long b) {
        return (a * b) / euclidGcd(a, b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(leastCommonMultipleExecutor(a, b));
    }
}
