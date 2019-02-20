package com.xinyue.BinarySearchTree;

import java.util.Scanner;

/**
 * A unit test for binary search tree.
 * @author xinyue
 * @date 2017/11/29
 */
public class Test {
    public static void main(String[] args) {
        //创建对象
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        Integer[] arr = {50, 30, 20, 40, 70, 60, 80};
        for(Integer key: arr) {
            bst.Insert(key);
        }
        //中序遍历
        System.out.println("inorder traversal");
        bst.Inorder();
        System.out.println();

        //查找测试
        System.out.println("input search key: ");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        if(bst.Search(key)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }

        //删除测试
        System.out.println("input delete key: ");
        key = sc.nextInt();
        bst.delete(key);
        System.out.println("After delete " + key);
        bst.Inorder();
    }
}
