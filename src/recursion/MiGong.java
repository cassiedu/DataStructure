package recursion;
//使用递归回溯来给小球找路
//说明
//1. map 表示地图
//2. i,j 表示从地图的哪个位置开始出发 (1,1)
//3. 如果小球能到 map[6][5] 位置，则说明通路找到.
//4. 约定： 当map[i][j] 为 0 表示该点没有走过 当为 1 表示墙  ； 2 表示通路可以走 ； 3 表示该点已经走过，但是走不通
//5. 在走迷宫时，需要确定一个策略(方法) 下->右->上->左 , 如果该点走不通，再回溯

/*
 * @param map 表示地图
 * @param i 从哪个位置开始找
 * @param j
 * @return 如果找到通路，就返回true, 否则返回false
 */
public class MiGong {

    public static void main(String[] args){
        int[][] map = new int[7][7];
        for (int i = 0; i < 7; i++){
            map[0][i] = 1;
            map[6][i] = 1;
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[2][1] = 1;
        map[2][2] = 1;
        System.out.println("original map: ");
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }

        findWay(map, 1, 1);
        System.out.println("findWay map: ");
        for (int i = 0; i < 7; i++){
            for (int j = 0; j < 7; j++){
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }

    }

    private static boolean findWay(int[][] map, int i, int j){
        if (map[5][5] == 2){
            return true;
        } else {
            if (map[i][j] == 0){
                map[i][j] = 2;
                if (findWay(map, i+1, j)){
                    return true;
                }else if(findWay(map, i, j+1)){
                    return true;
                }else if (findWay(map, i-1, j)){
                    return true;
                }else if (findWay(map, i, j-1)){
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

}
