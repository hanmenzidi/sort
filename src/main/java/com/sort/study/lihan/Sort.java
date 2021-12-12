package com.sort.study.lihan;
/*
* @author lihan
* @date 2021/12/4
*
* */

import lombok.val;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipEntry;

public class Sort {
    /**
     * 冒泡排序
     * @param arr 待排序的数组
     */

    public static void bubbleSort(int[] arr){
        int arrLen = arr.length;
        for (int i = 0; i < arrLen -1 ; i++) {
            boolean isSwapped= false;
            for (int j = 0; j < arrLen -1 -i  ; j++) {
                int front = arr[j];
                int next  = arr[j +1 ];
                if(front > next){
                     arr[j +1 ] = front;
                     arr[j] = next;
                     isSwapped = true;
                }

            }
            if( !isSwapped) {
                {
                    break;
                }
            }

        }

    }

   //选择排序
    public static void selectSort(int[] arr){
        int len = arr.length;
        //选择次数
        for(int i = 0; i < len-1; i++){
            int maxIndex = 0;
            //选择为排序里面最大的值
            for (int j = 0; j < len -i ; j++) {
                if( arr[j] >= arr[maxIndex]){
                    maxIndex = j;
                }
            }
            int temp = arr[ len-i-1];
            arr[len -i -1] = arr[maxIndex];
            arr[maxIndex] = temp;

        }

    }

  //插入排序
    public static void insertSort(int[] arr){
        int len = arr.length;
        //待排序的元素
        for (int i = 1; i < len ; i++) {
            int val = arr[i];
     //直接放入就有序
            if(val >= arr[i-1])continue;
            for (int j = i-1; j >=0 ; j--) {
                if( val <  arr[j]){
                    arr[j +1] = arr[j];
                }else{
                    arr[j+1] = val;
                    break;
                }
            }

        }

    }

    //归并排序
    /*
    @param: 待排序的数组
    * */

    public static void mergerSort(int[] arr, int start, int end,int[] temp){

        if(start < end){
            int mid = (start + end)/2;
            mergerSort(arr, start, mid, temp);
            mergerSort(arr, mid+1, end, temp);
            hebing(arr,start,end,temp);
        }


    }

    public static void hebing(int[]arr, int start, int end, int[] temp) {
        int mid = (start + end)/2;
        int leftIndex = start;
        int rightIndex = mid +1;
        int storeIndex = 0;
        while (leftIndex<= mid && rightIndex<= end ){
            if(arr[rightIndex] <= arr[leftIndex]){
                temp[storeIndex++] = arr[rightIndex];
                rightIndex++;

            }else {
                temp[storeIndex++] = arr[leftIndex];
                leftIndex++;
            }

        }
        if (leftIndex <= mid){
            for (int i = leftIndex; i <= mid ; i++) {
                temp[storeIndex++] = arr[i];
            }
        }

        if (rightIndex <= end){
            for (int i = rightIndex; i <= end ; i++) {
                temp[storeIndex++] = arr[i];
            }
        }
        storeIndex = 0;
        for (int i = start; i <= end ; i++) {
            arr[i] = temp[storeIndex++];
        }


    }


    //计数排序
    public static void  jishuSort(int[] arr){
        int[] base = new int[101];
        int len = arr.length;
        int[] result = new int[len];
//统计每个数出现的次数
        for (int i = 0; i < len; i++) {
            int temp = arr[i];
            base[temp]++;
        }
//求出每个数，最后一次出现的位置
        for (int i = 1; i < base.length ; i++) {
            int frontNum = base[i-1];
            base[i] = base[i] + base[i-1];
        }
//从数组的尾部往前遍历
        for (int i = len-1; i >= 0 ; i--) {
 //求出每个数在数组中应该的位置
            int temp = arr[i];
            int index = base[temp];
            base[temp]--;
            result[index -1] = temp;

        }
        System.arraycopy(result,0,arr,0,len);
        System.out.println("==============");
    }

    //快速排序
    public static void quickSort(int[] arr){
        int len = arr.length;
        quickSort(arr,0, len-1);
    }

    public static void quickSort(int[]arr, int start, int end){
        if (start < end){
            int mid = divide4Quick(arr,start,end);
           // int mid = partiton(arr,start,end);
            quickSort(arr,start,mid-1);
            quickSort(arr,mid+1, end);

        }
    }
    public static int partiton(int[] arr,int start, int end){
        int val = arr[start];
        while (start < end){
            /***
             *因为插入的顺序是固定的，先从后面找到一个比val小的值，再从前面找到一个比val大的值
             * 所以不需要判断
             *
             **/
            //找小的
            while (start< end && arr[end] >= val) end--;
                arr[start] = arr[end];
            //找大的
            while (start < end && arr[start] <= val) start++;
                arr[end] = arr[start];
        }
        arr[start] = val;

        return start;
    }
@Deprecated

    public static int divide4Quick(int[] arr, int start, int end){
        int val = arr[start];
        int insertIndex = start;
        int frontIndex = start+1;
        int lastIndex = end;
        //如确定空位置在哪一端
        while (frontIndex <= lastIndex){
            //后面往前插入
          if(insertIndex < frontIndex){
              while (arr[lastIndex]>= val && lastIndex >= frontIndex)lastIndex--;
              if(lastIndex >= frontIndex){
                  arr[insertIndex] = arr[lastIndex];
                  insertIndex = lastIndex;
                  lastIndex--;
              }
         }
          //从前往后插入
            while (arr[frontIndex]<=val && frontIndex <= lastIndex) frontIndex++;
          if(lastIndex >= frontIndex){
              arr[insertIndex] = arr[frontIndex];
              insertIndex = frontIndex;
              frontIndex++;
          }
        }
     arr[insertIndex] = val;
        return insertIndex;

    }

    /**
     * @Description 向下调整函数
     * @Author lihan
     * @Date 2021/12/12
     * @Param li 列表
     * @param low 堆的堆顶位置
     * @param high 堆的最后一个元素的位置
     * @return int
     **/
    public  static void sift(int[] li,int low, int high){
        int leftChildIndex = 2*low+1;
        int val = li[low];
        int i= low;
        int j = leftChildIndex;//最大子节点的索引值

        //没有下层字节点了
        while (j<=high){
            //确定最大值在左子树还是右子树；右孩子没有越界
            if(j+1<= high && li[j+1] > li[j]){
                j++;
            }

           if(li[j] <= val){
               break;
            }
            li[i] =li[j];
            i = j;
            j = 2*i+1;//往下看一层

        }
        li[i] = val; //结束循环的条件是，没有下一个要比较的元素了，或者放到了某一层的领导位置

    }

    public static void heapSort(int[] arr){
        int len = arr.length-1;
        int curIndex = (len -1)/2;//有叶子节点的最后一个节点的下标
        //建堆完成,此时堆顶为最大元素
        for (int i = curIndex; i >=0 ; i--) {
            sift(arr,i, len);
        }
        for (int i = len; i >=0 ; i--) {
            //堆顶和最后一个元素交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            sift(arr,0,i-1);
        }


    }

}
