package sort;

import java.util.Arrays;

public class MergeSort {
  public static void main(String[] args) {
    int[] data = {20, 10, 40, 60, 50, 80, 30, 91, 71, 90};
    mergeSort(data, 0, data.length-1);
    System.out.println(Arrays.toString(data));
  }

  public static void mergeSort(int[] arr, int start, int end) {
    if(start>=end){
      return;
    }
    int mid = (start+end)/2;
    mergeSort(arr, start, mid);
    mergeSort(arr, mid+1, end);
    merge(arr, start, mid, end);
  }

  public static void merge(int[] arr, int start, int mid, int end) {
    int[] temp = new int[end - start +1];
    int i = start;
    int j = mid+1;
    for(int k=0; k<temp.length; k++){
      if(j>end || arr[i]<arr[j]){
        temp[k] = arr[i];
        i++;
      }
      else if(i>mid || arr[i]>=arr[j]){
        temp[k] = arr[j];
        j++;
      }
    }
    copyArray(temp, arr, start);

  }

  public static void copyArray(int[] src, int[] target, int start) {
    for(int i=0; i<src.length; i++) {
      target[start+i] =  src[i];
    }
  }
}
