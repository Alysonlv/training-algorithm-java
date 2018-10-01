package alv.algorithmictoolbox.week3;
/*
 * Created by alysonlv - 29/09/2018
 */

public class Video3CarFueling {

    public static int getMinRefills(int[] gasStationsPoints, int autonomy) {
        int numRefills = 0, currentRefill = 0;

        for (int i = 0; i < gasStationsPoints.length; i++) {
            int lastRefill = currentRefill;
            currentRefill = gasStationsPoints[i] - lastRefill;

            if (currentRefill < autonomy) {
                currentRefill = lastRefill;
            } else if ((gasStationsPoints[i] - gasStationsPoints[i - 1]) < autonomy) {
                currentRefill = gasStationsPoints[i - 1];
                numRefills++;
            } else {
                return -1;
            }
        }

        return numRefills;
    }

    public static int getMinRefills2(int[] gasStationsPoints, int autonomy) {
        int lastRefill = 0;
        int current = 0;
        int refills = 0;

        while (current < gasStationsPoints.length - 1) {

            if (gasStationsPoints[current + 1] - gasStationsPoints[current] > autonomy) {
                return 0;
            }

            if (lastRefill + autonomy < gasStationsPoints[current + 1]) {
                lastRefill = gasStationsPoints[current];
                refills++;
            }

            current++;
        }

        return refills;
    }

    public static void main(String[] args) {

        int[] stops = new int[] {200, 375, 550, 750, 950};
        System.out.println("Minimum refill possible is " + getMinRefills(stops, 400));

        stops = new int[] {200, 375, 550, 750, 950, 1025};
        System.out.println("Minimum refill possible is " + getMinRefills(stops, 400));

        stops = new int[] {200, 375, 550, 750, 950, 1025, 1200};
        System.out.println("Minimum refill possible is " + getMinRefills(stops, 400));

        stops = new int[] {200, 375, 550, 750, 950, 1025, 1900};
        System.out.println("Minimum refill possible is " + getMinRefills(stops, 400));

        System.out.println("\n With While");
        stops = new int[] {200, 375, 550, 750, 950};
        System.out.println("Minimum refill possible is " + getMinRefills2(stops, 400));

        stops = new int[] {200, 375, 550, 750, 950, 1025};
        System.out.println("Minimum refill possible is " + getMinRefills2(stops, 400));

        stops = new int[] {200, 375, 550, 750, 950, 1025, 1200};
        System.out.println("Minimum refill possible is " + getMinRefills2(stops, 400));

        stops = new int[] {200, 375, 550, 750, 950, 1025, 1900};
        System.out.println("Minimum refill possible is " + getMinRefills2(stops, 400));
    }
}
