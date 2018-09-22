package alv.codility.Lessons.lesson02_Arrays;

/*
A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

For example, in array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the elements at indexes 0 and 2 have value 9,
the elements at indexes 1 and 3 have value 3,
the elements at indexes 4 and 6 have value 9,
the element at index 5 has value 7 and is unpaired.

 */

/*
 * Created by Alyson Vasconcelos - 05/05/2018
 */

import java.util.HashSet;

public class Lesson03_OddOccurrencesInArray {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{9,3,9,3,9,7,9}));
        System.out.println(solution2(new int[]{9,3,9,3,9,7,9}));
    }

    //This is a cool one
    public static int solution(int[] A) {

        HashSet<Integer> duplicateds = new HashSet<>();
        int resp = 0;

        for (int i = 0; i < A.length; i++) {
            if (duplicateds.add(A[i])) {
                resp = A[i];
            }
        }

        return resp;

    }

    //I got this on internet, how this work?
    public static int solution2(int[] A) {

        int elem = 0;

        for (int i = 0; i < A.length; i++) {
            elem ^= A[i];
        }

        return elem;


    }
}
