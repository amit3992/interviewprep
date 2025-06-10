package com.interviewprep.LinkedList;

public class ReverseList {

    public LinkedListNode reverseList(LinkedListNode head) {

        // Time Complexity: O(n)
        // Space Complexity: O(1)

        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode prev = null;
        LinkedListNode current = head;
        LinkedListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(6);

        ReverseList reverseList = new ReverseList();
        LinkedListNode reversed = reverseList.reverseList(head);
        System.out.println(reversed.data);
        System.out.println(reversed.next.data);
        System.out.println(reversed.next.next.data);
        System.out.println(reversed.next.next.next.data);
        System.out.println(reversed.next.next.next.next.data);
        System.out.println(reversed.next.next.next.next.next.data);
    }
}
