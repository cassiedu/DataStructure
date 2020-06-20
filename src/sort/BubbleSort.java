package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args){
//        int[] arr = new int[7];
//        for (int i = 0; i < arr.length; i++){
//            Scanner sc = new Scanner(System.in);
//            System.out.println("please input a number: ");
//            int num = sc.nextInt();
//            arr[i] = num;
//        }
//        int i = 0;
//        System.out.print("Before sort, the array arr[7] = [");
//        for (int ele: arr){
//            System.out.print(ele + "\t");
//        }
//        System.out.println("]");
//
//        bubbleSort(arr);
//        System.out.print("After sort, the array arr[7] = [");
//        for (int ele: arr){
//            System.out.print(ele + "\t");
//        }
//        System.out.println("]");
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++){
            arr[i] = (int)(Math.random()*10);
        }
        Date date01 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date01Str = simpleDateFormat.format(date01);
        System.out.println("Before sort, the time is: "+date01Str);

        bubbleSort(arr);
        Date date02 = new Date();
        SimpleDateFormat simpleDateFormat02 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date02Str = simpleDateFormat02.format(date02);
        System.out.println("After sort, the time is: "+date02Str);

    }

    private static void bubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length-1; i++ ){
            for (int j = 0; j < arr.length - 1 - i; j++){
                if (arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!flag){
                break;
            }else {
                flag =false;
            }
            System.out.println("第" + (i + 1) + "趟排序后的数组");
            System.out.println(Arrays.toString(arr));
        }
    }

}
