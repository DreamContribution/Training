package com.frank.data.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试");
        HeroNode2 hero1 = new HeroNode2(1, "松江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();
        // 修改
        HeroNode2 newHeroNode = new HeroNode2(4, "123", "456");
        doubleLinkedList.update(newHeroNode);
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 双线链表的删除可以直接找到需要删除的节点
     *
     * @param no 编号
     */
    public void delete(int no) {
        //判断当前是否为空
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;//是否找到
        while (true) {
            if (temp == null) {
                //到链表最后，没找到
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //temp.next = temp.next.next;
            temp.pre.next = temp.next;
            // 注意！！！如果是最后一个节点，temp.next为空
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("没有找到编号为%d的Node", no);
        }
    }

    // 修改节点信息，根据编号修改，即no不能改
    // 双向列表的修改跟单向链表一样
    public void update(HeroNode2 newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点
        HeroNode2 temp = head.next;
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

    /**
     * 添加一个节点到双线链表的最后
     *
     * @param heroNode
     */
    public void add(HeroNode2 heroNode) {
        // 因为头节点不参与存储，因此需要一个辅助变量
        HeroNode2 temp = head;
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
        // 形成双向链表
        heroNode.pre = temp;
    }

    //遍历双向链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
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
class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" + "no=" + no + ", name='" + name + '\'' + ", nickName='" + nickName + '\'' + '}';
    }
}
