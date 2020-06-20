package sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[7];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        System.out.println("original array elements are: ");
        System.out.println(Arrays.toString(arr));

        insertSort(arr);
        System.out.println("sorted array elements are: ");
        System.out.println(Arrays.toString(arr));

    }

    private static void insertSort(int[] arr) {
        int[] arr02 = new int[7];
        arr02[0] = arr[0];
//        for (int i = 0; i < arr.length; i++){
//            int j = i+1;
//            while (j > 0 && arr02[i] > arr[j]){
//                arr02[j] = arr02[j-1];
//                j--;
//            }
//            arr02[i+1] = arr[j];
//            System.out.printf("第%d次排序的结果是： ", i + 1);
//            System.out.println(Arrays.toString(arr));
//        }


//        for (int i = 1; i < arr.length; i++) {
//            int j = i - 1;
//            while (j > 0 && arr02[j] > arr[i]) {
//                arr02[j + 1] = arr02[j];
//                j--;
//            }
//            arr02[j + 1] = arr[i];
//            System.out.printf("第%d次排序的结果是： ", i + 1);
//            System.out.println(Arrays.toString(arr));
//        }

        for (int i = 1; i <arr.length; i++){
            int insert = arr[i];
            int index = i - 1;
            while (index >= 0 && insert < arr[index]){
                arr[index+1] = arr[index];
                index--;
            }
            if (index+1 != i){
                arr[index+1] = insert;
            }
            System.out.printf("第%d次排序的结果是： ", i);
            System.out.println(Arrays.toString(arr));
        }
    }
}

//     int insertVal = arr[1];
//     int insertIndex = 1 - 1;
//
//     while(insertIndex >= 0 && insertVal < arr[insertIndex] ) {
//     arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
//     insertIndex--;
//     }
//     arr[insertIndex + 1] = insertVal;
//     System.out.println("第1轮插入");
//     System.out.println(Arrays.toString(arr));
//
//     //第2轮
//     insertVal = arr[2];
//     insertIndex = 2 - 1;
//     while(insertIndex >= 0 && insertVal < arr[insertIndex] ) {
//     arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
//     insertIndex--;
//     }
//     arr[insertIndex + 1] = insertVal;
//     System.out.println("第2轮插入");
//     System.out.println(Arrays.toString(arr));
//
//
//     //第3轮
//     insertVal = arr[3];
//     insertIndex = 3 - 1;
//
//     while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//     arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
//     insertIndex--;
//     }
//
//     arr[insertIndex + 1] = insertVal;
//     System.out.println("第3轮插入");
//     System.out.println(Arrays.toString(arr));
//}
