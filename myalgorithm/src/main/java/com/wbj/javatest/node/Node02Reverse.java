package com.wbj.javatest.node;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/9/14 下午10:45
 * 描述：
 */
public class Node02Reverse {
    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 1; i < 10; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        Solution s = new Solution();
        ListNode reverseNode = s.reverseList(head);
        NodeUtil.printNode(reverseNode);
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    //思路1：结合数组，利用数组的反转
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        ListNode n = head;
        while(n != null){
            list.add(n);
            n = n.next;
        }
        Collections.reverse(list);
        ListNode newNode = list.get(0);
        ListNode node = newNode;

        for(int i = 1;i < list.size();i++){
            node.next = list.get(i);
            node = node.next;
        }
        return newNode;
    }
}
