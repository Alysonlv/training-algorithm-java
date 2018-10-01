package alv.algorithmictoolbox.week2;
/*
 * Created by alysonlv - 28/09/2018
 */

import java.util.Scanner;

public class GreatCommonDivisor {

    public static int euclidGcd(int x, int y) {
        int divisor = x >= y ? x : y;
        int dividend = x <= y ? x : y;

        while (divisor != 0) {
            int remainder = dividend % divisor;
            dividend = divisor;
            divisor = remainder;
        }

        return dividend;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        System.out.println(euclidGcd(x, y));
    }
}
