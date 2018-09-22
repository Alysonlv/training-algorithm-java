package alv.hackerrank.cracking;
/*
 * Created by alysonlv - 25/05/2018
 */

public class LinkedListCycleNode {

    public static void main(String[] args) {
        NodeCycle case1 = new NodeCycle();
        case1.data = 1;

        System.out.println("Case 1 has a cycle? "+ hasCycle(case1));

        NodeCycle case2 = new NodeCycle();
        case2.data = 1;
        NodeCycle case2_2 = new NodeCycle();
        case2.next = case2_2;
        case2_2.data = 2;
        NodeCycle case2_3 = new NodeCycle();
        case2_2.next = case2_3;
        case2_3.data = 3;
        case2_3.next = case2_2;

        System.out.println("Case 2 has a cycle? "+ hasCycle(case2));

        NodeCycle case3 = new NodeCycle();
        NodeCycle case3_2 = new NodeCycle();
        NodeCycle case3_3 = new NodeCycle();
        NodeCycle case3_4 = new NodeCycle();

        case3.next = case3_2;
        case3_2.next = case3_3;
        case3_3.next = case3_4;
        System.out.println("Case 3 has a cycle? "+ hasCycle(case3));
    }
    /*
    [NODE 1] -> NULL {There are no cycle}
    [NODE 1] -> [NODE 2] -> [NODE 3] -> [NODE 2] (literally the same node 2) {So we have a cycle, because the NODE 2
                                                                                show up again after NODE 3}
     */

    static boolean hasCycle(NodeCycle head) {
        //First condition
        if (head == null){
            return false;
        }

        NodeCycle current = head;
        NodeCycle next = head;

        //The loop will analyze if the current node has a cycle
        while(current != null && current.next != null) {
            //Now we get next node
            current = current.next;
            next = next.next.next;

            //if they are null so we don't have a cycle at all and stop the loop
            if(next == null || current == null) {
                return false;
            }
            //If they are the same so we have a cycle and can stop the loop
            if(next == current){
                return true;
            }
        }

        return false;

    }
}

class NodeCycle {
    int data;
    NodeCycle next;
}
