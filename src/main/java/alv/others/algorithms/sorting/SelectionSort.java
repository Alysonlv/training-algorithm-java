package alv.others.algorithms.sorting;

import alv.commons.Commons;
import java.util.Arrays;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            //define an initial smallest one as the first in the array
            int indexOfSmallest = i;

            //start to compare with all after
            for (int j = i + 1; j < array.length; j++) {

                //check if our actual smallest is smaller than the actual item
                //if not we change the index
                if (array[j] < array[indexOfSmallest]) {
                    indexOfSmallest = j;
                }
            }

            //now we swap the new smallest for the old one
            int newSmallest = array[i];
            array[i] = array[indexOfSmallest];
            array[indexOfSmallest] = newSmallest;

        }

        return array;
    }

    public static int[] selectionSortDecreasing(int[] array) {

        for (int i = 0; i < array.length; i++) {

            int indexOfBiggest = i;

            //start to compare with all after
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[indexOfBiggest]) {
                    indexOfBiggest = j;
                }
            }

            int newSmallest = array[i];
            array[i] = array[indexOfBiggest];
            array[indexOfBiggest] = newSmallest;

        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = Commons.getArrayOfInt(4, 100);
        System.out.println(Arrays.toString(selectionSort(array)));
        System.out.println(Arrays.toString(selectionSortDecreasing(array)));
        System.out.println("");

        array = Commons.getArrayOfInt(6, 100);
        System.out.println(Arrays.toString(selectionSort(array)));
        System.out.println(Arrays.toString(selectionSortDecreasing(array)));
        System.out.println("");

        array = Commons.getArrayOfInt(12, 100);
        System.out.println(Arrays.toString(selectionSort(array)));
        System.out.println(Arrays.toString(selectionSortDecreasing(array)));
        System.out.println("");
    }
}
