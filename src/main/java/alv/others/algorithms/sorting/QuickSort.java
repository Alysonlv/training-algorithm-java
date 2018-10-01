package alv.others.algorithms.sorting;
/*
 * Created by alysonlv - 22/09/2018
 */

import alv.commons.Commons;

import java.util.Arrays;

public class QuickSort {

    public static int[] quickSortExecutor(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public static void quickSort(int[] array, int from, int to) {
        if (from < to) {
            int pivotIndex = quickSortPartition(array, from, to);
            quickSort(array, from, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, to);
        }
    }

    public static int quickSortPartition(int[] array, int from, int to) {
        int pivotIndex = array[to];
        int wall = from;

        for (int i = from; i < to; i++) {
            if (array[i] <= pivotIndex) {
                int swap = array[wall];
                array[wall] = array[i];
                array[i] = swap;
                wall++;
            }
        }

        array[to] = array[wall];
        array[wall] = pivotIndex;

        return wall;
    }

    // this function can be used for "quickSortAverage call" where you only pass array
    // it generates "from" and "to" parameters
    public static int[] quickSortMedianExecutor(int[] input) {
        quickSortMedian(input, 0, input.length - 1);
        return input;
    }

    public static void quickSortMedian(int[] input, int from, int to) {
        if (from < to) {
            int indexOfPivot = partitionMedian(input, from, to);
            quickSortMedian(input, from, indexOfPivot - 1);
            quickSortMedian(input, indexOfPivot + 1, to);
        }
    }

    public static int medianOfThree(int[] input, int first, int middle, int last) {
        int[] array = {input[first], input[middle], input[last]};
        SelectionSort.selectionSort(array);
        if (array[1] == input[first]) {
            return first;
        } else if (array[1] == input[middle]) {
            return middle;
        } else {
            return last;
        }
    }

    public static int partitionMedian(int[] input, int from, int to) {
        int indexOfPivot = medianOfThree(input, from, (from + to) / 2, to);
        int pivot = input[indexOfPivot];
        if (indexOfPivot != to) {
            input[indexOfPivot] = input[to];
        }
        int wall = from;
        for (int i = from; i < to; i++) {
            if (input[i] <= pivot) {
                int temp = input[wall];
                input[wall] = input[i];
                input[i] = temp;
                wall++;
            }
        }
        input[to] = input[wall];
        input[wall] = pivot;

        return wall;
    }


    public static int[] quickSortExecutorDecreasing(int[] array) {
        quickSortDecreasing(array, 0, array.length - 1);
        return array;
    }

    public static void quickSortDecreasing(int[] array, int from, int to) {
        if (from < to) {
            int pivotIndex = quickSortPartitionDecreasing(array, from, to);
            quickSortDecreasing(array, from, pivotIndex - 1);
            quickSortDecreasing(array, pivotIndex + 1, to);
        }
    }

    public static int quickSortPartitionDecreasing(int[] array, int from, int to) {
        int pivotIndex = array[to];
        int wall = from;

        for (int i = from; i < to; i++) {
            if (array[i] >= pivotIndex) {
                int swap = array[wall];
                array[wall] = array[i];
                array[i] = swap;
                wall++;
            }
        }

        array[to] = array[wall];
        array[wall] = pivotIndex;

        return wall;
    }

    public static void main(String[] args) {
        int[] array = Commons.getArrayOfInt(10,100);
        System.out.println(Arrays.toString(quickSortExecutor(array)));
        System.out.println(Arrays.toString(quickSortExecutorDecreasing(array)));
        System.out.println(Arrays.toString(quickSortMedianExecutor(array)));
    }
}
