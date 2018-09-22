package alv.interviewcake.sortingsearchinglogarithms;
/*
 * Created by alysonlv - 22/09/2018
 */

public class FindRotationPoint {

    private static final   String[] words = new String[]{
            "ptolemaic",
            "retrograde",
            "supplant",
            "undulate",
            "xenoepist",
            "asymptote",  // <-- rotates here!
            "babka",
            "banoffee",
            "engender",
            "karpatka",
            "othellolagkage",
    };

    public static int findRotationPoint(String[] words) {
        final String firstWord = words[0];

        int floorIndex = 0;
        int ceilingIndex = words.length - 1;

        while (floorIndex < ceilingIndex) {

            // guess a point halfway between floor and ceiling
            int guessIndex = floorIndex + ((ceilingIndex - floorIndex) / 2);

            // if guess comes after first word or is the first word
            if (words[guessIndex].compareTo(firstWord) >= 0) {
                // go right
                floorIndex = guessIndex;
            } else {
                // go left
                ceilingIndex = guessIndex;
            }

            // if floor and ceiling have converged
            if (floorIndex + 1 == ceilingIndex) {

                // between floor and ceiling is where we flipped to the beginning
                // so ceiling is alphabetically first
                break;
            }
        }

        return ceilingIndex;
    }

    public static void main(String[] args) {
        System.out.println(findRotationPoint(words));
        System.out.println(findRotationPoint(new String[] {"cape", "cake"}));
        System.out.println(findRotationPoint(new String[] {"grape", "orange", "plum",
                "radish", "apple"}));
        System.out.println(findRotationPoint(new String[] {"ptolemaic", "retrograde", "supplant", "undulate", "xenoepist",
                "asymptote", "babka", "banoffee", "engender", "karpatka", "othellolagkage"}));
    }

}
