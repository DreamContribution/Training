package com.frank.training;

public class No657 {

    public boolean judgeCircle(String moves) {
        int[] start = {0, 0};
        for (int i = 0; i < moves.length(); i++) {
            move(moves.charAt(i) + "", start);
        }
        return start[0] == 0 && start[1] == 0;
    }

    public void move(String command, int[] location) {
        switch (command) {
            case "R":
                location[0] += 1;
                break;
            case "L":
                location[0] -= 1;
                break;
            case "U":
                location[1] += 1;
                break;
            case "D":
                location[1] -= 1;
                break;
            default:
                break;
        }
    }
}
