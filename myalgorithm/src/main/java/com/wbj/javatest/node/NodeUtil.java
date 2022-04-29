package com.wbj.javatest.node;

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/9/14 下午10:46
 * 描述：
 */
public class NodeUtil {

    static void printNode(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
