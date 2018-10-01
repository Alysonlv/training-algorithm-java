package alv.algorithmictoolbox.week01;
/*
 * Created by alysonlv - 25/09/2018
 */

import java.util.Scanner;

public class APlusB {

    static int sumOfTwoDigits(int firstDigit, int secondDigit) {
        return firstDigit + secondDigit;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.println(sumOfTwoDigits(a, b));
    }
}
