package io.fengchao.leetcode.problems;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ReverseKLists {
    public static void main(String[] args) {
        ReverseKLists reverseKLists = new ReverseKLists();

        // Prepare test cases
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        reverseKLists.reverseKGroup(node1, 3);
        reverseKLists.print(node1);
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode start = dummy;
        ListNode end = dummy;

        while(true) {
            int counter = k;
            while(end != null && counter >= 0) { //到底走几步 要算清楚 大于还是大于等于零
                end = end.next;
                counter--;
            }
            if(counter != -1) {
                break;
            } //可以用for循环check null
            cur = start.next;
            ListNode pre = start;
            for(int i = 0; i < k; i++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                print(head);
            }
            ListNode newEnd = start.next;
            start.next = pre;
            newEnd.next = end;
            start = pre;
            end = pre;
            print(head);
        }

        return dummy.next;
    }

    private void print(ListNode node) {
        while(node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
