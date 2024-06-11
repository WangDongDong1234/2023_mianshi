package chapter33;


import java.util.Arrays;

/**
 * 快速排序
 * 对冒泡排序的一种改进，也是采用分治法的一个典型的应用
 */
public class QuickSort {


    public static void main(String[] args) {
        int arr[]={4,7,6,5,3,2,8,1};
        sort(arr,0,7);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] array,int left,int right){
        if(right<left){
            return;
        }
        //基准位置
        int temp =array[left];
        // 左指针
        int i=left;
        // 右指针
        int j=right;
        while (i!=j){

            // 找到比temp小的位置
            while (array[j]>=temp &&i<j){
                j--;
            }

            // 找到比temp大的位置
            while (array[i]<=temp  &&i<j){
                i++;
            }

            //没有相遇,交换位置
            if(i<j){
                int e=array[i];
                array[i]=array[j];
                array[j]=e;
            }
        }
        //基数归为
        array[left]=array[i];
        array[i]=temp;
        sort(array,left,i-1);
        sort(array,i+1,right);
    }
}
