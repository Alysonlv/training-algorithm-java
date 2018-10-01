package alv.others.algorithms.sorting;
/*
 * Created by alysonlv - 22/09/2018
 */

import alv.commons.Commons;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] array, int from, int to) {
        if (from < to) {
            int middle = (from + to) / 2;
            mergeSort(array, from, middle);
            mergeSort(array, middle + 1, to);
            merge(array, from, middle, to);
        }
    }

    public static void merge(int[] array, int from, int middle, int to) {
        int lengthLeft = middle - from + 1;
        int lengthRight = to - middle;
        int[] left = new int[lengthLeft + 1];
        int[] right = new int[lengthRight + 1];

        for (int i = 0; i < lengthLeft; i++) {
            left[i] = array[from + i];
        }
        for (int i = 0; i < lengthRight; i++) {
            right[i] = array[middle + i + 1];
        }
        left[lengthLeft] = Integer.MAX_VALUE;
        right[lengthRight] = Integer.MAX_VALUE;

        int leftPointer = 0;
        int rightPointer = 0;
        for (int i = from; i <= to; i++) {
            if (left[leftPointer] > right[rightPointer]) {
                array[i] = right[rightPointer];
                rightPointer++;
            } else {
                array[i] = left[leftPointer];
                leftPointer++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = Commons.getArrayOfInt(8, 100);
        System.out.println(Arrays.toString(array));
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
