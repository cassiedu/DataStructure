package search;

import java.util.Arrays;

public class FibonacciSearch {
    private static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 189, 1000, 1234};

        System.out.println("index=" + fibSearch(arr, 189));
    }

    public static int[] fib() {
        int[] fibArray = new int[maxSize];
        fibArray[0] = 1;
        fibArray[1] = 1;
        for (int i = 2; i < fibArray.length; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }
        return fibArray;
    }

    /**
     * @param a   需要查找的有序数组
     * @param key 需要查找的值
     * @return 查找值在数组中的对应下标
     */
    public static int fibSearch(int[] a, int key) {
        int low = 0;  //下边界的下标
        int high = a.length - 1;  //上边界的下标
        int split = 0;  //分割点的下标（=>temp）
        int[] f = fib();  //数组
        int mid = 0;  //实际分割点下标
        while (high > f[split] - 1) {
            split++;
        }
        int[] temp = Arrays.copyOf(a, f[split]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }
        while (low <= high) {
            mid = low + f[split - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                split--;
            } else if (key > temp[split]) {
                low = mid + 1;
                split -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
