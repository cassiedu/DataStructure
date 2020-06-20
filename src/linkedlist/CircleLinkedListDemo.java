package linkedlist;

public class CircleLinkedListDemo {
    public static void main(String[] args){
        JosePhu josephu = new JosePhu();
        josephu.add(11);
        josephu.showBoy();
        josephu.countBoy(1,2,11);
    }
}

class JosePhu{
    BoyNode first = null;

    public void add(int nums){
        if (nums < 1){
            System.out.println("nums is wrong");
            return;
        }
        BoyNode curNode = null;
        for (int i = 1; i <= nums; i++){
            BoyNode boy = new BoyNode(i);
            if (i == 1){
                first = boy;
                first.setNext(first);
                curNode = first;
            }else {
                curNode.setNext(boy);
                boy.setNext(first);
                curNode = boy;

            }
        }
    }

    public void showBoy(){
        if (first == null){
            System.out.println("no boyNode");
            return;
        }
        BoyNode curNode = first;
        while (true){
            System.out.printf("the boyNode's num is %d :",curNode.getNum());
            if (curNode.getNext() == first){
                break;
            }
            curNode = curNode.getNext();
        }
    }

    public void countBoy(int startNum, int countNum, int nums) {
        BoyNode helper = first;
        if (first == null || startNum < 1 || startNum > nums) {
            System.out.println("the parameters are wrong, please input them again");
        }
        //当小孩报数时，让first 和 helper 指针同时移动  m  - 1 次, 然后出圈
        //这里是一个循环操作，知道圈中只有一个节点
        while (true) {
            if (helper == first) {
                break;
            }
            helper = helper.getNext();
            for (int j = 0; j < startNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("the boyNode %d leave the circle", first.getNum());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("the boyNode %d is leaved",first.getNum());
    }

}

class BoyNode{
    private int num;
    private BoyNode next;

    public BoyNode(int num){
        this.num = num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setNext(BoyNode next) {
        this.next = next;
    }

    public int getNum() {
        return num;
    }

    public BoyNode getNext() {
        return next;
    }
}
