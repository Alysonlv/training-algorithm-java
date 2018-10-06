package alv.algorithmictoolbox.week3;
/*
 * Created by alysonlv - 06/10/2018
 */

import java.util.Arrays;
import java.util.Scanner;

public class DotProduct {

    private static long maxDotProduct(int[] a, int[] b) {
        //Bounds checking
        if(a.length <= 0 || b.length <= 0){
            return 0;
        }

        Arrays.sort(a);
        Arrays.sort(b);

        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result += (long) a[i] * b[i];  // Casting one to long to handle large ints
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}
