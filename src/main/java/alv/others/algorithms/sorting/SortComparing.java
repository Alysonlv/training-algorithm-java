package alv.others.algorithms.sorting;
/*
 * Created by alysonlv - 23/09/2018
 */

import alv.commons.Commons;

import java.text.DecimalFormat;

public class SortComparing {

    public static void main(String[] args) {

        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        int size = 1_000;
        int[] test01 = Commons.getArrayOfInt(size, Integer.MAX_VALUE);
        int[] test02 = Commons.getArrayOfInt(size, Integer.MAX_VALUE);
        int[] test03 = Commons.getArrayOfInt(size, Integer.MAX_VALUE);
        int[] test04 = Commons.getArrayOfInt(size, Integer.MAX_VALUE);

        long initialTime = System.nanoTime();
        BubbleSort.bubbleSort(test01);

        System.out.println("With size " + decimalFormat.format(size));
        System.out.println("Bubble Sort...... " + decimalFormat.format(System.nanoTime() - initialTime));
        initialTime = System.nanoTime();
        MergeSort.mergeSort(test02, 0, test02.length - 1);
        System.out.println("Merge Sort....... " + decimalFormat.format(System.nanoTime() - initialTime));

        initialTime = System.nanoTime();
        QuickSort.quickSortExecutor(test03);
        System.out.println("Quick Sort....... " + decimalFormat.format(System.nanoTime() - initialTime));

        initialTime = System.nanoTime();
        SelectionSort.selectionSort(test04);
        System.out.println("Selection Sort... " + decimalFormat.format(System.nanoTime() - initialTime));

        size = 100_000;
        test01 = Commons.getArrayOfInt(size, Integer.MAX_VALUE);
        test02 = Commons.getArrayOfInt(size, Integer.MAX_VALUE);
        test03 = Commons.getArrayOfInt(size, Integer.MAX_VALUE);
        test04 = Commons.getArrayOfInt(size, Integer.MAX_VALUE);

        initialTime = System.nanoTime();
        BubbleSort.bubbleSort(test01);

        System.out.println("\nWith size " + decimalFormat.format(size));
        System.out.println("Bubble Sort...... " + decimalFormat.format(System.nanoTime() - initialTime));
        initialTime = System.nanoTime();
        MergeSort.mergeSort(test02, 0, test02.length - 1);
        System.out.println("Merge Sort....... " + decimalFormat.format(System.nanoTime() - initialTime));

        initialTime = System.nanoTime();
        QuickSort.quickSortExecutor(test03);
        System.out.println("Quick Sort....... " + decimalFormat.format(System.nanoTime() - initialTime));

        initialTime = System.nanoTime();
        SelectionSort.selectionSort(test04);
        System.out.println("Selection Sort... " + decimalFormat.format(System.nanoTime() - initialTime));

        size = 200_000;
        test01 = Commons.getArrayOfInt(size, Integer.MAX_VALUE);
        test02 = Commons.getArrayOfInt(size, Integer.MAX_VALUE);
        test03 = Commons.getArrayOfInt(size, Integer.MAX_VALUE);
        test04 = Commons.getArrayOfInt(size, Integer.MAX_VALUE);

        initialTime = System.nanoTime();
        BubbleSort.bubbleSort(test01);

        System.out.println("\nWith size " + decimalFormat.format(size));
        System.out.println("Bubble Sort...... " + decimalFormat.format(System.nanoTime() - initialTime));
        initialTime = System.nanoTime();
        MergeSort.mergeSort(test02, 0, test02.length - 1);
        System.out.println("Merge Sort....... " + decimalFormat.format(System.nanoTime() - initialTime));

        initialTime = System.nanoTime();
        QuickSort.quickSortExecutor(test03);
        System.out.println("Quick Sort....... " + decimalFormat.format(System.nanoTime() - initialTime));

        initialTime = System.nanoTime();
        SelectionSort.selectionSort(test04);
        System.out.println("Selection Sort... " + decimalFormat.format(System.nanoTime() - initialTime));

    }
}
