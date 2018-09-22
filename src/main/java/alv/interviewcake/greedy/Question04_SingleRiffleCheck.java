package alv.interviewcake.greedy;
/*
 * Created by alysonlv - 11/06/2018
 */

import java.util.Arrays;

public class Question04_SingleRiffleCheck {

    public static void main(String[] args) {

        System.out.println(isSingleRiffle(
                new int[] {1,2,3,},
                new int[] {4,5,6},
                new int[] {1,2,3,4,5,6}
                ));
        System.out.println(isSingleRiffle2(
                new int[] {1,2,3,},
                new int[] {4,5,6},
                new int[] {1,2,3,4,5,6}
        ));



        System.out.println(isSingleRiffle(
                new int[] {1,2,3,},
                new int[] {4,5,6},
                new int[] {1,2,3,4,5,6,7}
        ));
        System.out.println(isSingleRiffle2(
                new int[] {1,2,3,},
                new int[] {4,5,6},
                new int[] {1,2,3,4,5,6,7}
        ));

    }
//--FIRST SOLUTION
    //This will recreate the array without the fist element
    private static int[] removeTopCard(int[] cards) {
        return Arrays.copyOfRange(cards, 1, cards.length);
    }

    public static boolean isSingleRiffle(int[] half1, int[] half2, int[] shuffledDeck) {

        // base case
        if (shuffledDeck.length == 0) {
            return true;
        }

        // if the top of shuffledDeck is the same as the top of half1
        // (making sure first that we have a top card in half1)
        if (half1.length > 0 && half1[0] == shuffledDeck[0]) {

            // take the top cards off half1 and shuffledDeck and recurse
            return isSingleRiffle(removeTopCard(half1), half2, removeTopCard(shuffledDeck));

            // if the top of shuffledDeck is the same as the top of half2
        } else if (half2.length > 0 && half2[0] == shuffledDeck[0]) {

            // take the top cards off half2 and shuffledDeck and recurse
            return isSingleRiffle(half1, removeTopCard(half2), removeTopCard(shuffledDeck));

            // top of shuffledDeck doesn't match top of half1 or half2
            // so we know it's not a single riffle
        } else {
            return false;
        }
    }


//--SECOND SOLUTION
    public static boolean isSingleRiffle2(int[] half1, int[] half2, int[] shuffledDeck) {
        int half1Index = 0;
        int half2Index = 0;

        for (int card : shuffledDeck) {

            // if we still have cards in half1
            // and the "top" card in half1 is the same
            // as the top card in shuffledDeck
            if (half1Index < half1.length && card == half1[half1Index]) {
                half1Index++;

                // if we still have cards in half2
                // and the "top" card in half2 is the same
                // as the top card in shuffledDeck
            } else if (half2Index < half2.length && card == half2[half2Index]) {
                half2Index++;

                // if the top card in shuffledDeck doesn't match the top
                // card in half1 or half2, this isn't a single riffle.
            } else {
                return false;
            }
        }

        // all cards in shuffledDeck have been "accounted for"
        // so this is a single riffle!
        return true;
    }
}
