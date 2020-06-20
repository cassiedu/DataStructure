package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args){
        String expression = "10+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的List=" + infixExpressionList); // ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]

        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的List" + suffixExpressionList); //ArrayList [1,2,3,+,4,*,+,5,–]

        int ca = calculate(suffixExpressionList);
        System.out.printf("expression=%d\n", ca);
    }

    //方法：将得到的中缀表达式对应的List => 后缀表达式对应的List
    public static List<String> parseSuffixExpressionList(List<String> ls){
        //定义符号栈
        //因为s2 这个栈，在整个转换过程中，没有pop操作，而且后面我们还需要逆序输出；
        //这里我们就不用 Stack<String> 直接使用 List<String> s2
        Stack<String> s1 = new Stack<String>();
        List<String> s2 = new ArrayList<String>();
        for (String item: ls){
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
                while (s1.size() != 0 && Operations.getValue(s1.peek()) >= Operations.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;
    }

    //方法：将中缀表达式转成对应的List
//    s="1+((2+3)×4)-5";
    public static List<String> toInfixExpressionList(String s){
        List<String> ls = new ArrayList<>();
        char c;
        int i = 0;
        String str;
        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57){
                ls.add("" + c);
                i ++;
            }else {
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57){
                    str += c;
                    i ++;
                }
                ls.add(str);
            }
        }while (i < s.length());
        return ls;
    }

   //将一个逆波兰表达式， 依次将数据和运算符 放入到 ArrayList中
    public static List<String> getListString(String suffixExpression){
        String[] spilt = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele: spilt){
            list.add(ele);
        }
        return list;
    }

    //完成对逆波兰表达式的运算
	/*
	 * 1)从左至右扫描，将3和4压入堆栈；
		2)遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
		3)将5入栈；
		4)接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
		5)将6入栈；
		6)最后是-运算符，计算出35-6的值，即29，由此得出最终结果
	 */
      public static int calculate(List<String> ls){
          Stack<String> stack = new Stack<>();
          for (String item : ls){
              if (item.matches("\\d+")){
                  stack.push(item);
              }else {
                  int num2 = Integer.parseInt(stack.pop());
                  int num1 = Integer.parseInt(stack.pop());
                  int res = 0;
                // pop出两个数，并运算， 再入栈
                  if (item.equals("+")) {
                      res = num1 + num2;
                  } else if (item.equals("-")) {
                      res = num1 - num2;
                  } else if (item.equals("*")) {
                      res = num1 * num2;
                  } else if (item.equals("/")) {
                      res = num1 / num2;
                  } else {
                      throw new RuntimeException("运算符有误");
                  }
                  stack.push("" + res);
              }
          }
          return Integer.parseInt(stack.pop());
      }
}

//编写一个类 Operations 可以返回一个运算符 对应的优先级
class Operations{
    private static int add = 1;
    private static int sub = 1;
    private static int mul = 2;
    private static int div = 2;

    //getValue方法，返回对应的优先级数字
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = add;
                break;
            case "-":
                result = sub;
                break;
            case "*":
                result = mul;
                break;
            case "/":
                result = div;
                break;
            default:
                System.out.println("another operation is: " + operation);
                break;
        }
        return result;
    }
}
