package sort;

import java.util.Arrays;

public class QuickSortThreeWay {
  public static void main(String[] args) {
//    int[] data = {20, 10, 40, 60, 50, 80, 30, 91, 71, 90};
    int[] data = { 1, 2, 3, 4};
//    int[] data = { 10, 10, 10, 10};
    quickSort(data, 0, data.length-1);
    System.out.println(Arrays.toString(data));

  }

  public static void quickSort(int[] arr, int lo, int hi) {
    if(lo<hi){
      int[] p = threeWayPartition(arr, lo, hi);
      quickSort(arr, lo, p[0]-1);
      quickSort(arr, p[1]+1, hi);
    }
  }

  public static int[] threeWayPartition(int[] arr, int lo, int hi) {
    int lt = lo;
    int gt = hi;
    int i = lo+1;
    for(;i<=gt && i<=hi;) {
      if(arr[i]<arr[lt]){
        swap(arr,lt,i);
        lt++;
        i++;
      }
      else if(arr[i]>arr[lt]){
        swap(arr, gt, i);
        gt--;
      }
      else {
        i++;
      }
    }
    return new int[] {lt,gt};

  }

  public static void swap(int[] arr, int a, int b) {
    if(a==b) return;
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
}
