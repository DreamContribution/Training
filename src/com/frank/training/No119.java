package com.frank.training;

import java.util.ArrayList;
import java.util.List;

public class No119 {
    public static void main(String[] args) {
        No119 target = new No119();
        //List<Integer> list = new ArrayList<>();
        //list.add(1);
        //list.add(3);
        //list.add(3);
        //list.add(1);
        List<Integer> row = target.getRow(26);
        System.out.println(row.size());
        System.out.println(row);
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> C = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(C.get(i - 1).get(j - 1) + C.get(i - 1).get(j));
                }
            }
            C.add(row);
        }
        return C.get(rowIndex);
    }
}
