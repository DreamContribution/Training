package com.frank.training;

public class No14 {

    public static void main(String[] args) {
        //String abc = "123";
        //System.out.println(abc.substring(0, 0));
        String[] strs = {"dog", "racecar", "car"};
        No14 main = new No14();
        String s = main.longestCommonPrefix(strs);
        System.out.println("结果为：" + s);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String target = strs[0];
        for (int i = 0; i < target.length(); i++) {
            sb.append(target.charAt(i));
            for (String item : strs) {
                int index = item.indexOf(sb.toString());
                if (index != 0) {
                    //表示没找到或并非相同头
                    if (sb.length() > 0) {
                        return sb.substring(0, sb.length() - 1);
                    }
                }
            }
        }

        return sb.toString();
    }
}
