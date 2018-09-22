package alv.codility.Lessons.lesson03_TimeComplexity;
/*
An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.


 */

/*
 * Created by Alyson Vasconcelos - 05/05/2018
 */

import java.util.stream.IntStream;

public class Lesson04_PermMissingElem {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {2,3,1,5}));
    }

    public static int solution(int[] A) {
        long N = A.length + 1;
        return (int) (((N*(N+1))/2)-IntStream.of(A).sum());

    }
}
