package io.fengchao.utils;

public class ListNode {
    int val;
    ListNode pre;
    ListNode next;

    public ListNode(int val, ListNode pre, ListNode next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }
}
