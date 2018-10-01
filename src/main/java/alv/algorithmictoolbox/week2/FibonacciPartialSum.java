package alv.algorithmictoolbox.week2;
/*
 * Created by alysonlv - 28/09/2018
 */

import java.util.Scanner;

public class FibonacciPartialSum {

    public static long getFibonacciPartialSum(long from, long to) {
        if (to <= 1)
            return to;

        long previous = 0;
        long current = 1;

        for (long i = 0; i < from - 1; ++i) {
            long temp = previous;
            previous = current;
            current = temp + current;
        }

        long sum = current;

        for (long i = 0; i < to - from; ++i) {
            long temp = previous;
            previous = current;
            current = temp + current;
            sum += current;
        }

        return sum % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}
