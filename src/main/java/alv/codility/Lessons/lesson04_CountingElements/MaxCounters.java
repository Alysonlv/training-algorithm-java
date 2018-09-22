package alv.codility.Lessons.lesson04_CountingElements;
/*
 * Created by alysonlv - 26/05/2018
 *
You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.
 */

import java.util.Arrays;

public class MaxCounters {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4 })));
        System.out.println(Arrays.toString(solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4, 6 })));
        System.out.println(Arrays.toString(solution(1, new int[] { 2, 1, 1, 2, 1 })));
    }

    public static int[] solution(int N, int[] A) {
        int max = 0;
        int lastMax = 0;
        int[] counters = new int[N];

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 1 && A[i] <= N) {
                counters[A[i] - 1] = Math.max(counters[A[i] - 1], lastMax);
                counters[A[i] - 1] += 1;
                max = Math.max(max, counters[A[i] - 1]);
            } else if (A[i] == N + 1) {
                lastMax = max;
            }
        }

        for(int i = 0 ; i < counters.length; i++) {
            counters[i] = Math.max(counters[i], lastMax);
        }

        return counters;
    }
}
