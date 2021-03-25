package com.grove.leetcode.app;

import com.grove.leetcode.model.ListNode;

/**
 * 147. 对链表进行插入排序
 */
public class App147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummpyHead = new ListNode(0);
        dummpyHead.next = head;

        ListNode sorted = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur.val >= sorted.val) {
                sorted = sorted.next;
                cur = sorted.next;
                continue;
            }

            ListNode preNode = dummpyHead;
            while (preNode.next.val <= cur.val) {
                preNode = preNode.next;
            }
            sorted.next = cur.next;
            cur.next = preNode.next;
            preNode.next = cur;

            cur = sorted.next;
        }

        return dummpyHead.next;

    }
}
