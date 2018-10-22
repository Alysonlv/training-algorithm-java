package alv.algorithmictoolbox.week4;
/*
 * Created by alysonlv - 22/10/2018
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * GOAL: redesign given qSort to work fast on sequences with many equal elements.
 * Task: Replace 2 way partition with 3 way partition
 * Output: Sequence sorted in non-decreasing order.
 */
public class Sorting {

    public static void randomizedQuickSort(int[] sequence, int left, int right)
    {
        if (right - left <= 0)
            return;
        else
        {
            Random rand = new Random();
            int pivotIndex = left + rand.nextInt(right - left + 1);
            swap(sequence, pivotIndex, right);

            int pivot = sequence[right];
            int partition = partitionIt(sequence, left, right, pivot);
            randomizedQuickSort(sequence, left, partition - 1);
            randomizedQuickSort(sequence, partition + 1, right);
        }
    }

    public static int partitionIt(int[] sequence, int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;

        while (true) {
            while (sequence[++leftPtr] < pivot)
                ;
            while (rightPtr > 0 && sequence[--rightPtr] > pivot)
                ;

            if (leftPtr >= rightPtr)
                break;
            else
                swap(sequence, leftPtr, rightPtr);
        }
        swap(sequence, leftPtr, right);
        return leftPtr;
    }

    public static void swap(int[] sequence, int dex1, int dex2) {
        int temp = sequence[dex1];
        sequence[dex1] = sequence[dex2];
        sequence[dex2] = temp;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
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