package alv.interviewcake.greedy;
/*
 * Created by alysonlv - 06/06/2018
 *
 * Given an array of integers, find the highest product you can get from three of the integers
 */

public class Question02_HighestProductOf3 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {2,3,4}));
        System.out.println(solution(new int[] {2,3,4,5}));
        System.out.println(solution(new int[] {-10,-10,1,3,2}));
        System.out.println(solution(new int[] {1,10,-5,1,-100}));
        System.out.println(solution(new int[] {-5, 4, 8, 2, 3}));
        System.out.println(solution(new int[] {10,1,1,1,10,1,1,1,1,10,1}));
    }

    static int solution(int[] A) {

        if (A.length < 3) {
            throw new IllegalArgumentException("Less than 3 items!");
        } else  if (A.length == 3)
            return A[0] * A[1] * A[2];

//      1-  the current highestProductOf3
//      2-  current * highestProductOf2
//      3-  current * lowestProductOf2 (if current and lowestProductOf2 are both low negative numbers, this product is a high positive number).
        // we're going to start at the 3rd item (at index 2)
        // so pre-populate highests and lowests based on the first 2 items.
        int highest = Math.max(A[0], A[1]);
        int lowest  = Math.min(A[0], A[1]);

        int highestProductOf2 = A[0] * A[1];
        int lowestProductOf2  = A[0] * A[1];

        // except this one--we pre-populate it for the first *3* items.
        // this means in our first pass it'll check against itself, which is fine.
        int highestProductOf3 = A[0] * A[1] * A[2];

        // walk through items, starting at index 2
        for (int i = 2; i < A.length; i++) {
            int current = A[i];

            // do we have a new highest product of 3?
            // it's either the current highest,
            // or the current times the highest product of two
            // or the current times the lowest product of two
            highestProductOf3 = Math.max(Math.max(
                    highestProductOf3,
                    current * highestProductOf2),
                    current * lowestProductOf2);

            // do we have a new highest product of two?
            highestProductOf2 = Math.max(Math.max(
                    highestProductOf2,
                    current * highest),
                    current * lowest);

            // do we have a new lowest product of two?
            lowestProductOf2 = Math.min(Math.min(
                    lowestProductOf2,
                    current * highest),
                    current * lowest);

            // do we have a new highest?
            highest = Math.max(highest, current);

            // do we have a new lowest?
            lowest = Math.min(lowest, current);
        }

        return highestProductOf3;
    }
}
