package alv.others.algorithms.sorting;
/*
 * Created by alysonlv - 22/09/2018
 */

import alv.commons.Commons;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
        //the first iteration will represent in "i" how many elements have bubbled to correct place
        for (int i = 0; i < array.length - 1; i++) {

            boolean sorted = false;
            for (int j = 0; j + 1 < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    sorted = true;
                    int swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }

            if (!sorted) {
                return array;
            }
        }

        return array;
    }

    public static int[] bubbleSortDecreasing(int[] array) {
        //the first iteration will represent in "i" how many elements have bubbled to correct place
        for (int i = 0; i < array.length - 1; i++) {

            boolean sorted = false;
            for (int j = 0; j + 1 < array.length - i; j++) {
                if (array[j] < array[j + 1]) {
                    sorted = true;
                    int swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }

            if (!sorted) {
                return array;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = Commons.getArrayOfInt(6, 100);
        System.out.println(Arrays.toString(bubbleSort(array)));
        System.out.println(Arrays.toString(bubbleSortDecreasing(array)));
        System.out.println("");

        array = Commons.getArrayOfInt(12, 100);
        System.out.println(Arrays.toString(bubbleSort(array)));
        System.out.println(Arrays.toString(bubbleSortDecreasing(array)));
        System.out.println("");

        array = Commons.getArrayOfInt(32, 100);
        System.out.println(Arrays.toString(bubbleSort(array)));
        System.out.println(Arrays.toString(bubbleSortDecreasing(array)));
        System.out.println("");
    }
}
