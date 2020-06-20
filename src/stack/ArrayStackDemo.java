package stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args){
        ArrayStacks stack = new ArrayStacks(10);
        Scanner sc = new Scanner(System.in);
        boolean loop = true;

        while (loop){
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            String key = sc.nextLine();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }

}


class ArrayStacks{
    private int maxSize;
    private int[] stack;
    private int top = -1;

//    public ArrayStacks(int maxSize, int[] stack, int top) {
//        this.maxSize = maxSize;
//        this.stack = stack;
//        this.top = top;
//    }

    public ArrayStacks(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if (isFull()){
            throw new RuntimeException("the stack is full");
        }
        top ++;
        stack[top] = value;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("the stack is empty");
        }
        int value = stack[top];
        top --;
        return value;
    }

    public void list(){
        if (isEmpty()){
            throw new RuntimeException("the stack is empty");
        }
        for (int i = 0; i < stack.length; i++){
            System.out.printf("stack[%d] = %d \n", i, stack[i]);
        }
    }
}
