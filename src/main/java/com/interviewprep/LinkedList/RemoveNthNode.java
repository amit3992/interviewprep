package com.interviewprep.LinkedList;

public class RemoveNthNode {

    public LinkedListNode removeNthFromEnd(LinkedListNode head, int n) {

        // Time Complexity: O(n)
        // Space Complexity: O(1)
        if (head == null || head.next == null) {
            return null;
        }

        // Set slow and fast pointers
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        // Move fast pointer n times
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // If fast pointer reaches the end, remove the first node
        if (fast == null) {
            return head.next;
        }

        // Move both pointers until fast pointer reaches the end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // Remove the nth node
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String args[]) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(6);
        head.next.next.next.next.next.next = new LinkedListNode(7);
        int n = 5;
        RemoveNthNode removeNthNode = new RemoveNthNode();
        LinkedListNode result = removeNthNode.removeNthFromEnd(head, n);

        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }
    }
}
