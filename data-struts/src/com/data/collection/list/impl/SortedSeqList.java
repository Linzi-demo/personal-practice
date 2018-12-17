package com.data.collection.list.impl;

/**
 * 排序顺序表
 * @param <T>
 */
public class SortedSeqList<T extends Comparable<? super T>> extends SeqList<T> {
    /**
     * 构造空排序顺序表
     */
    public SortedSeqList(){
        super();
    }

    /**
     * 构造空排序顺序表，容量为length
     * @param length
     */
    public SortedSeqList(int length){
        super(length);
    }

    /**
     * 构造排序顺序表，元素由数组提供
     * @param values
     */
    public SortedSeqList(T[] values){
        super(values.length);
        for(int i=0; i<values.length; i++){
            this.insert(values[i]); //按照元素的大小插入顺序表，需要覆盖父类的insert方法
        }
    }

    @Override
    public int insert(T x) {
        int i=0;
        //判断是否是最大值，最大值在尾部插入，O(1)
        if(this.isEmpty() || x.compareTo(this.get(this.size()-1))>0){
            i=this.n;
        } else{
            while(i<this.size() && x.compareTo(this.get(i))>0){
                i++;
            }
        }

        super.insert(i,x);

        return i;
    }

    //对于不支持父类的方法，可以覆盖并抛出异常
    @Override
    public int insert(int i, T x) {
        throw new UnsupportedOperationException("insert(int i, T x)");
    }


    @Override
    public void set(int i, T x) {
        throw new UnsupportedOperationException("set(int i, T x)");
    }

    /**
     * 顺序表查找首次出现的key
     * @param key
     * @return
     */
    @Override
    public int search(T key) {
        for(int i=0; i<this.n && key.compareTo(this.get(i))>=0;i++){
            if(key.compareTo(this.get(i))==0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除首次出现的key
     * @param key
     * @return
     */
    @Override
    public T remove(T key) {
        return this.remove(this.search(key));
    }
}
