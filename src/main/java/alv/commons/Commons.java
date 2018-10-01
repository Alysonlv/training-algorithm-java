package alv;
/*
 * Created by alysonlv - 22/09/2018
 */

import java.util.Arrays;
import java.util.Random;

public class Commons {


    public static int[] getArrayOfInt(int size, int maxValue) {
        Random randNumGenerator = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (randNumGenerator.nextInt(maxValue));
        }

        return array;
    }

    public static void main(String[] args) {
        System.out.println("Random Array of Int = " + Arrays.toString(getArrayOfInt(1000, 100)));
    }
}
