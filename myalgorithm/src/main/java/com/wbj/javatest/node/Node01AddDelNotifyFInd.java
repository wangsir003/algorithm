package com.wbj.javatest.node;


import java.awt.SystemColor;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/9/10 上午10:37
 * 描述：
 */
public class Node01AddDelNotifyFInd {
    //查找链表中的元素

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 1; i < 10; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }

        String name = "王保军";
        System.out.println("name:" + name + "|hash:" + name.hashCode() + "|" + name);
        modifyName(name);
        System.out.println("name:" + name + "|hash:" + name.hashCode() + "|" + name);
        //遍历 链表
        long start = System.currentTimeMillis();

        //hasnext 遍历链表
//        printNode(head);
        //递归遍历链表
//        printNode2(head);
        //whiletrue 遍历
        printNode3(head);
        printNode3(head);
        System.out.println("共耗时：" + (System.currentTimeMillis() - start));
        System.out.println("header-hashcode2:" + head.hashCode());
        //查询 链表
        //查询偶数数字出现次数

        System.out.println("出现次数：" + times(head));
        System.out.println("header-hashcode3:" + head.hashCode());

        //删除链表中的奇数 - 通过创建新的链表
        ListNode delResult = delOddByNewNode(head);
        printNode2(delResult);
        System.out.println("++++++++++++++++++");
        //删除链表中的奇数 - 通过递归
        ListNode delResult2 = delOddByDiGUi(head);
        printNode2(delResult2);


    }

    private static ListNode delOddByDiGUi(ListNode head) {
        //出口
       if (head == null){
           return null;
       }
       if (head.val % 2 == 0){
           //判断下一个
           head.next = delOddByDiGUi(head.next);
       }else {
           head = delOddByDiGUi(head.next);
       }
        return head;

    }

    /**
     * 删除奇数
     *
     * @param node
     * @return
     */
    private static ListNode delOddByNewNode(ListNode node) {
        //新链表 ,记录链表当前位置
        ListNode newNode = null,currNode = null;
        //遍历链表的指针
        while (node != null) {
            System.out.println("node:" + node.val);
            //符合条件放在新链表上
            if (node.val % 2 == 0) {
                if (newNode == null) {
                    newNode = new ListNode(node.val);
                    currNode = newNode;
                } else {
                    currNode.next = new ListNode(node.val);
                    currNode = currNode.next;
                }
            }
            node = node.next;
        }
        return newNode;
    }

    private static void modifyName(String name) {
        System.out.println("modifyName0:" + name + "|hash:" + name.hashCode() + "|" + name);
        name = "张三";
        System.out.println("modifyName1:" + name + "|hash:" + name.hashCode() + "|" + name);
    }

    private static int times(ListNode head) {
        int num = 0;
        while (head != null) {
            if (head.val % 2 == 0) {
                num++;
            }
            head = head.next;
        }
        return num;
    }

    private static void printNode3(ListNode node1) {
        System.out.println("header-hashcode20:" + node1.hashCode());
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

    private static void printNode2(ListNode node1) {
        if (node1 != null) {
            System.out.println(node1.val);
            printNode2(node1.next);
        }
    }

    private static void printNode(ListNode head) {
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println(head.val);
    }

}
