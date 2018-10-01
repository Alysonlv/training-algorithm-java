package alv.algorithmictoolbox.week2;
/*
 * Created by alysonlv - 28/09/2018
 */

import java.util.Scanner;

public class FibonacciHuge {

    public static long getFibonacciHuge(long n, long m) {
        long remainder = n % pisanoPeriodLength(m);

        long Fib1 = 0, Fib2 = 1, Fib = remainder;

        for (int i = 1; i < remainder; i++) {
            Fib = (Fib1 + Fib2) % m;
            Fib1 = Fib2;
            Fib2 = Fib;
        }

        return Fib % m;
    }

    private static long pisanoPeriodLength(long m) {
        long Fib1 = 0, Fib2 = 1, F = Fib1 + Fib2, length = 0;

        for (int i = 0; i < m * m; i++) {
            F = (Fib1 + Fib2) % m;
            Fib1 = Fib2;
            Fib2 = F;
            if (Fib1 == 0 && Fib2 == 1) {
                length = i + 1;
                break;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}
