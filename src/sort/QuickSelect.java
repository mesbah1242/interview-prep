package sort;

import java.util.Arrays;

public class QuickSelect {
  public static void main(String[] args) {
    int[] data = {20, 10, 40, 60, 50, 80, 30, 91, 71, 90};
    System.out.println(select(data,0,data.length-1, 5));

  }

  public static int select(int[] arr, int lo, int hi, int k) {
    while(true){
      if(lo==hi)
        return arr[lo];
      int pivotIndex = (lo+hi)/2;
      int p = partition(arr,lo,hi, pivotIndex);
      if(k==p)
        return arr[p];
      else if(k<p)
        hi = p-1;
      else
        lo = p+1;
    }

  }

  public static int partition(int[] arr, int lo, int hi, int pivotIndex) {
    int pivot = arr[pivotIndex];
    swap(arr, pivotIndex, hi);
    int i = lo;
    for(int j = lo; j < hi; j++) {
      if(arr[j] < pivot) {
        swap(arr, i, j);
        i++;
      }
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
