package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        System.out.println(Arrays.toString(arr));
//        int[] arr = new int[8000000];
//        for (int i = 0; i < 8000000; i ++){
//            arr[i] = (int)(Math.random()*80000000);
//        }

//        for (int k = arr.length/2 - 1; k >= 0; k--) {
//            int temp = arr[k];
//            adjustHeap(arr, k);
//        }
        adjustHeap(arr,arr.length);

        int temp02;
        for (int j = arr.length-1; j>0; j--){
            temp02 = arr[j];
            arr[j] = arr[0];
            arr[0] = temp02;
            adjustHeap(arr, j);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void adjustHeap(int[] arr, int length) {
        for (int k = length / 2 - 1; k >= 0; k--) {
            int kTemp = k;
            int temp = arr[k];
            for (int i = 2 * k + 1; i < length; i = 2 * i + 1) {
                if (i + 1 < length && arr[i] < arr[i + 1]) {
                    i++;
                }
                if (temp < arr[i]) {
                    arr[k] = arr[i];
                    k = i;
                } else {
                    break;
                }
            }
            arr[k] = temp;
            k = kTemp;
        }
    }
//        for (int i = 2*j+1; i < arr.length; i = 2*i+1){
//            if (i + 1 < arr.length && arr[i] < arr[i+1]){
//                i++;
//            }
//            if (temp < arr[i]){
//                arr[j] = arr[i];
//                j = i;
//            } else {
//                break;
//            }
//        }
//        arr[j] = temp;
}

