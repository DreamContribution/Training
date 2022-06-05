package com.frank.data.recursion;

public class Queue8 {
    //定义一个max共有多少皇后
    int max = 8;

    //定义数组，保存皇后位置
    int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("共有解法：" + count);
    }

    //放置第N个皇后
    //特别注意一点，check每一层每一次递归时，进入到check中，都有循环
    private void check(int n) {
        if (n == max) {
            // n == 8，其实前面8个已经放好
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先当前皇后n，放到该行的第1列
            array[n] = i;
            //判断当放置第N个皇后到i列时，是否冲突
            if (judge(n)) {
                //不冲突
                check(n + 1);
            }
            //冲突，则回溯，继续执行array[n] = i;
        }
    }

    //查看当放置第N个皇后时，检测该皇后是否与前面冲突
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //1.array[i] == array[n] 表示判断第n个皇后是否和前面的n-1个皇后在同一列
            //2.Math.abs(n - i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后与前面的是否在同一个斜线
            //对角线：行差 == 列差
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //将皇后的位置打印
    private void print() {
        count++;
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
