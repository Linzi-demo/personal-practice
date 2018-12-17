package com.data.collection.list.interf;

import com.data.collection.MyArrayList;

/**
 * 线性表抽象数据类型
 */
public interface MyList<T> {
    boolean isEmpty(); //判断线性表是否为空

    int size(); //线性表元素个数

    T get(int i); //返回第i个元素

    void set(int i, T x); //设置第i个元素为x

    String toString();

    int insert(int i, T x); //插入x作为第i个元素，返回x序号

    T remove(int i); //删除第i个元素，返回被删除的元素

    void clear(); //删除线性表所有元素

    int search(T key); //查找首次出现与key相等元素，返回元素的序号

    boolean contains(T key); //判断是否包含关键字key

    int insertDifferent(T x); //插入不重复元素

    T remove(T key); //删除首次出现与key相等的元素，返回被删除的元素

    boolean equals(Object obj); //比较两个线性表种所有的元素对应相等

    void addAll(MyArrayList<T> list); //向this单链表种添加list的所有元素


}
