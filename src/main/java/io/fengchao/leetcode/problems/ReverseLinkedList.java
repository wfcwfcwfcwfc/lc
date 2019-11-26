package io.fengchao.leetcode.problems;

import static jdk.nashorn.internal.objects.Global.print;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode res = reverseLinkedList.reverseRecursive(node1);
        reverseLinkedList.printList(res);

    }

    private ListNode reverseRecursive(ListNode head) {
        if(head.next == null) {
            return head;
        }
        ListNode newHead = reverseRecursive(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;
        return newHead;
    }

    private void printList(ListNode head) {
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
