package sparsearray;

public class SparseArray {

    public static void main(String[] args){
        int[][] rawArray = new int[11][11];
        rawArray[1][1] = 1;
        rawArray[2][1] = 2;
        rawArray[3][1] = 1;
        int sum = 0;

        for(int[] raw:rawArray){
            for(int ele:raw){
                System.out.print("\t"+ ele);
                if(ele != 0){
                    sum ++;
                }
            }
            System.out.println();
        }

        System.out.println("sum: "+ sum);

        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        System.out.println("sparsearray's elements: ");
        System.out.println(" "+sparseArray[0][0]+" "+sparseArray[0][1]+" "+sparseArray[0][2]+" ");

        int count = 0;

        for(int i = 0; i < 11; i++){
            for (int j = 0; j < 11; j++){
                if(rawArray[i][j] != 0){
                    count ++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = rawArray[i][j];
                    System.out.printf(sparseArray[count][0]+" "+sparseArray[count][1]+" "+sparseArray[count][2]+" ");
                    System.out.println();
                }
            }
        }
        System.out.println();
        System.out.println("count: "+count);


        int[][] rawArray02 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for(int i = 1; i < count+1; i++){
            rawArray02[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        for(int[] row:rawArray02){
            for (int ele:row){
                System.out.printf("\t"+ele);
            }
            System.out.println();
        }
    }

}
