package HuffmanTree;

import java.util.*;

// String >> byte[] >> Map[Byte,Int] >> List >> Map[Byte,String]
public class HuffmanCode {
    public static void main(String[] args){
        //0.将string转换成byte形式(ASCII码)
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length); //40

        byte[] res = packMethod(contentBytes);
        System.out.println("after zip, the code is: " + Arrays.toString(res) + " \t the length is: " + res.length);
    }

    //5.将方法打包在main中调用
    public static byte[] packMethod(byte[] contentBytes){
        List<NodeHuffman> list = HuffTree.byteToList(contentBytes);
        System.out.println("list节点：" + list);

        NodeHuffman root = HuffTree.huffTree(list);
        System.out.println("赫夫曼树的根节点：" + root);

        System.out.print("前序遍历：");
        HuffTree.preOrder(root);

//        StringBuilder stringBuilder = new StringBuilder();
//        huffCode.strBuilder(root, "", stringBuilder);
        HuffCode.strBuilder(root);
        System.out.println("huffman code is: " + HuffCode.huffCodes);

        return HuffCode.zip(contentBytes, HuffCode.huffCodes);
//        System.out.println("after zip, the code is: " + Arrays.toString(zipCode));
    }
}

//一、创建赫夫曼树
class HuffTree{
    public static List<NodeHuffman> byteToList(byte[] bytes){
        //1.定义编码方式，将每一个node以map集合形式表示
        List<NodeHuffman> nodeHuffman = new ArrayList<>();
        Map<Byte, Integer> count = new HashMap<>();
        for (Byte b: bytes){
            Integer c = count.get(b);
            if (c == null){
                count.put(b, 1);
            } else {
                count.put(b, c+1);
            }
        }
        //2.将所有node以list集合形式表示
        for (Map.Entry<Byte, Integer> entry: count.entrySet()){
            nodeHuffman.add(new NodeHuffman(entry.getKey(), entry.getValue()));
        }
        return nodeHuffman;
    }

    //3.依据list创建赫夫曼树
    public static NodeHuffman huffTree(List<NodeHuffman> nodeHuffman){
        while (nodeHuffman.size() > 1){
            Collections.sort(nodeHuffman);
            NodeHuffman nodeLeft = nodeHuffman.get(0);
            NodeHuffman nodeRight = nodeHuffman.get(1);
            NodeHuffman parent = new NodeHuffman(null, (nodeLeft.weight + nodeRight.weight));
            parent.left = nodeLeft;
            parent.right = nodeRight;
            nodeHuffman.add(parent);
            nodeHuffman.remove(nodeLeft);
            nodeHuffman.remove(nodeRight);
        }
        return nodeHuffman.get(0);
    }

    //4.前序遍历赫夫曼树
    public static void preOrder(NodeHuffman root){
        if (root == null){
            System.out.println("huffmanTree is empty");
        } else {
            root.preOrder();
        }
    }

}

//二、生成赫夫曼编码表
class HuffCode {
    //1.依据赫夫曼树将传入的结点编码后，将节点信息以Map(Byte,String)集合形式存储
    static Map<Byte, String> huffCodes = new HashMap<Byte, String>();
    public static void strBuilder(NodeHuffman node, String nodeCode, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(nodeCode);
        //只处理叶子节点
        if (node != null) {
            if (node.character == null) {
                strBuilder(node.left, "0", stringBuilder1);
                strBuilder(node.right, "1", stringBuilder1);
            }else {
                huffCodes.put(node.character, stringBuilder1.toString());
            }
        }
    }

    //重写stringBuilder方法，使得调用方便
    static StringBuilder stringBuilder = new StringBuilder();
    public static Map<Byte,String> strBuilder(NodeHuffman root){
        if(root == null) {
            return null;
        }
        //处理root的左子树
        strBuilder(root.left, "0", stringBuilder);
        //处理root的右子树
        strBuilder(root.right, "1", stringBuilder);
        return huffCodes;
    }

    //2.生成 原字符串对应ASCII编码 经过赫夫曼编码表压缩后的 编码，用byte[]存储结果
    public static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
        //将byte[]存储的ASCII编码 转换成 赫夫曼编码表对应的String
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffCodes.get(b));
        }
        //将String转换成8位一组的byte[]形式的编码
//        int length;
//        if (stringBuilder.length() % 8 == 0) {
//            length = stringBuilder.length() / 8;
//        } else {
//            length = stringBuilder.length() / 8 + 1;
//        }
        int length = (stringBuilder.length()+7)/8;
        byte[] zipCodeByte = new byte[length];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }
            zipCodeByte[index++] = (byte) Integer.parseInt(strByte, 2);
        }
        return zipCodeByte;
    }
}

class NodeHuffman implements Comparable<NodeHuffman>{
    int weight;
    Byte character;
    NodeHuffman left;
    NodeHuffman right;

    public NodeHuffman(Byte character, int weight){
        this.weight = weight;
        this.character = character;
    }

    @Override
    public String toString() {
        return "[ character =" + character + " weight = " + weight + "]";
    }

    @Override
    public int compareTo(NodeHuffman o) {
        return this.weight - o.weight;
    }

    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

}