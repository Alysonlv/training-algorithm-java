package alv.algorithmictoolbox.week3;
/*
 * Created by alysonlv - 07/10/2018
 */

import java.util.*;

public class CoveringSegments {

    private static Comparator<Segment> comparator = (s1, s2) -> s1.end - s2.end;

    private static int[] optimalPoints(Segment[] segments) {
        // sort the segments according to their right end
        Arrays.sort(segments, comparator);

        List<Integer> listOfPoints = new ArrayList<>();
        int i = 0, n = segments.length;
        while (i < n) {
            int right = segments[i].end;
            listOfPoints.add(right);
            // BZ: must fix `right` since i is increasing
            while (i < n &&  segments[i].start <= right &&
                    right <= segments[i].end)
                i++;
        }

        int[] points = new int[listOfPoints.size()];
        for(int j = 0; j < listOfPoints.size(); j++)
            points[j] = listOfPoints.get(j);
        return points;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
        scanner.close();
    }
}
