package alv.others;
/*
 * Created by Alyson Vasconcelos - 20/05/2018
 */

import java.util.*;

public class BallotBoxElection {

    public static void main(String[] args) {

        String[] votes = {
                "Alyson Vasconcelos",
                "George Martin",
                "Stephen King",
                "Rob Stark" +
                "Neil Gaiman",
                "Douglas Adams",
                "J. R. R. Tolkien",
                "King Arthur",
                "King Arthur",
                "King Arthur",
                "George Martin",
                "George Martin",
                "Neil Gaiman",
                "Douglas Adams",
                "J. R. R. Tolkien",
                "Douglas Adams",
                "J. R. R. Tolkien",
                "Douglas Adams",
                "J. R. R. Tolkien",
                "Douglas Adams",
                "J. R. R. Tolkien",
                "George Martin",
                "George Martin",
                "George Martin",
                "Neil Gaiman",
                "Neil Gaiman",
                "Neil Gaiman",
                "Neil Gaiman"
        };

        System.out.println(electionWinner(votes));

    }

    /*
    In elections that use the ballot box system for voting, each writes the name of a candidate on a ballot places it in
    the ballot box. The candidate with the highest number of votes wins the election. If two candidates have the same
    number of votes, then the tied candidates names are ordered alphabetically and the last name in the
    alphabetical order wins.
     */
    static String electionWinner(String[] votes) {

        Map<String, Integer> count = new HashMap<>();
        int maxVotes = 0;

        for (int i = 1; i < votes.length; i++) {

            int vote = 0;
            if (count.containsKey(votes[i])) {
                vote = count.get(votes[i]);
            }
            count.put(votes[i], ++vote);
            maxVotes = Math.max(maxVotes,  vote);
        }

        List<String> names = new ArrayList<>();
        Iterator it = count.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>)it.next();
            if (maxVotes == pair.getValue()) {
                names.add(pair.getKey());
            }
        }

        Collections.sort(names);


        return names.get(names.size() - 1);
    }
}
