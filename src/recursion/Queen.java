package recursion;

public class Queen {
    int max = 8;
    static int solutionCount = 0;
    static int judgeCount = 0;
    int[] chess = new int[max];

    public static void main(String[] args){
        Queen queen = new Queen();
        queen.check(0);
//        check(0);
        System.out.printf("一共有%d解法", solutionCount);
        System.out.printf("一共判断冲突的次数%d次", judgeCount);


    }

    private void getChess(){
        solutionCount++;
        for (int i = 0; i < max; i++){
            System.out.print(chess[i]+"\t");
        }
        System.out.println();
    }

    private boolean judge(int n){
        judgeCount++;
        for (int i = 0; i < n; i++){
            if (chess[i] == chess[n] || Math.abs(n-i) == Math.abs(chess[n] - chess[i])){
                return false;
            }
        }
        return true;
    }

    private void check(int n){
        if (n == max){
            getChess();
            return;
        }
        for (int j = 0; j < max; j++){
            chess[n] = j;
            if (judge(n)){
                check(n+1);
            }
        }

    }
}
