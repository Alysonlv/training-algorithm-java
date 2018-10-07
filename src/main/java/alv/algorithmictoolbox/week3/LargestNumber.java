package alv.algorithmictoolbox.week3;
/*
 * Created by alysonlv - 07/10/2018
 */

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    private static Comparator<String> comparator = (s1, s2) -> (s2 + s1).compareTo(s1 + s2);

    private static String largestNumber(String[] a) {
        String[] arr = new String[a.length];
        for(int i = 0; i < a.length; i++){
            arr[i] = String.valueOf(a[i]);
        }

        Arrays.sort(arr, comparator);

        StringBuilder sb = new StringBuilder();

        for(String s : arr){
            sb.append(s);
        }

        while(sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String[] a = {"23","39","92"};
        System.out.println(largestNumber(a));
    }
}
