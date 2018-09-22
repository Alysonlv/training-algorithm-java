package alv.codility.Lessons.lesson03_TimeComplexity;
/*
A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
We can split this tape in four places:

P = 1, difference = |3 − 10| = 7
P = 2, difference = |4 − 9| = 5
P = 3, difference = |6 − 7| = 1
P = 4, difference = |10 − 3| = 7
 */

/*
 * Created by Alyson Vasconcelos - 05/05/2018
 */

public class Lesson06_TapeEquilibrium {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {3,1,2,4,3}));
        System.out.println(solution(new int[] {2,3,4,5,6,4,3,2,5,6,4,9,7,6,8,9,8,9,9}));
    }

    public static int solution(int[] A) {
        int minimum = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        for (int e : A) right += e;

        for(int i = 0; i < A.length-1; i++){
            left += A[i];
            right -= A[i];

            if (minimum > Math.abs(left - right)) {
                minimum = Math.abs(left - right);
            }
        }
        return minimum;
    }

}
