package com.frank.data.hashtable;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
//创建Hash表
        HashTab hashTab = new HashTab(7);
        //写一个简单菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:添加");
            System.out.println("list:展示");
            System.out.println("find:查找");
            System.out.println("exit:退出");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("please input id");
                    int id = scanner.nextInt();
                    System.out.println("please input name");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("please input target id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    break;
                default:
                    break;
            }
        }
    }
}

class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTab(int size) {
        this.empLinkedListArray = new EmpLinkedList[size];
        this.size = size;
        // 重点！！！分别初始化每条链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    public void add(Emp emp) {
        //根据员工的id,得到该员工应当添加到哪条列表
        int empLinkedListNo = hashFun(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    //遍历Hash表
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    public void findEmpById(int id) {
        //使用散列函数确定到哪条链表查找
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp != null) {
            System.out.printf("在第%d表中找到该雇员 雇员 id = %d,name = %s\n", empLinkedListNo + 1, emp.id, emp.name);
        } else {
            System.out.println("在Hash表中，没有找到该雇员");
        }
    }

    public int hashFun(int id) {
        return id % size;
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList {
    private Emp head;//第一个雇员

    //加到最后
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    //遍历链表信息
    public void list(int no) {
        if (head == null) {
            System.out.printf("第%d链表为空\n", no + 1);
            return;
        }
        System.out.printf("第%d链表的信息为：", no + 1);
        Emp curEmp = head;
        while (true) {
            System.out.printf("=> id= %d,name = %s  ", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                System.out.println();
                return;
            }
            curEmp = curEmp.next;
        }
    }

    /**
     * 找到返回emp，否则返回null
     *
     * @param id
     * @return
     */
    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                //此时curEmp即为目标Emp
                break;
            }
            if (curEmp.next == null) {
                //没有找到
                return null;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}