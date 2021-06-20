package com.grove.leetcode.app.linked;

import com.grove.leetcode.model.ListNode;

/**
 * 143. 重排链表
 */
public class App143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // 获取中间节点
        ListNode middleNode = getMiddle(head);
        ListNode list2 = middleNode.next;
        // 截断
        middleNode.next = null;

        // 翻转链表
        list2 = reverse(list2);

        // 合并两个链表
        merge(head, list2);
    }

    private void merge(ListNode l1, ListNode l2) {
        ListNode l1Tmp;
        ListNode l2Tmp;
        while (l1!=null && l2!=null) {
            l1Tmp = l1.next;
            l1.next = l2;
            l1 = l1Tmp;

            l2Tmp = l2.next;
            l2.next = l1;
            l2 = l2Tmp;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = pre;
            pre = current;
            current = nextTemp;
        }
        return pre;
    }

    private ListNode reverse2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reverse = reverse2(head.next);

        head.next.next = head;
        head.next = null;

        return reverse;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
