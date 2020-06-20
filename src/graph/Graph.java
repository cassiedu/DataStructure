package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    public static void main(String[] args){
        String[] vertex = {"1", "2", "3", "4", "5", "6", "7", "8"};
        int n = vertex.length;
        CreateGra graph = new CreateGra(n);

        for (String ele: vertex){
            graph.addVertex(ele);
        }
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(3, 7, 1);
        graph.addEdge(4, 7, 1);
        graph.addEdge(2, 5, 1);
        graph.addEdge(2, 6, 1);
        graph.addEdge(5, 6, 1);
        graph.showGraph();
    }
}

class CreateGra{
    ArrayList<String> vertex;
    int[][] weight;
    int numEdges;

    public CreateGra(int n){
        vertex = new ArrayList<>();
        weight = new int[n][n];
    }

    public void addVertex(String ver) {
        vertex.add(ver); //形参名不能和变量名相同
    }

    public void addEdge(int v1, int v2, int wei) {
        weight[v1][v2] = wei;
        weight[v2][v1] = wei;
        numEdges++;
    }

        public void showGraph() {
//        Arrays.deepToString(weight);
        for(int[] link : weight) {
            System.err.println(Arrays.toString(link));
        }
    }

    public int firstNode(int index){
        for (int i = 0; i < vertex.size(); i++){
            if (weight[index][i] > 0){
                return i;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int NextNode(int v1, int v2) {
        for (int j = v2 + 1; j < vertex.size(); j++) {
            if (weight[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }


    //图中常用的方法
    //返回结点的个数
//    public int getNumOfVertex() {
//        return vertexList.size();
//    }
//    //显示图对应的矩阵

//    //得到边的数目
//    public int getNumOfEdges() {
//        return numOfEdges;
//    }
//    //返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
//    public String getValueByIndex(int i) {
//        return vertexList.get(i);
//    }
//    //返回v1和v2的权值
//    public int getWeight(int v1, int v2) {
//        return edges[v1][v2];
//    }

}