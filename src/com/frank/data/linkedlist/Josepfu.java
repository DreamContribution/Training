package com.frank.data.linkedlist;

/**
 * 约瑟夫问题
 */
public class Josepfu {
    public static void main(String[] args) {
        // Test1
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addBoy(5);
        list.showBoy();

        // Test2
        list.countBoy(1, 2, 5);
    }
}

//创建一个环形单向链表
class CircleSingleLinkedList {
    //创建一个first节点
    private Boy first = new Boy(-1);

    //添加Boy节点，构建环形链表
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;//辅助指针，帮助构建环形链表。注意，这里的辅助指针永远指向最后一个
        //使用一个for循环来创建一个环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号创建Boy节点
            Boy boy = new Boy(i);
            //如果是第一个小孩
            if (i == 1) {
                first = boy;
                first.setNext(first);//构成环装
                curBoy = first;// 让curBoy指向第一个小孩
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;// 记得移动辅助指针
            }
        }
    }

    //遍历当前环形链表
    public void showBoy() {
        //判断链表是否为空
        if (first == null || first.getNo() == -1) {
            System.out.println("链表为空");
            return;
        }
        // 因为first不能动，因此需要辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("Boy编号：%d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                // 已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext();//往后移动一个
        }
    }

    //根据用户的输入，计算出小孩出圈的顺序

    /**
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }

        // 创建一个辅助指针
        Boy helper = first;
        // 需要创建一个辅助指针，事先应该指向环形链表的最后这个节点
        while (true) {
            if (helper.getNext() == first) {
                //说明到最后了
                break;
            }
            helper = helper.getNext();
        }

        // 先让first和helper移动k-1次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first和helper指针同时移动m-1次，然后出圈
        while (true) {
            if (helper == first) { // 说明圈中只有一个人
                break;
            }
            //让first 和 helper 同时移动count-1次
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("Boy %d 出圈 \n", first.getNo());
            //这时将first出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的Boy %d \n", first.getNo());
    }

}

//创建于一个Boy类，表示一个节点
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
