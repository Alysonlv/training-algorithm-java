package alv.others.algorithms.sorting;
/*
 * Created by alysonlv - 22/09/2018
 */

public class Recursion {

    public static int factorial(int n) {

        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Factorial of 3 is " + factorial(3));
    }
}
