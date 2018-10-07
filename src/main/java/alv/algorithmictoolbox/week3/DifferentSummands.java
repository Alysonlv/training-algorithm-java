package alv.algorithmictoolbox.week3;
/*
 * Created by alysonlv - 07/10/2018
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifferentSummands {

    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();

        int count = 1;
        while (n > 0) {
            if (count < n - count) {
                summands.add(count);
            } else {
                summands.add(n);
                return summands;
            }
            n -= count++;
        }

        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}
