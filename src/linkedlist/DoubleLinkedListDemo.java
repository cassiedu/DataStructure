package linkedlist;

import java.util.Scanner;

public class DoubleLinkedListDemo {
    public static void main(String[] args){
        HeroNodeDou hero01 = new HeroNodeDou(1, "宋江", "及时雨");
        HeroNodeDou hero02 = new HeroNodeDou(2, "卢俊义", "玉麒麟");
        HeroNodeDou hero03 = new HeroNodeDou(3, "吴用", "智多星");
        HeroNodeDou hero04 = new HeroNodeDou(4, "林冲", "豹子头");

        DoubleLinkedLists doubleLinkedList = new DoubleLinkedLists();
        doubleLinkedList.addByOrder(hero04);
        doubleLinkedList.addByOrder(hero02);
        doubleLinkedList.addByOrder(hero01);
        doubleLinkedList.addByOrder(hero03);
        doubleLinkedList.getList();

//        Scanner sc = new Scanner(System.in);
//        System.out.println("input a number : ");
//        int num = sc.nextInt();

        doubleLinkedList.del(2);
        doubleLinkedList.getList();
    }
}

class DoubleLinkedLists{
    private HeroNodeDou head= new HeroNodeDou(0, " ", " ");

    public HeroNodeDou getHead(){
        return head;
    }
    public void getList() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点，不能动，因此我们需要一个辅助变量来遍历
        HeroNodeDou temp = head.next;
        while (true) {
            // 判断是否到链表最后
            if (temp == null) {
                break;
            }
            // 输出节点的信息
            System.out.println(temp);
            // 将temp后移， 一定小心
            temp = temp.next;
        }
    }
//    public void getList(){
//        HeroNodeDou temp = head.next;
//        if (temp == null){
//            System.out.println("the list is empty");
//            return;
//        }
//        while (true){
//            if (temp == null){
//                break;
//            }
//            System.out.println(temp);
//            temp = temp.next;
//        }
//    }

    public void addByOrder(HeroNodeDou heroNode){
        boolean flag = false;
        HeroNodeDou temp = head;

        while (true){
            if (temp.next == null) {
                break;
            }
            if (temp.next.num > heroNode.num){
                break;
            }else if (temp.next.num == heroNode.num){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("the numNode has been existed");
        }else {
            heroNode.next = temp.next;
            heroNode.pre = temp;
            temp.next = heroNode;
            temp.next.pre = heroNode;
        }
    }
    public void del(int num) {

        // 判断当前链表是否为空
        if (head.next == null) {// 空链表
            System.out.println("链表为空，无法删除");
            return;
        }

        HeroNodeDou temp = head.next; // 辅助变量(指针)
        boolean flag = false; // 标志是否找到待删除节点的
        while (true) {
            if (temp == null) { // 已经到链表的最后
                break;
            }
            if (temp.num == num) {
                // 找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next; // temp后移，遍历
        }
        // 判断flag
        if (flag) { // 找到
            // 可以删除
            // temp.next = temp.next.next;[单向链表]
            temp.pre.next = temp.next;
            // 这里我们的代码有问题?
            // 如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", num);
        }
    }
//    public void del(int num){
//        HeroNodeDou temp = head.next;
//        boolean flag = false;
//        if (temp == null) {
//            return;
//        }
//        while (true){
//            if (temp == null){
//                System.out.println("the list is empty");
//                break;
//            }
//            if (temp.num == num){
//                flag = true;
//                break;
//            }
//            temp = temp.next;
//        }
//        if (flag){
//            temp.pre.next = temp.next;
//            if(temp.next != null){
//                temp.next.pre = temp.pre;
//            }
//        }else {
//            System.out.printf("the heroNode %d is not existed\n",num);
//        }
//    }
}

class HeroNodeDou{
    public int num;
    public String name;
    public String nickName;
    public HeroNodeDou next;
    public HeroNodeDou pre;

    public HeroNodeDou(int num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "heroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
