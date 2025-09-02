/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node swapKth(Node head, int k) {
        if (head == null) return null;

        // Step 1: Find length
        int n = 0;
        Node temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // If k is more than length
        if (k > n) return head;

        // If kth from beginning and end are same node
        if (2 * k - 1 == n) return head;

        // Step 2: Find kth node from start
        Node prevX = null, x = head;
        for (int i = 1; i < k; i++) {
            prevX = x;
            x = x.next;
        }

        // Step 3: Find kth node from end (i.e., (n-k+1)th from start)
        Node prevY = null, y = head;
        for (int i = 1; i < (n - k + 1); i++) {
            prevY = y;
            y = y.next;
        }

        // Step 4: Swap previous links
        if (prevX != null) prevX.next = y;
        if (prevY != null) prevY.next = x;

        // Step 5: Swap next pointers
        Node tempNext = x.next;
        x.next = y.next;
        y.next = tempNext;

        // Step 6: Fix head if needed
        if (k == 1) head = y;
        if (k == n) head = x;

        return head;
    }
}
