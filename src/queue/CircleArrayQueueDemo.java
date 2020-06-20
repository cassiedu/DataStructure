package queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args){
        System.out.println("test circle queue");
        CircleArrays queue = new CircleArrays(3);
        char key;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");

//            String key0 = scanner.nextLine();  //读取字符串型输入
//            System.out.println("Please Enter Character:");
            key = scanner.next().charAt(0);



            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("input a number: ");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res = queue.getQueue();
                        System.out.printf("get the number %d/n",res);
                    } catch (Exception e) {
                        System.out.println("exception type is: " + e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res = queue.headQueue();
                        System.out.println("the headed number is: "+ res);
                    }catch(Exception e){
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
        System.out.println("exit the progress");
    }
}

class CircleArrays{
    private int maxSize;
    private int[] arr;
    private int rear;
    private int front;

    public CircleArrays(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
    }

    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if (isFull()){
            System.out.println("queue is full");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue(){
        if(isEmpty()){
            System.out.println("queue is empty");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("queue is empty");
            return;
        }
        for (int i = front; i < front + size(); i++){
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        return arr[front];
    }
}

