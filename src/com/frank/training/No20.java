package com.frank.training;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class No20 {
    public static void main(String[] args) {
        No20 no20 = new No20();
        boolean valid = no20.isValid("()");
        System.out.println(valid);
    }


    public boolean isValid(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("(", 0);
        map.put("[", 2);
        map.put("{", 4);
        map.put(")", 1);
        map.put("]", 3);
        map.put("}", 5);
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(i, i + 1);
            if (map.containsKey(substring) && map.get(substring) % 2 == 0) {
                stack.push(substring);
            } else if (map.containsKey(substring) && map.get(substring) % 2 == 1) {
                if (stack.size() == 0) {
                    return false;
                }
                String peek = stack.peek();
                if (map.get(substring) - map.get(peek) == 1) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                continue;
            }
        }
        return stack.size() == 0;
    }
}
