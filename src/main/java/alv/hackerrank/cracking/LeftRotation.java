package alv.hackerrank.cracking;
/*
 * Created by Alyson Vasconcelos - 09/05/2018
 */

import java.util.Scanner;

public class LeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int rotations = in.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++) {
            if(rotations > i)
                arr[size - rotations + i] = in.nextInt();
            else
                arr[i - rotations] = in.nextInt();
        }

        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

    }


    public static int[] leftRotate(int[] elements, int n)
    {

        for (int r = 0; r < n % elements.length; r++) {
            int buffer = elements[0];
            for(int i = 0; i < elements.length -1; i++) {
                elements[i] = elements[i+1];
            }

            elements[elements.length-1] = buffer;
        }

        return elements;
    }

}
