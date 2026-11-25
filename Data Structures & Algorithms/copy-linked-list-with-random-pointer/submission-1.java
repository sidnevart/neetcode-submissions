/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        Map<Node, Node> deepCopies = new HashMap<>();
        Node deepCopyHead = visit(head, deepCopies);
        return deepCopyHead;



    }

    public Node visit(Node node, Map<Node, Node> deepCopies){
        if (deepCopies.containsKey(node)){
            return deepCopies.get(node);
        }

        Node deepCopy;
        deepCopy = new Node(node.val);
        deepCopies.put(node, deepCopy);

        if (node.next == null){
            deepCopy.next = null;
        } else {
            Node nextNode = visit(node.next, deepCopies);
            deepCopy.next = nextNode;
        }

        if (node.random == null){
            deepCopy.random = null;
        } else {
            Node randomNode = visit(node.random, deepCopies);
            deepCopy.random = randomNode;
        }

        return deepCopy;
    }

}
