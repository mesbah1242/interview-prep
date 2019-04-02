package sort;

import java.util.Arrays;

public class InsertionSort {
  public static void main(String[] args){
    int[] data = {20, 10, 40, 60, 50, 80, 30, 91, 71, 90};
    insertionSort(data);
    System.out.println(Arrays.toString(data));
  }
  public static void insertionSort(int[] arr){
    for(int j=1; j<arr.length; j++) {
      int key = arr[j];
      int i = j-1;
      while(i>=0 && arr[i]>key){
        arr[i+1] = arr[i];
        i--;
      }
      arr[i+1] = key;
    }
  }
}
