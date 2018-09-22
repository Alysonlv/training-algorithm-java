package alv.hackerrank.cracking;
/*
 * Created by Alyson Vasconcelos - 22/05/2018
 */

public class IsBinarySearchTree {

    public static void main(String[] args) {

        Node root = new Node();
        root.data = 1;

        Node n = new Node();
        n.data = 0;
        root.left = n;
        n = new Node();
        n.data = 2;
        root.right = n;

        System.out.println(validateNode(root));

    }

    static boolean validateNode(Node node) {
        return check(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean check(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.data < min || node.data > max) {
            return false;
        }

        return check(node.left, min, node.data) && check(node.right, node.data, max);
    }

}

class Node {
    int data;
    Node left;
    Node right;
}
