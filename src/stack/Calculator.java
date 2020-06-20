package stack;

public class Calculator {
    public static void main(String[] args){

        String expression = "7*2*2-5+1-5+3-4";
        char ch = ' ';
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        int ope = 0;
        String keepNum = "";

        CalApproach numStack = new CalApproach(10);
        CalApproach opeStack = new CalApproach(10);
        //开始while循环的扫描expression
        while (true){
            ch = expression.substring(index, index + 1).charAt(0);
            //如果是符号入符号栈
            if (opeStack.isOperator(ch)){
                //如果符号栈不为空
                if (!opeStack.isEmpty()){
                    //如果符号栈有操作符，就进行比较,如果当前的操作符的优先级小于或者等于栈中的操作符,就需要从数栈中pop出两个数,
                    //在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
                    if (opeStack.priority(ch) <= opeStack.priority(opeStack.peek()) ){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        ope = opeStack.pop();
                        res = numStack.calculator(num1, num2, ope);
                        numStack.push(res);
                        opeStack.push(ch);
                    }else {
                        //如果当前的操作符的优先级大于栈中的操作符， 就直接入符号栈.
                        opeStack.push(ch);
                    }
                }else {
                    //如果符号栈为空
                    opeStack.push(ch);
                }
            }else {
                //如果是数入数栈
                //处理多位数
                //1. 当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                //2. 在处理数，需要向expression的表达式的index 后再看一位,如果是数就进行扫描，如果是符号才入栈
                //3. 因此我们需要定义一个变量 字符串，用于拼接
                keepNum += ch;
                if (index == expression.length() - 1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                    //注意是看后一位，不是index++
                    if (opeStack.isOperator(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index ++;
            if (index >= expression.length()){
                break;
            }
        }

        //当表达式扫描完毕，就顺序的从 数栈和符号栈中pop出相应的数和符号，并运行.
        while (true){
            if (opeStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            ope = opeStack.pop();
            res = numStack.calculator(num1, num2,ope);
            numStack.push(res);
        }
        int res2 = numStack.pop();
        System.out.printf("%s = %d",expression,res2);
   }
}

class CalApproach{
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public CalApproach(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int peek(){
        return stack[top];
    }

    public int push(int value){
        if (isFull()){
            System.out.println("the stack is full");
        }
        top ++;
        value = stack[top];
        return value;
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
            System.out.printf("stack[%d] = %d", i, stack[i]);
        }
    }

    public int priority(int val){
        if (val == '*' || val == '/'){
            return 1;
        }else if (val == '+' || val == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    public boolean isOperator(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int calculator(int num1, int num2, int operator){
        int res = 0;
        switch (operator){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
            default:
                break;
        }
        return res;
    }

}
