package com.frank.data.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        // 测试栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show");
            System.out.println("exit");
            System.out.println("push");
            System.out.println("pop");
            System.out.println("请输入选项");
            key = scanner.next();
            switch (key) {
                // 自己完成后续任务，懒得写的
            }
        }
    }
}

//定义一个类表示栈
class ArrayStack {

    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈
    private int top = -1;//表示栈顶，初始化为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        //先判断栈是否满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        //先判断是否空
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈:从栈顶开始
    public void list() {
        if (isEmpty()) {
            System.out.println("空栈！");
            return;
        }
        for (int i = top; i >= 0; i++) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }


}
