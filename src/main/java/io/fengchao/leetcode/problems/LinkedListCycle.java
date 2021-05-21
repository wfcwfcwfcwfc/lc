package io.fengchao.leetcode.problems;

public class LinkedListCycle {
    public static void main(String[] args) {
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        ListNode node1  = new ListNode(3);
        ListNode node2  = new ListNode(2);
        ListNode node3  = new ListNode(0);
        ListNode node4  = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        ListNode ans = linkedListCycle.detectCycle(node1);
        System.out.println(ans.val);
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            if(fast == slow) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast == null || fast.next == null) {
            return null;
        }

        slow = head;

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }


}
