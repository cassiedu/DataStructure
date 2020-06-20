package Tree;

public class BinarySortTrees {
    public static void main(String[] args){
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySort binarySort = new BinarySort();
        for (int i = 0; i < arr.length; i++){
            binarySort.addNode(new NumNode(arr[i]));
        }

        System.out.println("中序遍历二叉排序树~");
        System.out.println("root=" + binarySort.getRoot());
        binarySort.infixOrder();

        binarySort.delNumNode(12);
        binarySort.delNumNode(5);

        System.out.println("删除结点后");
        System.out.println("root=" + binarySort.getRoot());
        binarySort.infixOrder();
    }
}

//都需要用到 NumNode root, so create the class of BinarySort
class BinarySort{
    private NumNode root;

    public NumNode getRoot(){
        return root;
    }

    /**
     * @param val 需要操作的节点值
     * @return  节点值对应的节点
     */
    public NumNode search(int val){
        if (root == null){
            return null;
        } else {
            return root.searchEleNode(val);
        }
    }

    /**
     * @param val 需要操作的节点值
     * @return 节点值对应的父节点
     */
    public NumNode searchPar(int val){
        if (root == null){
            return null;
        } else {
            return root.searchParNode(val);
        }
    }

    /**
     * @param numNode 传入的结点(当做二叉排序树的根结点)
     * @return  以 numNode 为根结点的二叉排序树的最小结点的值
     */
    public int delRigTreeMin(NumNode numNode){
        NumNode target = numNode;
        while (target.left != null){
            target = target.left;
        }
        delNumNode(target.value);
        return target.value;
    }

    /**
     * @param val 需要删除的节点值
     */
    //编写方法:
    //1. 返回的 以node 为根结点的二叉排序树的最小结点的值
    //2. 删除node 为根结点的二叉排序树的最小结点
    public void delNumNode(int val){
        if(root == null){
            return;
        } else {
            NumNode targetNode = search(val);
            if (targetNode == null){
                return;
            }
            //如果只含有一个根节点
            if (root.left == null && root.right == null){
                root = null;
                return;
            }
            NumNode parent = searchPar(val);
            //如果要删除的是叶子节点
            if (targetNode.left == null && targetNode.right == null){
                //删除的是左叶子节点
                if (parent.left != null || parent.left.value == val){
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == val){
                    //删除的是右叶子节点
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null){
                //删除的节点含有左右叶子节点
                int minVal = delRigTreeMin(targetNode.right);
                targetNode.value = minVal;
            } else {
                //删除的节点含有左子节点
                if (targetNode.left != null){
                    if (parent != null){
                        if (parent.left.value == val){
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {
                    //删除的节点含有右子节点
                    if (parent != null){
                        if (parent.left.value == val){
                            parent.left = targetNode.right;
                        }else {
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    /**
     * @param numNode 需要添加的节点
     */
    //添加结点的方法
    public void addNode(NumNode numNode){
        if (root == null){
            root = numNode;
        } else {
            root.addNode(numNode);
        }
    }

    //中序遍历
    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空 ");
        }
    }
}

class NumNode {
    int value;
    NumNode left;
    NumNode right;

    public NumNode(int value) {
        this.value = value;
    }

    /**
     * @param val 要删除的节点值
     * @return  找到节点值所在的节点
     */
    //查找要删除的结点
    public NumNode searchEleNode(int val) {
        if (val == value) {
            return this;
        } else if (val < value) {
            if (this.left == null) {
                return null;
            }
            return this.left.searchEleNode(val);
        } else {
            if (this.right == null){
                return null;
            }
            return this.right.searchEleNode(val);
        }
    }

    /**
     * @param val 要删除的节点值
     * @return  要删除节点的父节点
     */
    public NumNode searchParNode(int val){
        if ((this.left != null && this.left.value == val) || (this.right != null && this.right.value == val)){
            return this;
        } else {
            if (val < this.value && this.left != null){
                return this.left.searchParNode(val);
            } else if (val >= this.value && this.right != null){
                return this.right.searchParNode(val);
            } else {
                return null;
            }
        }
    }

    @Override
    public String toString() {
        return "NumNode [val =" + value + "]";
    }

    /**
     * @param numNode 要添加的节点
     */
    //添加结点的方法
    //递归的形式添加结点，注意需要满足二叉排序树的要求
    public void addNode(NumNode numNode){
        if (numNode == null){
            return;
        }
        if (numNode.value < this.value){
            if (this.left == null){
                this.left = numNode;
            } else {
                this.left.addNode(numNode);
            }
        } else {
            if (this.right == null){
                this.right = numNode;
            } else {
                this.right.addNode(numNode);
            }
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }
}
