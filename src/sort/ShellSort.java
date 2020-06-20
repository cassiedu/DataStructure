package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static  void main(String[] args){
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++){
            arr[i] = (int)(Math.random()*10);
        }

        System.out.println("original array elements are: ");
        System.out.println(Arrays.toString(arr));

        shellSort(arr);
        System.out.println("sorted array elements are: ");
        System.out.println(Arrays.toString(arr));

//        Date date01 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date01Str = simpleDateFormat.format(date01);
//        System.out.println("Before sort, the time is: "+date01Str);
//
//        shellSort(arr);
//        Date date02 = new Date();
//        SimpleDateFormat simpleDateFormat02 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date02Str = simpleDateFormat02.format(date02);
//        System.out.println("After sort, the time is: "+date02Str);
    }

    private static void shellSort(int[] arr){
        int gap = arr.length;
        int k = 1;
        while (gap > 0){
            gap = gap/2;
            for (int i = 0; i < gap; i++){
                for (int j =gap+i; j < arr.length; j = j + gap){
                    int insert = arr[j];
                    int index = j-gap;
                    while (index >= 0 && insert < arr[index]){
                        arr[index+gap] = arr[index];
                        index = index - gap;
                    }
                        arr[index+gap] = insert;
                }
            }

            System.out.printf("希尔排序%d轮后: ", k++);
            System.out.println(Arrays.toString(arr));
        }

//        public static void shellSort2(int[] arr) {
//
//            // 增量gap, 并逐步的缩小增量
//            for (int gap = arr.length / 2; gap > 0; gap /= 2) {
//                // 从第gap个元素，逐个对其所在的组进行直接插入排序
//                for (int i = gap; i < arr.length; i++) {
//                    int j = i;
//                    int temp = arr[j];
//                    if (arr[j] < arr[j - gap]) {
//                        while (j - gap >= 0 && temp < arr[j - gap]) {
//                            //移动
//                            arr[j] = arr[j-gap];
//                            j -= gap;
//                        }
//                        //当退出while后，就给temp找到插入的位置
//                        arr[j] = temp;
//                    }
//
//                }
//            }
//        }
    }

}
