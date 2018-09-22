package alv.codility.Lessons.lesson03_TimeComplexity;
/*
A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to
get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.

Count the minimal number of jumps that the small frog must perform to reach its target.
 */

/*
 * Created by Alyson Vasconcelos - 05/05/2018
 */

public class Lesson05_FrogJump {

    public static void main(String[] args) {
        System.out.println(solution(10, 85, 30));
        System.out.println(solution(7, 185, 7));
        System.out.println(solution(1, 436789, 3));
    }

    public static int solution(int X, int Y, int D) {
        int resp = (Y - X) / D;
        if((Y-X) % D == 0) {
            return resp;
        } else {
            return ++resp;
        }
    }
}
