package binarySortTree;


public class BinarySortTrees {
    public static void main(String[] args){
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        Operate operate = new Operate();
        for (int ele: arr){
            Operate.adds(new NodeBinary(ele));
        }

        System.out.println("before order: " + operate);
        System.out.print("after order: ");
        Operate.infixOrder();

        System.out.println("root is: " + Operate.getRoot());

        operate.delete(1);
        System.out.println("删除结点后:");
        Operate.infixOrder();

    }
}

class Operate{
    static NodeBinary root;
    public static NodeBinary getRoot(){
        return root;
    }

    public static void adds(NodeBinary node){
        if (root == null){
            root = node;
        } else {
            root.adds(node);
        }
    }

    public static void infixOrder(){
        if (root == null){
            System.out.println("二叉排序树为空");
        } else {
            root.infixOrder();
        }
    }

    public void delete(int val){
        NodeBinary target = findNode(val);

        if (root == null){
            System.out.println("二叉排序树为空");;
        } else {
            if (target == null){
                return;
            }
            if (root.left == null && root.right == null){
                root = null;
                return;
            }
            NodeBinary father = findNodeFather(val);
            if (target.left == null && target.right == null){
                if (father.left != null && father.left == target){
                    father.left = null;
                } else if (father.right != null && father.right.val == target.val){
                    father.right = null;
                }
            } else if (target.left != null && target.right != null){
                int min = findMinRight(target);
                target.val = min;
            } else {
                if (target.left != null){
                    if (father == null){
                        root = target.left;
                    } else {
                        if (father.left.val == val){
                            father.left = target.left;
                        } else {
                            father.right = target.left;
                        }
                    }
                } else {
                    if (father == null){
                        root = target.right;
                    } else {
                        if (father.left.val == val){
                            father.left = target.right;
                        } else {
                            father.right = target.right;
                        }
                    }
                }
            }


        }

    }

    private int findMinRight(NodeBinary node){
        NodeBinary target = node;
        //循环的查找左子节点，就会找到最小值
        while(target.left != null) {
            target = target.left;
        }
        //这时 target就指向了最小结点
        //删除最小结点
        delete(target.val);
        return target.val;
    }

    private NodeBinary findNode(int val) {
        if (root == null){
            return null;
        } else {
            return root.findNode(val);
        }
    }

    private NodeBinary findNodeFather(int val){
        if (root == null){
            return null;
        } else {
            return root.findNodeFather(val);
        }
    }
}


class NodeBinary{
    int val;
    NodeBinary left;
    NodeBinary right;

    public NodeBinary(int val){
        this.val = val;
    }

    @Override
    public String toString() {
        return "val = " + val;
    }

    public void adds(NodeBinary node) {
        if (node == null){
            return;
        }
        if (node.val < this.val) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.adds(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.adds(node);
            }
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

    public NodeBinary findNode(int val){
        if (this.val == val){
            return this;
        } else if (this.val < val){
            if (this.right == null){
                return null;
            }
            return this.right.findNode(val);
        } else {
            if (this.left == null){
                return null;
            }
            return this.left.findNode(val);
        }
    }

    public NodeBinary findNodeFather(int val){
        if (this.left != null && this.right.val == val || this.right != null && this.right.val == val){
            return this;
        } else if (this.val < val && this.right != null){
            return this.right.findNodeFather(val);
        } else if (this.val >= val && this.left != null){
            return this.left.findNodeFather(val);
        } else {
            return null;
        }
    }


}