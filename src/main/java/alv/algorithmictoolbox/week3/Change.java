package alv.algorithmictoolbox.week3;
/*
 * Created by alysonlv - 06/10/2018
 */

import java.util.Scanner;

public class Change {

    private static int[] coins = {10, 5, 1};

    private static int getChange(int m) {

        int result = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= m) {
                int num = m / coins[i];
                result += num;
                m -= num * coins[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //int m = scanner.nextInt();

        int m = 28;
        System.out.println(m + " = " + getChange(m));
        m = 27;
        System.out.println(m + " = " + getChange(m));
        m = 26;
        System.out.println(m + " = " + getChange(m));
        m = 25;
        System.out.println(m + " = " + getChange(m));
        m = 2;
        System.out.println(m + " = " + getChange(m));
        m = 11;
        System.out.println(m + " = " + getChange(m));
        m = 16;
        System.out.println(m + " = " + getChange(m));
        m = 209;
        System.out.println(m + " = " + getChange(m));
        m = 6;
        System.out.println(m + " = " + getChange(m));


    }
}
