package alv.algorithmictoolbox.week6;

import java.util.*;

public class Knapsack {
    static int optimalWeight(int max, int[] values) {
        int n = values.length;
        int i, w;
        int K[][] = new int[n+1][max+1];

        for (i = 0; i <= n; i++) {
            for (w = 0; w <= max; w++) {
                if (i==0 || w==0) {
                    K[i][w] = 0;
                }
                else if (values[i-1] <= w) {
                    K[i][w] = Math.max(values[i-1] + K[i-1][w-values[i-1]], K[i-1][w]);
                }
                else {
                    K[i][w] = K[i-1][w];
                }
            }
        }

        return K[n][max];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}