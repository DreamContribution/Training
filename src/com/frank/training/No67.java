package com.frank.training;

public class No67 {
    public static void main(String[] args) {
        No67 no67 = new No67();
        System.out.println(no67.addBinary("11", "1"));

        //int a = 3;
        //int b = 1;
        //int c = a + b;
        //System.out.println(Integer.toBinaryString(c));
    }

    public String addBinary(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }
}
