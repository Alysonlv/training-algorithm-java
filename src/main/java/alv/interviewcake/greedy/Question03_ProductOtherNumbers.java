package alv.interviewcake.greedy;
/*
 * Created by alysonlv - 06/06/2018
 *
 * You have an array of integers, and for each index you want to find the product of every integer except the integer at that index.
 */

import java.util.Arrays;

public class Question03_ProductOtherNumbers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(new int[] {1,7,3,4})));
        System.out.println(Arrays.toString(                         solution(new int[] {1,7,3,4})));

        System.out.println("------------------------");

        System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(new int[] {1,2,6,5,9})));
        System.out.println(Arrays.toString(                         solution(new int[] {1,2,6,5,9})));

        System.out.println("------------------------");

        System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(new int[] {1,2,3,4,5})));
        System.out.println(Arrays.toString(                         solution(new int[] {1,2,3,4,5})));

    }

    static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {

        if (intArray.length < 2)
            throw new IllegalArgumentException("Array must have at least 3 integers");

        int[] arrAtIndex = new int[intArray.length];

        // for each integer, find the product of all the integers
        // before it, storing the total product so far each time
        int product = 1;
        for (int i = 0; i < intArray.length; i++) {
            arrAtIndex[i] = product;
            product *= intArray[i];
        }

        product = 1;
        for (int i = intArray.length - 1; i >= 0; i--) {
            arrAtIndex[i] *= product;
            product *= intArray[i];
        }

        return arrAtIndex;
    }

    static int[] solution(int[] A) {
        if (A.length < 2) {
            throw new IllegalArgumentException("Array must have at least 3 integers");
        } else if (A.length == 2) {
            return A;
        }


        int[] arrAtIndex = new int[A.length];

        for (int i = 0; i < A.length; i++) {

            int product = 1;
            for (int j = 0; j < A.length; j++) {
                if (i != j)
                    product *= A[j];
            }

            arrAtIndex[i] = product;
        }

        return arrAtIndex;
    }



}
