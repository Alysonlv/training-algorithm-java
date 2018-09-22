package alv.codility.Lessons.lesson01_Iterations;
/*
 * Created by Alyson Vasconcelos - 05/05/2018
 */

/*
Original: https://app.codility.com/programmers/lessons/1-iterations/binary_gap/

A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.

Assume that:

N is an integer within the range [1..2,147,483,647].

Copyright 2009–2018 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
     */

public class Lesson01_BinaryGap {

    public static void main(String[] args) {
        System.out.println("Lesson01_BinaryGap of 9: " + solution(9));
        System.out.println("Lesson01_BinaryGap of 78: " + solution(78));
        System.out.println("Lesson01_BinaryGap of 15: " + solution(15));
        System.out.println("Lesson01_BinaryGap of 98173944: " + solution(98173944));
        System.out.println("Lesson01_BinaryGap of 434: " + solution(434));
        System.out.println("Lesson01_BinaryGap of 3: " + solution(3));
        System.out.println("Lesson01_BinaryGap of 9873: " + solution(9873));
    }

    public static int solution(int N) {
        String binary = Integer.toBinaryString(N);

        int end = binary.length() - 1;

        while (binary.charAt(end) == '0') {
            end--;
        }

        int binaryGap = 0;
        int cont = 0;
        for (; end >= 0; end--) {
            if (binary.charAt(end) == '1') {
                binaryGap = Math.max(binaryGap, cont);
                cont = 0;
            } else {
                cont++;
            }
        }

        binaryGap = Math.max(binaryGap, cont);

        return binaryGap;
    }
}
