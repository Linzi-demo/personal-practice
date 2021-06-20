package com.grove.leetcode.app.linked;

import com.grove.leetcode.model.ListNode;

public class App92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        int index = 0;
        ListNode preMiddle = new ListNode();
        ListNode middle;
        ListNode preTail = new ListNode();
        ListNode tail;

        ListNode start = new ListNode(-1,head);
        ListNode tmp = start;

        while (tmp!=null) {
            if (index == left -1) {
                preMiddle = tmp;
            }
            if (index == right) {
                preTail = tmp;
            }
            tmp = tmp.next;
            index ++;
        }

        // 断链
        middle = preMiddle.next;
        preMiddle.next = null;

        tail = preTail.next;
        preTail.next = null;

        // 翻转
        ListNode newMiddle = reverse(middle);

        preMiddle.next = newMiddle;
        middle.next = tail;

        return start.next;
    }

    private ListNode reverse(ListNode middle) {
        if (middle == null || middle.next == null) {
            return middle;
        }
        ListNode tmp = reverse(middle.next);

        middle.next.next = middle;
        middle.next = null;
        return tmp;
    }

    public static void main(String[] args) {
        App92 app92 = new App92();
        app92.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4);
    }
}
