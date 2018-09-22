package alv.codility.Lessons.lesson02_Arrays;
/*
https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

 */

/*
 * Created by Alyson Vasconcelos - 05/05/2018
 */

public class Lesson02_CyclicRotation {

    public static void main(String[] args) {

        print(solution(new int[]{1,2,3,4,5,6,7,8,9,0},1));
        print(solution(new int[]{1,2,3,4,5,6,7,8,9,0},2));
        print(solution(new int[]{1,2,3,4,5,6,7,8,9,0},3));
        print(solution(new int[]{1,2,3,4,5,6,7,8,9,0},4));
        print(solution(new int[]{1,2,3,4,5,6,7,8,9,0},5));
        print(solution(new int[]{1,2,3,4,5,6,7,8,9,0},10));
    }

    public static int[] solution(int[] A, int K) {

//        if (K == A.length || (A.length % K == 0))
//            return A;

        int[] rotationedArray = new int[A.length]; // a new array

        for(int i=0; i < A.length; i++) {
            int new_position = (i + K) % A.length; // using "mod" to do Cyclic Rotation
            rotationedArray[new_position] = A[i]; // put A[i] to the new position
        }

        return rotationedArray;
    }

    private static void print(int[] test) {
        for (int e : test) {
            System.out.print(e + ", ");
        }
        System.out.println(" ");
    }
}
