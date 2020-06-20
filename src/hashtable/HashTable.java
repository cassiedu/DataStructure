package hashtable;

import java.util.Scanner;

public class HashTable {
    public static void main(String[] args){
        EmployHashTable hashTable = new EmployHashTable(7);
        Scanner  sc = new Scanner(System.in);
        String key;
        while (true){
            System.out.println("add");
            System.out.println("ele");
            System.out.println("upd");
            System.out.println("find");
            System.out.println("list");
            System.out.println("please input a choice");
//            key = sc.nextLine();
            key = sc.next();

            switch (key){
                case "add":
                    System.out.println("input a id");
                    int idAdd = sc.nextInt();
                    System.out.println("input a name");
                    String name = sc.next();
                    Employ addEmp = new Employ(idAdd, name);
                    EmployHashTable.addHash(addEmp);
                    break;
                case "ele":
                    System.out.println("input a id");
                    int idEle = sc.nextInt();
                    EmployHashTable.eleHash(idEle);
                    break;
                case "upd":
                    System.out.println("input a id");
                    int idUpd = sc.nextInt();
                    System.out.println("input a name");
                    String nameUpd = sc.nextLine();
                    Employ updEmp = new Employ(idUpd, nameUpd);
                    EmployHashTable.updHash(updEmp);
                    break;
                case "find":
                    System.out.println("input a id");
                    int idFind = sc.nextInt();
                    EmployHashTable.findHash(idFind);
                    break;
                case "list":
                    EmployHashTable.listHash();
                    break;
                default:
                    break;
            }



        }
    }
}

class EmployHashTable{
    private static EmployLinkedList[] empLinkedListArray;
    private static int size;

    public EmployHashTable(int size){
        this.size = size;
        empLinkedListArray = new EmployLinkedList[7];
        for (int i = 0; i < size; i++){
            empLinkedListArray[i] = new EmployLinkedList();
        }
    }
//    public void add(Emp emp) {
//        //根据员工的id ,得到该员工应当添加到哪条链表
//        int empLinkedListNO = hashFun(emp.id);
//        //将emp 添加到对应的链表中
//        empLinkedListArray[empLinkedListNO].add(emp);
//
//    }

    public static void addHash(Employ employHash){
        int empLinkedListId = hashFun(employHash.id);
        empLinkedListArray[empLinkedListId].addEmp(employHash);
    }
//    public void add(Emp emp) {
//        //根据员工的id ,得到该员工应当添加到哪条链表
//        int empLinkedListNO = hashFun(emp.id);
//        //将emp 添加到对应的链表中
//        empLinkedListArray[empLinkedListNO].add(emp);
//
//    }
    public static void eleHash(int id){
        int empLinkedListId = hashFun(id);
        empLinkedListArray[empLinkedListId].eleEmp(id);
    }

    public static void updHash(Employ employ){
        int empLinkedListId = hashFun(employ.id);
        empLinkedListArray[empLinkedListId].updEmp(employ);
    }

    public static void findHash(int id){
        int empLinkedListId = hashFun(id);
        Employ emp = empLinkedListArray[empLinkedListId].findEmp(id);
        if (emp != null){
            System.out.printf("在第%d条链表中找到雇员", (empLinkedListId+1));
        }
    }

    public static void listHash(){
        for (int i = 0; i < size; i++){
            empLinkedListArray[i].listEmp(i);
        }

    }

    public static int hashFun(int id){
        return id%size;
    }

}

class Employ{
    public int id;
    public String name;
    public Employ next;
    public Employ pre;
    public Employ(int id, String name){
        super();
        this.id = id;
        this.name = name;
    }

}

class EmployLinkedList{
    private Employ head;

//    private Employ head = new Employ(0,"");
//    public void add(Emp emp) {
//        //如果是添加第一个雇员
//        if(head == null) {
//            head = emp;
//            return;
//        }
//        //如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
//        Emp curEmp = head;
//        while(true) {
//            if(curEmp.next == null) {//说明到链表最后
//                break;
//            }
//            curEmp = curEmp.next; //后移
//        }
//        //退出时直接将emp 加入链表
//        curEmp.next = emp;
//    }

    public void addEmp(Employ employ){
//       if (head == null){
//           head = employ;
//           return;
//       }
        Employ temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (employ.id < temp.next.id){
                break;
            } else if(employ.id == temp.id){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("the id is existed");
        } else {
            employ.next = temp.next;
            temp.next = employ;
        }
    }


    public void eleEmp(int id){
        Employ temp = head;
        boolean flag = true;
        if (head == null){
            System.out.println("the list is empty");
        }
        while (true){
            if(temp.next.id == id){
                break;
            } else if(temp.next == null){
                System.out.println("the id is not existed");
                break;
            }
            temp = temp.next;
        }
        temp.next = temp;
    }

    public void updEmp(Employ update){
        Employ temp = head.next;
        boolean flag = true;
        if (head == null){
            System.out.println("the list is empty");
        }
        while (true){
            if(temp.id == update.id){
                break;
            } else if(temp == null){
                System.out.println("the id is not existed");
                break;
            }
            temp = temp.next;
        }
        temp = update;
    }

    public Employ findEmp(int id){
        Employ temp = head.next;
        if (temp == null){
            System.out.println("the list is empty");
        }
        while (true){
            if(temp.id == id){
                break;
            } else if(temp == null){
                System.out.println("the id is not existed");
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    public void listEmp(int no){
        Employ temp = head;
        if (head == null){
            System.out.printf("第%d条链表为空", no+1);
            System.out.println();
            return;
        }
        System.out.printf("第%d条链表信息为：", no+1);
        while (true){
            System.out.printf(" => id=%d name=%s\t", temp.id, temp.name);
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        System.out.println();
    }


}
