package recursion;

public class Queen8 {
    int max = 8;
    static int judgeCount = 0;
    static int count = 0;
    int[] array;

    public static void main(String[] args){
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("%d solutions",count);
        System.out.printf("%d conflicts",judgeCount);
    }

        private void print(){
            count++;
            for (int i = 0; i < array.length; i++){
                System.out.print(array[i]+"\t");
            }
            System.out.println();
        }

        //编写一个方法，放置第n个皇后
        //特别注意： check 是 每一次递归时，进入到check中都有  for(int i = 0; i < max; i++)，因此会有回溯
        private void check(int n) {
            if (n == max) {
                print();
                return;
            }
            //依次放入皇后，并判断是否冲突
            for (int i = 0; i < max; i++) {
                array[n] = i;
                if (judge(n)){
                    check(n+1);
                }
            }
        }
        //查看当我们放置第n个皇后, 就去检测该皇后是否和前面已经摆放的皇后冲突
        /**
         * @param n 表示第n个皇后
         * @return
         */

    //1. array[i] == array[n]  表示判断 第n个皇后是否和前面的n-1个皇后在同一列
    //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后是否在同一斜线
    // n = 1  放置第 2列 1 n = 1 array[1] = 1
    // Math.abs(1-0) == 1  Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
    //3. 判断是否在同一行, 没有必要，n 每次都在递增
        private boolean judge(int n){
            judgeCount++;
            for (int i = 0; i < n; i++){
                if (Math.abs(n-i) == Math.abs(array[n] - array[i])){
                    return false;
                }
            }
            return true;
        }


}
