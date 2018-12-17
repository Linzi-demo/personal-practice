package com.data.collection.list.impl;

import com.data.collection.data.Node;

public class SortedSingleList<T extends Comparable<? super T>> extends SingleList<T> {

    public SortedSingleList(){
        super();
    }

    public SortedSingleList(T[] values){
        super();
        for(int i=0; i<values.length;i++){
            this.insert(values[i]);
        }

    }

    @Override
    public Node<T> insert(T x) {
        Node<T> front=this.head,p=front.next;
        while(p!=null && x.compareTo(p.data)>0){
            front = p;
            p=p.next;
        }
        front.next=new Node<>(x,p);
        return front.next;
    }


}
