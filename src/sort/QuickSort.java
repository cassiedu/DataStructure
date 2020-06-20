package sort;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*10);
        }
        System.out.print("before sort: ");
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.print("after sort: ");
    }

    static int i = 1;

    public static void quickSort(int[] arr, int left, int right){
        int l = left;
        int r = right;
        int pivot = arr[(l + r)/2];
        int temp = 0;
        int j = 1;
        System.out.printf("第%d轮排序：", i++);
        System.out.println();
        while (l < r){
            while (arr[l] < pivot){
                l += 1;
            }
            while (arr[r] > pivot){
                r -= 1;
            }
            if (l >= r){
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            System.out.printf("第%d次迭代：", j++);
            System.out.println(Arrays.toString(arr));

            if (arr[l] == pivot){
                r -= 1;
            }
            if(arr[r] == pivot) {
                l += 1;
            }

        }
        System.out.println();
        if (l == r){
            l += 1;
            r -= 1;
        }
        if (left < r){
            quickSort(arr, left, r);
        }
        if(right > l) {
            quickSort(arr, l, right);
        }
    }

    private static void quickSorts(int[] arr){
        int[] arrSort = new int[arr.length];
        int index = arr.length/2;
        int value = arr[index];
        arrSort[index] = value;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] <= value){
                arrSort[i] = arr[i];
            }else {
                arrSort[1+value] = arr[i];
            }
        }

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
