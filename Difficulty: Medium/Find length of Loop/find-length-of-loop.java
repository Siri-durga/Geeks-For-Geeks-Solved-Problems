class Solution {
    public int lengthOfLoop(Node head) {
        if (head == null || head.next == null) return 0;
        
        Node slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;         // move 1 step
            fast = fast.next.next;    // move 2 steps
            
            // loop detected
            if (slow == fast) {
                return countNodesInLoop(slow);
            }
        }
        
        return 0; // no loop
    }
    
    private int countNodesInLoop(Node node) {
        int count = 1;
        Node temp = node.next;
        
        while (temp != node) {
            count++;
            temp = temp.next;
        }
        
        return count;
    }
}
