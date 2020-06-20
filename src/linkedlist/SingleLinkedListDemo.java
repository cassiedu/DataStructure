package linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNodes hero1 = new HeroNodes(1, "宋江", "及时雨");
        HeroNodes hero2 = new HeroNodes(2, "卢俊义", "玉麒麟");
        HeroNodes hero3 = new HeroNodes(3, "吴用", "智多星");
        HeroNodes hero4 = new HeroNodes(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedLists singleLinkedList = new SingleLinkedLists();
        //加入

		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero3);
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);

        // 测试一下单链表的反转功能
        System.out.println("原来链表的情况~~");
        singleLinkedList.list();
        System.out.println("反转单链表~~");
        reverse.reverseList(singleLinkedList.getHeads());
        singleLinkedList.list();
        System.out.println("测试逆序打印单链表, 没有改变链表的结构~~");
        reverse.reversePrint(singleLinkedList.getHeads());
        singleLinkedList.list();

        //加入按照编号的顺序
//		singleLinkedList.addByOrder(hero1);
//		singleLinkedList.addByOrder(hero4);
//		singleLinkedList.addByOrder(hero2);
//		singleLinkedList.addByOrder(hero3);
//		//显示一把
//		singleLinkedList.list();
//
//		//测试

//		//修改节点的代码
//		HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
//		singleLinkedList.update(newHeroNode);
//		System.out.println("修改后的链表情况~~");
//		singleLinkedList.list();
//
//		//删除一个节点
//		singleLinkedList.del(1);
//		singleLinkedList.del(4);
//		System.out.println("删除后的链表情况~~");
//		singleLinkedList.list();
//
//		//测试一下 求单链表中有效节点的个数
//		System.out.println("有效的节点个数=" + getLength(singleLinkedList.getHead()));//2
//
//		//测试一下看看是否得到了倒数第K个节点
//		HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 3);
//		System.out.println("res=" + res);
    }
}

//将单链表反转
class reverse{
    public static void reverseList(HeroNodes head){
        if (head.next == null || head.next.next ==null){
            return;
        }
        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        HeroNodes cur = head.next;
        HeroNodes next = null;// 指向当前节点[cur]的下一个节点
        HeroNodes reverseHead = new HeroNodes(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        //动脑筋
        while(cur != null) {
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur; //将cur 连接到新的链表上
            cur = next;//让cur后移
        }
        //将head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;
    }

    //可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
    public static void reversePrint(HeroNodes head) {
        if (head.next == null) {
            return;//空链表，不能打印
        }
        //创建要给一个栈，将各个节点压入栈
        HeroNodes cur = head.next;
        Stack<HeroNodes> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}

class SingleLinkedLists {
    private HeroNodes head = new HeroNodes(0, "", "");

    public HeroNodes getHeads() {
        return head;
    }

    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向 新的节点
    public void add(HeroNodes heroNodes) {
        HeroNodes temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNodes;
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出提示)
    public void addByOrder(HeroNodes heroNode) {
        HeroNodes temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.num > heroNode.num) {
                break;
            } else if (temp.next.num == heroNode.num) {
                flag = true;
                break;
            }
            temp = temp.next;

        }
        if (flag) {
            System.out.println("the hero has been existed");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void update(HeroNodes newHero){
        HeroNodes temp = head.next;
        boolean flag = false;
        while(true){
            if (temp == null){
                System.out.println("the queue is empty");
                break;
            }
            if (temp.num == newHero.num){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.name = newHero.name;
            temp.nickName = newHero.nickName;
        }else {
            System.out.println("the hero is not existed");
        }
    }

    //删除节点
    //思路
    //1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
    public void del(int num){
        HeroNodes temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                System.out.println("the list is empty");
                break;
            }else if (temp.num == num ){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("the hero is not existed ");
        }
    }

    //显示链表[遍历]
    public void list(){
        HeroNodes temp = head.next;
        if(temp == null){
            System.out.println("the list is empty");
        }
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println("output the list:\t" + temp);
            temp = temp.next;
        }
    }
}

class HeroNodes {
    int num;
    String name;
    String nickName;
    HeroNodes next;

    public HeroNodes(int num, String name, String nickName){
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNodes{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + next +
                '}';
    }
}