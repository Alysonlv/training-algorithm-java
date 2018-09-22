package alv.hackerrank.cracking;
/*
 * Created by Alyson Vasconcelos - 22/05/2018
 */

public class MakingAnagrams {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String a = in.next();
//        String b = in.next();
        System.out.println(numberNeeded("cde", "abcv"));
    }

    public static int numberNeeded(String a, String b) {
        int[] letters = new int[26];
        //First build a map, an array, putting a number 1 in all letters from first word in alphabetical sequence
        for(char c : a.toCharArray()){
            letters[c-'a']++;
        }
        //Then repeat the process with second word but using a -1
        for(char c : b.toCharArray()){
            letters[c-'a']--;
        }
        int result = 0;
        //Now, the letters that can build a anagram are 0, so just sum the absolute value of all others numbers
        //and we have the result
        for(int i : letters){
            result += Math.abs(i);
        }
        return result;
    }
}
