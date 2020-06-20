package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args){
        String[] vertex = {"1", "2", "3", "4", "5", "6", "7", "8"};
        int n = vertex.length;
        CreateGraphs graph = new CreateGraphs(n);
        for (String ver: vertex){
            graph.addVertex(ver);
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
        System.out.print("dfs: ");
        graph.dfs();
        System.out.println();
        System.out.print("bfs: ");
        graph.bfs();
    }
}

class CreateGraphs{
    ArrayList<String> vertex;
    int[][] edge;
    boolean[] isVisited;

    public void dfs(int i){
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1){
            if (!isVisited[w]){
                dfs(w);
            }
            //结点被访问过
            w = getNextNeighbor(i, w);
        }
    }

    //遍历所有的结点，进行dfs[回溯]
    public void dfs(){
        isVisited = new boolean[getNumOfVertex()];
        for (int i = 0; i < getNumOfVertex(); i ++){
            if (!isVisited[i]){
                dfs(i);
            }
        }
    }

    public void bfs(int i){
        int u;
        int w;
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()){
            u = (Integer)queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1){
                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w) + "->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
    }

    public void bfs() {
        isVisited = new boolean[vertex.size()];
        for(int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]) {
                bfs(i);
            }
        }
    }

    public CreateGraphs(int n){
        vertex = new ArrayList<>();
        edge = new int[n][n];
    }

    public void addVertex(String ver){
        vertex.add(ver);
    }

    public void addEdge(int v1, int v2, int weight){
        edge[v1][v2] = weight;
        edge[v2][v1] = weight;
    }

    public void showGraph(){
        for (int[] ele: edge){
            System.err.println(Arrays.toString(ele));
        }
    }

    //返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int i) {
        return vertex.get(i);
    }

    public int getFirstNeighbor(int index) {
        for(int j = 0; j < vertex.size(); j++) {
            if(edge[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2) {
        for(int j = v2 + 1; j < vertex.size(); j++) {
            if(edge[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public int getNumOfVertex() {
        return vertex.size();
    }
}

