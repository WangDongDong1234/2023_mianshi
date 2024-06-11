package niukewang.排序;

import java.util.Arrays;

public class A堆排序 {
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) { return; }
        // 1. Build heap
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
        // 2. Heap sort
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    /**
     *
     * @param arr  表示数组
     * @param heapSize  表示数组的长度
     * @param index   从那个节点开始调整
     */
    private void heapify(int[] arr, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;

        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(arr, index, largest);
            heapify(arr, heapSize, largest);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        A堆排序 heapSort = new A堆排序();
        int[] arr = {10, 2, 3, 4, 5, 6, 7, 8, 9};
        heapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
