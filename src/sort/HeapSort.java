package sort;

import java.util.Arrays;

public class HeapSort {
  public static void main(String[] args){
    int[] data = {20, 10, 40, 60, 50, 80, 30, 91, 71, 90};
    heapSort(data);
    System.out.println(Arrays.toString(data));
  }

  public static int left(int i){
    return i*2;
  }
  public static int right(int i) {
    return i*2+1;
  }
  public static int parent(int i) {
    return i/2;
  }
  public static void maxHeapify(int[] arr, int i, int heapSize) {
    int l = left(i);
    int r = right(i);
    int largest = i;
    if(l<=heapSize && arr[l-1]>arr[largest-1]){
      largest = l;
    }
    if (r<=heapSize && arr[r-1]>arr[largest-1]){
      largest = r;
    }
    if(largest!=i){
      int temp = arr[i-1];
      arr[i-1] = arr[largest -1];
      arr[largest - 1] = temp;
      maxHeapify(arr, largest, heapSize);
    }
  }
  public static void buildMaxHeap(int[] arr){
    for(int i = arr.length/2; i>=1; i--){
      maxHeapify(arr, i, arr.length);
    }
  }
  public static void heapSort(int[] arr){
    buildMaxHeap(arr);
    int heapSize = arr.length;
    for(int i=arr.length; i>1; i--) {
      int temp = arr[i-1];
      arr[i-1] = arr[0];
      arr[0] = temp;
      heapSize--;
      maxHeapify(arr, 1, heapSize);
    }
  }
}
