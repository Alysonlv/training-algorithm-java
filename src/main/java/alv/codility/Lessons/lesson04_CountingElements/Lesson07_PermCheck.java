package alv.codility.Lessons.lesson04_CountingElements;
/*
 * Created by Alyson Vasconcelos - 05/05/2018
 */

import java.util.Arrays;

public class Lesson07_PermCheck {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {4,1,3,2}));
        System.out.println(solution(new int[] {4,1,3,}));
    }

    public static int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if (A[i] != (i + 1))
                return 0;
        }

        return 1;
    }
}
