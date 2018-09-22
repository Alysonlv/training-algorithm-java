package alv.interviewcake;
/*
 * Created by alysonlv - 21/08/2018
 */

public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedListNode headNode = new LinkedListNode(1);
        headNode.next = new LinkedListNode(2);
        headNode.next.next = new LinkedListNode(3);
        headNode.next.next.next = new LinkedListNode(4);

        LinkedListNode finalNode = reverse(headNode);

        System.out.println(finalNode.toString());
    }

    public static LinkedListNode reverse(LinkedListNode headNode) {
        LinkedListNode current = headNode;
        LinkedListNode previous = null;
        LinkedListNode next = null;

        //Control when we get at the end of original list
        while (current != null) {
            //copy the node to the next
            next = current.next;

            //reverse the next node
            //-- this means at the first interaction we setting as null marking this way the end of the reverse list
            current.next = previous;

            //step forward in the list
            //-- this menas at the first interaction we getting the original head and moving back
            previous = current;
            current = next;
        }

        return previous;
    }
}

class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }

}
