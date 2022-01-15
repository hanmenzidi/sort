package com.sort.study.lihan.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @Author: lihan
 * @Date : 2022/1/13- 01
 * @DESCRIPTION: com.sort.study.lihan.heap
 * @version: 1.0
 */
public class MyMaxHeap<T> {
    private ArrayList<T> heap;
//记录样本在堆上的位置
    private HashMap<T,Integer> indexMap;
    private int heapSize;
    private Comparator<? super T>comparator;
    public MyMaxHeap(Comparator<? super  T> comparator){
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        heapSize = 0;
        this.comparator = comparator;
    }

    public boolean isEmpty(){
        return heapSize == 0;
    }
    public  int Size(){
        return heapSize;
    }
    public boolean contains(T key){
        return indexMap.containsKey(key);
    }
    public void push(T val){
        heap.add(val);
        indexMap.put(val,heapSize);
        heapInsert(heapSize++);

    }
    public T pop(){
        T result = heap.get(0);
        int end = heapSize-1;
        swap(0,end);
        heap.remove(end);
        indexMap.remove(result);
        heapfy(0,--heapSize);
        return result;

    }

    public void resign(T val){
        int valIndex = indexMap.get(val);
        heapInsert(valIndex);
        heapfy(valIndex,heapSize);
    }
    public void heapInsert(int index){
        while (comparator
                .compare(heap.get(index),heap.get((index-1)/2))<0){
            swap(index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    public void swap(int firstIndex, int lastIndex){
        T o1 = heap.get(firstIndex);
        T o2 = heap.get(lastIndex);
        heap.set(firstIndex,o2);
        heap.set(lastIndex,o1);
        indexMap.put(o1,lastIndex);
        indexMap.put(o2,firstIndex);


    }

    public void  heapfy(int index, int heapSize){
        int left = index*2 -1;
        while (left < heapSize){

        }
    }

}
