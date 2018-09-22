package alv.hackerrank.cracking;
/*
 * Created by Alyson Vasconcelos - 24/05/2018
 */

import java.util.ArrayList;
import java.util.List;

public class RansomNote {

    public static void main(String[] args) {
        String[] magazineItems = {"give", "me", "one", "grand", "today", "night"};

        String[] ransomItems = {"give", "one", "grand", "today"};

        List<String> magazineList = new ArrayList<>();
        for (String word : magazineItems) {
            magazineList.add(word);
        }

        String note = "Yes";
        for (String word : ransomItems) {
            if (!checkWord(magazineList, word)) {
                note = "No";
                break;
            }
        }
        System.out.println(note);

    }

    static boolean checkWord(List<String> list, String word) {
        return list.remove(word);
    }
}
