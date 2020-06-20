package HuffmanTree;


import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args){
        int[] arr = { 13, 7, 8, 3, 29, 6, 1 };
        HuffSort.huff(arr);
    }


}

class HuffSort{
    public static void huff(int[] arr) {
        //将数组元素转换成node元素存放在list中
        List<NodeHuff> nodeHuff = new ArrayList<>();
//        for (int i = 0; i < nodeHuff.size();i++){
//            nodeHuff.add(new NodeHuff(i));
//        }

        for (int val : arr) {
            nodeHuff.add(new NodeHuff(val));
            System.out.printf(val + "\t");
        }
        System.out.println();
        System.out.println("original nodes sequence:");
        System.out.println(nodeHuff + "\t");

        while(nodeHuff.size() > 1) {
            Collections.sort(nodeHuff);
            System.out.println("after sorting, nodes sequence: ");
            System.out.println(nodeHuff + "\t");
            NodeHuff leftNode = nodeHuff.get(0);
            NodeHuff rightNode = nodeHuff.get(1);
            NodeHuff parent = new NodeHuff(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            nodeHuff.remove(leftNode);
            nodeHuff.remove(rightNode);
            nodeHuff.add(parent);
        }
        NodeHuff root = nodeHuff.get(0);

        if (root != null){
//            root.preOrder();
            root.suffixOrder();
        } else {
            System.out.println("the Huffman tree is empty");
        }
    }
}

class NodeHuff implements Comparable<NodeHuff>{
    int value;
    NodeHuff left;
    NodeHuff right;

    public NodeHuff(int value){
        this.value = value;
    }

    @Override
    public String toString() {
//        return "NodeHuff{" +
//                "value=" + value +
//                '}';
        return "value = " + value;
    }

    @Override
    public int compareTo(NodeHuff o) {
        return this.value - o.value;
    }

    public void preOrder(){
        System.out.print(this + "\t");
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    public void suffixOrder() {
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
        System.out.print(this + "\t");
    }
}
