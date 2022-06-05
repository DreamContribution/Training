package com.frank.data.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //================中缀表达式转后缀表达式===================
        String exp = "1+((2+3)*4)-5";
        List<String> infixExp = toInfixExpressionList(exp);
        System.out.println("前缀表达式：" + infixExp);
        List<String> suffixExp = parseSuffixExpList(infixExp);
        System.out.println("后缀表达式：" + suffixExp);

        //=================后缀表达式的计算====================
        // Demo:(3+4)x5-6 => 3 4 + 5 x 6 -
        String suffixExpression = "3 4 + 5 * 6 - ";
        // 思路
        // 1.先将表达式放入ArrayList中
        // 2.将ArrayList传递给一个方法，遍历 ArrayList 配合栈完成计算
        List<String> list = getListString(suffixExpression);
        System.out.println("rpnList=" + list);
        int res = calcuate(list);
        System.out.println("res=" + res);
    }

    public static List<String> parseSuffixExpList(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack<>();//符号栈
        // 优化：s2没有pop操作，且需要逆序输出，所以使用List
        //Stack<String> s2 = new Stack<>();//中间结果栈
        List<String> s2 = new ArrayList<>();
        //遍历ls
        for (String item : ls) {
            //如果是一个数，加入到s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//将 ( 务必要弹出;目的：消除括号
            } else {
                // 当item的优先级小于等于栈顶运算符
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(item);
            }
        }
        //将s1中剩余的运算符一次加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    //方法：将中缀表达式转成对应的List
    public static List<String> toInfixExpressionList(String s) {
        //定义一个List，存放中缀表达式
        List<String> ls = new ArrayList<>();
        int i = 0;//用于遍历s
        String str;//对多位数的拼接
        char c;//每遍历到一个字符，就放入到c
        do {
            //如果c是一个非数字，需要加入到ls
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {//如果是一个数，需要考虑多位数的问题
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;//拼接
                    ls.add(str);
                    i++;
                }
            }
        } while (i < s.length());
        return ls;
    }

    //将一个逆波兰表达式，依次将数据和运算符放入ArrayList中
    public static List<String> getListString(String suffixExp) {
        String[] split = suffixExp.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    //完成对逆波兰表达式的运算

    /**
     * 1）从左往右扫描，将3，4压入堆栈；
     * 遇到+运算符，因此弹出4和3，计算出3+4的值，得7，再将7入栈；
     * 将5入栈；
     * 遇到x运算符，弹出数值后，运算之，得35入栈；
     * 依次反复
     */
    public static int calcuate(List<String> ls) {
        // 创建一个栈
        Stack<String> stack = new Stack<String>();
        for (String item : ls) {
            //这里使用一个正则表达式取出数
            if (item.matches("\\d+")) {//匹配多位数
                stack.push(item);
            } else {
                //pop两个数，并运算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
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
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }


}

class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                break;
        }
        return result;
    }
}