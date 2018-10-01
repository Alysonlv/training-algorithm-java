package alv.algorithmictoolbox.week2;
/*
 * Created by alysonlv - 27/09/2018
 */

import java.math.BigInteger;

public class Eu {

    public static int euclidGCD(int a, int b) {
        int divisor = a >= b ? a : b;
        int dividend = a <= b ? a : b;

        while (divisor != 0) {
            int remainder = dividend % divisor;
            dividend = divisor;
            divisor = remainder;
        }
        return dividend;
    }

    public static void main(String[] args) {

        System.out.println(euclidGCD(123124324,5345344));
    }
}
