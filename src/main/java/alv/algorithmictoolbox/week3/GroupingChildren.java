package alv.algorithmictoolbox.week3;
/*
 * Created by alysonlv - 01/10/2018
 */

import java.util.Arrays;

public class GroupingChildren {

    public static int getGroupingChildren(float[] children) {

        int lastChild = children.length;
        int currentChild = 1;
        int startingPoint = 0;
        int groups = 0;

        //Arrays.sort(children);

        while(currentChild < lastChild){

            if (children[currentChild] - children[startingPoint] > 1) {
                startingPoint = currentChild;
                groups++;
            }


            if(currentChild == lastChild - 1){
                groups++;
            }

            currentChild++;
        }


        return groups;
    }

    public static void main(String[] args) {
        float[] kids = new float[] {2.5f, 3.2f, 3.5f, 4.0f, 4.8f, 5.2f, 6.0f};

        System.out.println(getGroupingChildren(kids));
    }
}
