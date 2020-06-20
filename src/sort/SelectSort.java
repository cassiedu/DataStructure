package sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args){
        int[] arr = new int[7];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*10);
        }
        System.out.print("原始数组元素为： ");
        System.out.println(Arrays.toString(arr));

        selectSort(arr);
        System.out.print("排序后数组元素为： ");
        System.out.println(Arrays.toString(arr));
    }

    //选择排序
//    public static void selectSort(int[] arr) {
//        //在推导的过程，我们发现了规律，因此，可以使用for来解决
//        //选择排序时间复杂度是 O(n^2)
//        for (int i = 0; i < arr.length - 1; i++) {
//            int minIndex = i;
//            int min = arr[i];
//            for (int j = i + 1; j < arr.length; j++) {
//                if (min > arr[j]) { // 说明假定的最小值，并不是最小
//                    min = arr[j]; // 重置min
//                    minIndex = j; // 重置minIndex
//                }
//            }
//
//            // 将最小值，放在arr[0], 即交换
//            if (minIndex != i) {
//                arr[minIndex] = arr[i];
//                arr[i] = min;
//            }
//
//            //System.out.println("第"+(i+1)+"轮后~~");
//            //System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
//        }
    private static void selectSort(int[] arr){
        int temp = 0;
        for (int j = 0; j < arr.length - 1; j++){
            for (int i = j; i < arr.length - 1; i++){
                if (arr[j] > arr[i+1]){
                    temp = arr[j];
                    arr[j] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            System.out.printf("排序第%d次的结果是：",j);
            System.out.println(Arrays.toString(arr));
        }
    }
}
/**
 //第1轮
 int minIndex = 0;
 int min = arr[0];
 for(int j = 0 + 1; j < arr.length; j++) {
 if (min > arr[j]) { //说明假定的最小值，并不是最小
 min = arr[j]; //重置min
 minIndex = j; //重置minIndex
 }
 }



 //将最小值，放在arr[0], 即交换
 if(minIndex != 0) {
 arr[minIndex] = arr[0];
 arr[0] = min;
 }

 System.out.println("第1轮后~~");
 System.out.println(Arrays.toString(arr));// 1, 34, 119, 101


 //第2轮
 minIndex = 1;
 min = arr[1];
 for (int j = 1 + 1; j < arr.length; j++) {
 if (min > arr[j]) { // 说明假定的最小值，并不是最小
 min = arr[j]; // 重置min
 minIndex = j; // 重置minIndex
 }
 }

 // 将最小值，放在arr[0], 即交换
 if(minIndex != 1) {
 arr[minIndex] = arr[1];
 arr[1] = min;
 }

 System.out.println("第2轮后~~");
 System.out.println(Arrays.toString(arr));// 1, 34, 119, 101

 //第3轮
 minIndex = 2;
 min = arr[2];
 for (int j = 2 + 1; j < arr.length; j++) {
 if (min > arr[j]) { // 说明假定的最小值，并不是最小
 min = arr[j]; // 重置min
 minIndex = j; // 重置minIndex
 }
 }

 // 将最小值，放在arr[0], 即交换
 if (minIndex != 2) {
 arr[minIndex] = arr[2];
 arr[2] = min;
 }

 System.out.println("第3轮后~~");
 System.out.println(Arrays.toString(arr));// 1, 34, 101, 119

 */
