package Tree;

public class ThreadBinaryTree {
    public static void main(String[] args){
        HeroNodes root = new HeroNodes(1, "tom");
        HeroNodes node2 = new HeroNodes(3, "jack");
        HeroNodes node3 = new HeroNodes(6, "smith");
        HeroNodes node4 = new HeroNodes(8, "mary");
        HeroNodes node5 = new HeroNodes(10, "king");
        HeroNodes node6 = new HeroNodes(14, "dim");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadBinary threadBinary = new ThreadBinary();
        threadBinary.setRoot(root);
        threadBinary.threadNode(root);

        HeroNodes leftNode = node5.getLeft();
        HeroNodes rightNode = node5.getRight();
        System.out.println("10号结点的前驱结点是 ="  + leftNode);
        System.out.println("10号结点的后继结点是="  + rightNode);

        threadBinary.threadList();

    }
}

class ThreadBinary{
    HeroNodes root;
    HeroNodes pre = null;

    public void setRoot(HeroNodes root){
        this.root = root;
    }

    public void threadList(){
        HeroNodes node = root;
        while (node != null){
            while (node.getLeftType() == 0){
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }


    public void threadNode(HeroNodes nodes){
        if (nodes == null){
            return;
        }
        threadNode(nodes.getLeft());
        if (nodes.getLeft() == null){
            nodes.setLeft(pre);
            nodes.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(nodes);
            pre.setRightType(1);
        }
        pre = nodes;
        threadNode(nodes.getRight());
    }

    private void delNode(int no){
        if (root == null){
            System.out.println("the binaryTree is empty");
            return;
        } else {
            if (root.getNo() == no){
                root = null;
                return;
            } else {
                root.delNode(no);
            }
        }
    }
}

class HeroNodes{
    int no;
    String name;
    HeroNodes left;
    HeroNodes right;
    int leftType;
    int rightType;

    public HeroNodes(int no, String name){
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNodes getLeft() {
        return left;
    }

    public void setLeft(HeroNodes left) {
        this.left = left;
    }

    public HeroNodes getRight() {
        return right;
    }

    public void setRight(HeroNodes right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "HeroNodes{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void delNode(int no){
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        if(this.left != null){
            this.left.delNode(no);
        } else if (this.right != null){
            this.right.delNode(no);
        }
    }


}
