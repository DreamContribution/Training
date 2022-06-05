package com.frank.data.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "松江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //singleLinkedList.add(hero1);
        //singleLinkedList.add(hero2);
        //singleLinkedList.add(hero3);
        //singleLinkedList.add(hero4);

        //按顺序添加
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        // 显示
        singleLinkedList.list();
        System.out.println("修改后的列表...");

        //测试修改的代码
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~！~~");
        singleLinkedList.update(newHeroNode);

        //singleLinkedList.delete(4);
        //singleLinkedList.delete(2);
        //singleLinkedList.delete(1);
        //singleLinkedList.delete(3);

        // 显示
        singleLinkedList.list();

        reverseList(singleLinkedList.getHead());
        System.out.println("reverse");
        singleLinkedList.list();

        System.out.println("reverse print");
        reversePrint(singleLinkedList.getHead());

        System.out.println("list...");
        singleLinkedList.list();
    }

    /**
     * 不改变链表结果，仅打印时翻转
     *
     * @param head
     */
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    public static void reverseList(HeroNode head) {
        // 当链表为空，或只有一个节点，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义辅助指针,帮助遍历原来链表
        HeroNode cur = head.next;
        HeroNode next = null;// 指向当前节点的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来链表
        while (cur != null) {
            next = cur.next;//暂时保存当前节点的下一个节点
            cur.next = reverseHead.next;//将cur下一个节点，指向新的链表的头部
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }
}

//定义SingleLinkedList管理英雄
class SingleLinkedList {
    // 先初始化头结点
    // 头节点，不存放数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 不考虑编号顺序时
     * 1.找到当前链表的最后节点
     * 2.将最后这个节点的next指向新的节点
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        // 因为头节点不参与存储，因此需要一个辅助变量
        HeroNode temp = head;
        // 遍历链表，找到最后
        while (true) {
            // 链表的最后
            if (temp.next == null) {
                break;
            }
            //否则后移
            temp = temp.next;
        }
        // 当退出while循环时，temp指向的是最后
        temp.next = heroNode;
    }

    /**
     * 根据顺序添加node
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        // 通过temp找到添加位置的前一个节点
        HeroNode temp = head;
        boolean flag = false;// 标识添加的编号是否存在
        while (true) {
            if (temp.next == null) {
                // 说明temp已经是链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {
                //位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {
                //已经存在，不添加
                flag = true;
                break;
            }
            temp = temp.next;
        }

        // 已存在，提示
        if (flag) {
            System.out.printf("待插入的英雄编号%d已经存在，不能存在！\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 修改节点信息，根据编号修改，即no不能改
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点
        HeroNode temp = head.next;
        boolean flag = false;//表示是否该节点
        while (true) {
            if (temp == null) {
                //链表遍历结束
                break;
            }
            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }

        //根据flag判断是否找到
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            //没有找到
            System.out.printf("没有找到%d的节点，不能修改\n", newHeroNode.no);
        }
    }

    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;//是否找到
        while (true) {
            if (temp.next == null) {
                //到链表最后，没找到
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("没有找到编号为%d的Node", no);
        }
    }

    // 显示链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将temp后移,否则死循环
            temp = temp.next;
        }
    }
}

// 定义HearNode，每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no + ", name='" + name + '\'' + ", nickName='" + nickName + '\'' + '}';
    }
}
