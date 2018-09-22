package alv.codility.Lessons.lesson04_CountingElements;
/*
 * Created by alysonlv - 26/05/2018
 *
 * https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 *
A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.

You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.

The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.

For example, you are given integer X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.
 */

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

    public static void main(String[] args) {

        System.out.println(" Solution 1 = "+ solution(5, new int[]{1,3,1,4,2,3,5,4}));
        System.out.println(" Solution 2 = "+ solution2(5, new int[]{1,3,1,4,2,3,5,4}));

    }

    static int solution(int X, int[] A) {
        int[] way = new int[X + 1];
        int steps = 0;

        for (int i = 0; i < A.length; i++) {
            //Add the step filled, in the example we are saying that at i = 0, we are marking that the step 1 show up
            //to fill the way
            if (way[A[i]] == 0) {
                way[A[i]] = A[i];
                //Count how many steps was possible to fill
                steps += 1;
                //If all steps was filled so we got the other side
                //Return i to answer the time
                if (steps == X){
                    return i;
                }
            }
        }

        return -1;
    }

    static int solution2 (int X, int[] A) {
        if (A.length < X)
            return -1;

        //Use the Set collection because will accept only uniques steps
        //and use HashSet implementation because has better performance to add
        Set<Integer> way = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            // Will add each step to the 'way'' and will accept uniques step
            //To each step add decreases one from X (final step)
            if (way.add(A[i]))
                X--;
            //Once the X get at 0 we have our final step and the final second
            if (X == 0)
                return i;
        }

        //If we never done all steps so was impossible to got the other side
        return -1;
    }
}
