package com.frank.data.recursion;

public class Maze {
    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫
        int[][] map = new int[8][7];
        //处理墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 7; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置特殊情况的挡板
        map[3][1] = 1;
        map[3][2] = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map, 1, 1);
        //显示小球走过的路
        System.out.println("结果如下");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯给小球找路
     * 能找到6，5时，说明找到
     * 1:墙 2:通路 3:回头路，但走不通
     * 策略：↓ → ↑ ←，不通则回溯
     *
     * @param map 地图
     * @param i   从哪个位置开始
     * @param j   从哪个位置开始
     * @return 是否找到
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                //没走过，按策略尝试
                map[i][j] = 2;//假设该点能走通
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    //该点走不通，置位三
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}

