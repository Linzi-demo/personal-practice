package com.data.collection.list.impl;


import com.data.collection.MyArrayList;
import com.data.collection.list.interf.MyList;


/**
 * 顺序表
 * 特点：
 * 静态特性很好，动态特性很差，
 * 随机存取结构，存取元素的时间复杂度是O(1)
 * 插入和删除操作效率低下，因为容量不可变，解决数据溢出的办法（申请一个更大容量的数组），会使得操作效率更低
 *
 * @param <T>
 */
public class SeqList<T> implements MyList<T> {

    protected Object[] element; //对象数组存储顺序表的数据元素

    protected int n; //顺序表的元素个数

    /**
     * 构造容量为length的空表
     * @param length
     */
    public SeqList(int length){
        this.element=new Object[length];

        this.n=0;
    }

    /**
     * 默认构造函数
     */
    public SeqList(){
        this(64);
    }

    public SeqList(T[] values){
        //1. 创建一个values数组长度的空表
        this(values.length);

        //2. 复制数组元素
        for(int i=0; i<values.length; i++){
            this.element[i]=values[i];
        }

        this.n=values.length;


    }


    @Override
    public boolean isEmpty() {
        return this.n==0;
    }

    @Override
    public int size() {
        return this.n;
    }

    @Override
    public T get(int i) {
        if(i>=0 && i<this.n){
            return (T) this.element[i];
        }

        return null;
    }

    @Override
    public void set(int i, T x) {

        if(x==null){
            throw new NullPointerException("x == null");
        }
        if(i>=0 && i<this.n){
            this.element[i]=x;
        }else{
            throw new IndexOutOfBoundsException(i+"");
        }
    }

    @Override
    public int insert(int i, T x) {
        //判断x是否为空，抛出异常
        if(x == null){
            throw new NullPointerException("x == null");
        }
        //容错处理
        if(i<0){
            i=0;
        }
        if(i>this.n){
            i=this.n;
        }
        //判断是否需要扩容
        Object[] source=this.element;
        if(this.element.length==this.n){
            this.element=new Object[source.length*2];
            for(int j=0;j<source.length;j++){
                this.element[j]=source[j];
            }
        }

        for(int j=this.n-1;j>=i;j--){
            this.element[j+1]=this.element[j];
        }

        this.element[i]=x;
        this.n++;
        return i;
    }

    /**
     * 在列表的尾部插入元素
     * @param x
     * @return
     */
    public int insert(T x){
       return insert(this.n, x);
    }


    /**
     * 删除一个元素，并返回
     * @param i
     * @return
     */
    @Override
    public T remove(int i) {
        if(this.n>0 && i>=0 && i<this.n){
            T old = (T) this.element[i];
            for(int j=i; j<this.n-1; j++){
                this.element[j] = this.element[j+1];
            }
            //设置最后一位为空，释放引用实例
            this.element[this.n-1]=null;
            this.n--;
            return old;

        }
        return null;
    }

    @Override
    public void clear() {
        //设置长度为0，未释放所有元素
        this.n=0;
    }

    /**
     * 顺序查找算法，时间复杂度O(n)
     * @param key
     * @return
     */
    @Override
    public int search(T key) {
        for(int i=0; i<this.n; i++){
            if(key.equals(this.element[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object key) {
        return false;
    }

    @Override
    public int insertDifferent(Object x) {
        return 0;
    }

    @Override
    public T remove(T key) {
        return null;
    }

    @Override
    public void addAll(MyArrayList list) {

    }

    @Override
    public String toString() {
        String str=this.getClass().getName()+"(";
        if(this.n>0){
            str+=this.element[0].toString();
        }
        for(int i=1; i<this.n;i++){
            str+=","+this.element[i].toString();
        }
        return str+")";
    }

    /**
     * 反序返回toString
     * @return
     */
    public String toPreviousString(){
        return "";
    }

    /**
     * 顺序表的浅拷贝
     */
//    public SeqList(SeqList<T> list){
//        this.n=list.n;
//        this.element=list.element; //数组是引用类型，两个变量公用一个数组，错误
//    }

    /**
     * 顺序表的深拷贝
     * 这种方法仅仅两个列表分别引用各自的数组，但是数组内的引用对象还是一样
     * 所以数组的插入删除不会影响对方，但是改变某个实例仍将影响
     */
    public SeqList(SeqList<? extends T> list){
        this.n=list.n;
        this.element=new Object[list.element.length];

        for(int i=0;i<list.element.length;i++){
            this.element[i]=list.element[i];
        }

    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj instanceof SeqList<?>){
            SeqList<T> list = (SeqList<T>) obj;
            if(this.n==list.n){
                for(int i=0;i<this.n;i++){
                    if(!this.element[i].equals(list.element[i])){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
