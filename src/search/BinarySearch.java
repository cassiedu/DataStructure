package search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arrMul ={1,  1, 2, 3, 4, 5, 10, 10, 10, 10, 10 , 10, 10, 10, 10, 15,16,17,18,19,20};
        int[] arr ={1, 2, 3, 4, 5, 6, 7, 8, 9, 10 , 11, 12, 13,14,15,16,17,18,19,20};
        List<Integer> resIndexList = binarySearchMul(arrMul, 0, arrMul.length - 1, 10);
        System.out.println("resIndexList=" + resIndexList);
        int resIndex = binaryFind(arr, 0, arr.length, 3);
        System.out.println("resIndex=" + resIndex);
    }

    /**
     * @param arr 需要查找的数组
     * @param left 左边索引
     * @param right 右边索引
     * @param findVal 需要搜索的值
     * @return 需要找的值在数组中的下标
     */
    public static int binaryFind(int[] arr, int left, int right, int findVal){
        if (left < right){
            return -1;
        }
        int mid = (right + left)/2;
        int midVal = arr[mid];
        if (findVal > midVal){
            return binaryFind(arr, mid + 1, right, findVal);
        } else if (findVal < midVal){
            return binaryFind(arr, left, mid-1, findVal);
        } else {
            return mid;
        }
    }

//    /*
//     * 课后思考题： {1,8, 10, 89, 1000, 1000，1234} 当一个有序数组中，
//     * 有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000
//     *
//     * 思路分析
//     * 1. 在找到mid 索引值，不要马上返回
//     * 2. 向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
//     * 3. 向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
//     * 4. 将Arraylist返回
//     */
    public static List<Integer> binarySearchMul(int[] arr, int left,int right, int findVal){
        if (left > right){
            return new ArrayList<>();
        }
        int mid = (left + right)/2;
        int midVal = arr[mid];
        if (findVal > midVal){
            return binarySearchMul(arr, mid+1, right, findVal);
        } else if (findVal < midVal){
            return binarySearchMul(arr, left, mid-1, findVal);
        } else {
            List<Integer> resIndexList = new ArrayList<>();
            int tempLeft = mid - 1;
            while (true){
                if (tempLeft < 0 || arr[tempLeft] != findVal){
                    break;
                }
                resIndexList.add(tempLeft);
                tempLeft--;
            }

            resIndexList.add(mid);
            int tempRight = mid + 1;
            while (true){
                if (tempRight > arr.length || arr[tempRight] != findVal){
                    break;
                }
                resIndexList.add(tempRight);
                tempRight++;
            }
            return resIndexList;
        }
    }


}