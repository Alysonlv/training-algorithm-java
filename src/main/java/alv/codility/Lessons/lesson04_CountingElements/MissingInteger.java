package alv.codility.Lessons.lesson04_CountingElements;
/*
 * Created by alysonlv - 26/05/2018
 *
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.


 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MissingInteger {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,3,6,4,1,2,5}));
        System.out.println(solution(new int[] {-3,-1}));
        System.out.println(solution(new int[] {-3,-1,1}));
        System.out.println(solution2(new int[] {1,3,6,4,1,2,5}));
        System.out.println(solution2(new int[] {-3,-1}));
        System.out.println(solution2(new int[] {-3,-1,1}));
    }

    //85/100
    static int solution(int[] A) {
        int missingInteger = 1;

        Set<Integer> B = new TreeSet<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                B.add(A[i]);
            }
        }

        Iterator<Integer> it = B.iterator();
        while (it.hasNext()) {
            if (it.next() == missingInteger) {
                ++missingInteger;
            }
        }


        return missingInteger;
    }

    //This got 100/100
    static int solution2(int[] A) {
        int missingInteger = 1;

        Set<Integer> B = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                B.add(A[i]);
            }
        }

        while (B.contains(missingInteger)) {
            missingInteger++;
        }

        return missingInteger;
    }
}
