package AVLtree;

public class AVLTrees {
    public static void main(String[] args){
        int[] arr =  { 10, 11, 7, 6, 8, 9 };
        TreeAVL treeAVL = new TreeAVL();
        for (int value : arr) {
            NodeAVL nodeAVL = new NodeAVL(value);
            treeAVL.addAVL(nodeAVL);
        }
        treeAVL.infixOrder();

        System.out.println("treeHeightRoot: " + treeAVL.getRoot().height());
        System.out.println("treeHeightLeft: " + treeAVL.getRoot().heightLeft());
        System.out.println("treeHeightRight: " + treeAVL.getRoot().heightRight());
    }
}

class TreeAVL{
    NodeAVL root; //默认是根结点的值

    public void addAVL(NodeAVL node){
        if (root == null){
            root = node;
        } else {
            root.addAVL(node);
        }
    }

    public void infixOrder(){
        if (root == null){
            System.out.println("empty");
        } else {
            root.infixOrder();
        }
    }

    public NodeAVL getRoot(){
        return root;
    }
}

class NodeAVL{
    int val;
    NodeAVL right;
    NodeAVL left;

    public NodeAVL(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return "val = " + val;
    }

    public int height(){
        return Math.max(left == null? 0: left.height(), right == null? 0: right.height()) + 1;
    }

    public int heightLeft(){
        if (left == null){
            return 0;
        }
        return left.height();
    }

    public int heightRight(){
        if (right == null){
            return 0;
        }
        return right.height();
    }

    private void rotateLeft(){
        NodeAVL nodeNew = new NodeAVL(val);
//        nodeNew.val = this.val;
        nodeNew.left = this.left;
        nodeNew.right = this.right.left;
        this.val = this.right.val;
        this.left = nodeNew;
        this.right = this.right.right;
    }

    private void rotateRight() {
        NodeAVL nodeNew = new NodeAVL(val);
        nodeNew.right = right;
        nodeNew.left = left.right;
        val = left.val;
        left = left.left;
        right = nodeNew;
    }

    public void addAVL(NodeAVL node){
        if (node == null){
            return;
        }
        if (this.val > node.val){
            if (this.left == null){
                this.left = node;
            } else {
                this.left.addAVL(node);
            }
        }else {
            if (this.right == null){
                this.right = node;
            } else {
                this.right.addAVL(node);
            }
        }
        int difference = heightRight() - heightLeft();

        if (difference > 1){
            if (right != null && right.heightLeft() > right.heightRight()){
                right.rotateRight();
            }
            rotateLeft();
            return; //必要的
        } else if (difference < -1){
            if (left != null && left.heightRight() > left.heightLeft()){
                left.rotateLeft();
            }
            rotateRight();
        }
    }

    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }

}