package com.interviewprep.LinkedList;

public class MergeLists {

    public LinkedListNode mergeTwoLists(LinkedListNode l1, LinkedListNode l2) {

        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }

        return dummy.next;
    }

    public LinkedListNode mergeTwoListsRecursive(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.data < l2.data) {
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        MergeLists mergeLists = new MergeLists();
        LinkedListNode l1 = new LinkedListNode(1);
        l1.next = new LinkedListNode(2);
        l1.next.next = new LinkedListNode(4);


        LinkedListNode l2 = new LinkedListNode(1);
        l2.next = new LinkedListNode(3);
        l2.next.next = new LinkedListNode(4);

        LinkedListNode result = mergeLists.mergeTwoLists(l1, l2);
        while (result != null) {
            System.out.println(result.data);
            result = result.next;
        }

    }
}
