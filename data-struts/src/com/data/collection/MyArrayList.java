package com.data.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyArrayList<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY=10;

    private int theSize;

    private T[] theItems;

    public MyArrayList(){
        clear();
    }

    public void clear() {
        theSize=0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public boolean isEmpty(){
        return theSize == 0;
    }

    public void trimToSize(){
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public T get(int index){
        if(index<0 || index >= theSize){
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[index];
    }

    public T set(int index, T newVal){
        if(index< 0 || index>= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        T old = theItems[index];
        theItems[index] = newVal;

        return old;
    }

    /**
     * 向链表插入一个元素
     * @param index
     * @param data
     */
    public void add(int index, T data){
        //判断链表的容量是否满了
        if(this.theItems.length==this.theSize){
            ensureCapacity(size()*2+1);
        }

        for(int i=size();i>index;i--){
            this.theItems[i]=this.theItems[i-1];
        }
        this.theItems[index]= data;
        this.theSize++;
    }

    public boolean add(T data){
        add(size(), data);
        return true;
    }

    /**
     * 移除值
     * @param index
     * @return
     */
    public T remove(int index){
        T removeItem = this.theItems[index];

        for(int i = index; i< size()-1; i++){
            theItems[i]=theItems[i+1];
        }

        theSize--;
        return removeItem;
    }



    private void ensureCapacity(int defaultCapacity) {
        if(defaultCapacity < theSize){
            return;
        }
        T[] old= theItems;
        theItems = (T[]) new Object[defaultCapacity];

        for(int i=0;i<size(); i++){
            theItems[i]=old[i];
        }


    }

    public int size(){
        return theSize;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public class ArrayListIterator implements Iterator<T>{

        private int current=0;

        @Override
        public boolean hasNext() {

            return current<size();
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }

            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(current--);
        }
    }


    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
