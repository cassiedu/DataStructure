package search;

public class InsertSearch {
    public static void main(String[] args){
        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };

        int indexInsert = insertSearch(arr, 0, arr.length - 1, 8);
        System.out.println("查找次数 indexSearch = " + indexInsert);
        int indexBinary = binarySearch(arr, 0, arr.length-1, 8);
        System.out.println("查找次数 binarySearch = " + indexBinary);
    }

    static int index = 0;
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) { // 向 右递归
            index++;
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左递归
            index++;
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return index;
        }
    }

    public static int insertSearch(int[] arr, int left, int right, int findVal){

        if (left > right || findVal < arr[0] || findVal > arr[arr.length-1]){
            return -1;
        }
        int mid = left + (right - left)*(findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) { // 说明应该向右边递归
            index++;
            return insertSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 说明向左递归查找
            index++;
            return insertSearch(arr, left, mid - 1, findVal);
        } else {
            index++;
            return index;
        }
    }

}
