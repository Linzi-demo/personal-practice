package com.grove.leetcode.app.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存机制
 */
public class LRUCache {
    Map<Integer, LNode> map = new HashMap<>();

    int max;

    LNode head;

    LNode tail;

    public LRUCache(int capacity) {
        max = capacity;
        head = new LNode();
        tail = new LNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        LNode node = map.get(key);

        //移动到头部
        moveToHead(node);

        return node.value;
    }

    private void moveToHead(LNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

        insert(node);
    }

    private void insert(LNode node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    public void put(int key, int value) {
        LNode node = map.get(key);
        if (node !=null) {
            node.value = value;
            moveToHead(node);
            return;
        }

        if (map.size() == max) {
            // 删除尾巴节点
            LNode last = tail.pre;
            map.remove(last.key);
            last.pre.next = last.next;
            last.next.pre = last.pre;
            last.next = null;
            last.pre = null;
        }
        node = new LNode(key, value);
        insert(node);
        map.put(key, node);
    }

    class LNode {
        public int key;

        public int value;

        public LNode pre;

        public LNode next;

        public LNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public LNode() {
        }
    }
}
