package sort;

import java.util.Arrays;

public class QuickSortTwoWay {
  public static void main(String[] args) {
    int[] data = {20, 10, 40, 60, 50, 80, 30, 91, 71, 90};
//    int[] data = { 1, 2, 3, 4};
    quickSort(data, 0, data.length-1);
    System.out.println(Arrays.toString(data));

  }

  public static void quickSort(int[] arr, int lo, int hi) {
    if(lo<hi){
      int p = twoWayPartition(arr, lo, hi);
      quickSort(arr, lo, p-1);
      quickSort(arr, p+1, hi);
    }
  }

  public static int twoWayPartition(int[] arr, int lo, int hi) {
    int pivot = arr[hi];
    int i = lo-1;
    int j = hi;
    while(true){
      while(arr[++i]<pivot){
        if(i==hi) break;
      }
      while(arr[--j]>pivot){
        if(j==lo) break;
      }
      if(i>=j) break;
      swap(arr, i, j);
    }
    swap(arr, i, hi);
    return i;

  }

  public static void swap(int[] arr, int a, int b) {
    if(a==b) return;
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}
