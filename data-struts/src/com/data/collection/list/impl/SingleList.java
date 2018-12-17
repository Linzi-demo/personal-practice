package com.data.collection.list.impl;

import com.data.collection.data.Node;

/**
 * 单链表简单实现
 * 1. 不是随机存取结构
 * 2. 插入删除后继节点的时间是O(1),插入删除前驱节点或者自己的时间是O(n)
 * 3. 插入或删除的时间都花在查找
 * @param <T>
 */
public class SingleList<T> {
    public Node<T> head;

    /**
     * 构造空单链表，头节点数据域和地址域均为null
     */
    public SingleList(){
        this.head=new Node<T>();
    }

    public SingleList(T[] values){
        this();
        Node<T> rear=this.head;
        for(int i=0;i<values.length;i++){
            rear.next=new Node<T>(values[i],null);
            rear=rear.next;
        }
    }

    /**
     * 判断单链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return this.head.next==null;
    }

    /**
     * 存取
     */
    public T get(int i){
        Node<T> p=this.head.next;
        for(int j=0;p!=null&&j<i;j++){
            p=p.next;
        }
        return (i>=0 && p!=null)?p.data : null;
    }

    public void set(int i, T x){
        Node<T> p=this.head.next;
        for(int j=0;p!=null && j<i;j++){
            p=p.next;
        }
        if(i>=0 && p!=null){
            p.data=x;
        }
    }

    /**
     * 返回单链表的长度
     * @return
     */
    public int size(){
        Node<T> p=this.head.next;
        int j=0;
        for(int i=0; p!=null;i++){
            p=p.next;
            j++;
        }
        return j;
    }

    @Override
    public String toString() {
        String str=this.getClass().getName()+"(";
        //是用节点p来遍历
        for(Node<T> p=this.head.next;p!=null;p=p.next){
            str+=p.data.toString();
            if(p.next!=null){
                str+=",";
            }
        }
        return str+")";
    }

    /**
     * 插入
     */
    public Node<T> insert(int i, T x){
        if(x == null){
            throw new NullPointerException("x == null");
        }
        Node<T> front = this.head;
        //遍历，寻找i-1个节点
        for(int j=0; front!=null && j<i;j++){
            front = front.next;
        }
        front.next=new Node<T>(x,front.next);
        return front.next;
    }

    public Node<T> insert(T x){
        return this.insert(Integer.MAX_VALUE,x);
    }

    /**
     * 删除节点
     */
    public T remove(int i){
        Node<T> front=this.head;
        for(int j=0;front!=null && j<i;j++){
            front = front.next;
        }
        if(i>0 && front.next!=null){
            T old = front.next.data;
            front.next=front.next.next;

            return old;
        }
        return null;
    }

    public void clear(){
        this.head.next=null;
    }


}
