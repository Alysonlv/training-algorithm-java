package alv.commons;
/*
 * Created by alysonlv - 22/09/2018
 */

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Commons {


    public static int[] getArrayOfInt(int size, int maxValue) {
        Random randNumGenerator = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (randNumGenerator.nextInt(maxValue));
        }

        return array;
    }

    public static String[] getArrayOfString(int size, boolean useDigits) {
        RandomString gen = new RandomString(8, false);
        String[] array = new String[size];

        for (int i = 0; i < size; i++) {
            array[i] = gen.nextString();
        }

        return array;
    }

    public static void main(String[] args) {
        System.out.println("Random Array of Int = " + Arrays.toString(getArrayOfInt(1000, 100)));

        RandomString gen = new RandomString(8, false);

        System.out.println(gen.nextString());

        System.out.println(Arrays.toString(getArrayOfString(10, false)));
    }
}


