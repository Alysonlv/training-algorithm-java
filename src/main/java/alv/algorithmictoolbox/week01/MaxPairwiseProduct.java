package alv.algorithmictoolbox.week01;
/*
 * Created by alysonlv - 25/09/2018
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxPairwiseProduct {

    static long getMaxPairwiseProduct(int[] numbers) {
        int max = -1;
        int secondMax = -1;

        for (int i = 0; i < numbers.length; i++) {
            if ((max == -1) || (numbers[i] > numbers[max])) {
                max = i;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            if ((i != max) && ((secondMax == -1) || (numbers[i] > numbers[secondMax]))) {
                secondMax = i;
            }
        }

        return (long)numbers[max] * numbers[secondMax];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
