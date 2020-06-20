package queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args){
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop){
            System.out.println("input a character");
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);

            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("input a number");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case'g':
                    try{
                        int res = queue.getQueue();
                        System.out.printf("the number is: ",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

       System.out.println("程序退出~~");
    }


}

class ArrayQueue{
    private int maxSize;
    private int[] arr;
    private int front;
    private int rear;

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull(){
        return rear == maxSize - 1;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("queue is full");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("queue is empty");
            return;
        }
        for (int i = 0; i < arr.length; i++){
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        return arr[front + 1];
    }

}
