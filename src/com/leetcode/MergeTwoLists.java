package com.leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode (int x) { val = x; }
}

public class MergeTwoLists {

    public static void main (String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(8);
        ListNode s1 = new ListNode(3);
        ListNode s2 = new ListNode(4);
        ListNode s3 = new ListNode(5);
        ListNode s4 = new ListNode(6);
        ListNode s5 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        ListNode res = mergeTwoLists(l1, s1);
        while (res.next != null) {
            System.out.println(res.val + "->");
            res = res.next;
        }
    }

    public static ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
