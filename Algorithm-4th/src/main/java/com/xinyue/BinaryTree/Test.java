package com.xinyue.BinaryTree;

import java.io.IOException;

/**
 * A test for binary tree
 * Created by xinyue on 2017/11/18.
 */
public class Test {
    public static void main(String[] args) {
        //从标准输入流创建二叉树
//        BinaryTree bt = new BinaryTree();
//        try {
//            System.out.println("input > ");
//            if(bt.buildTree("#")) {
//                System.out.println("preorder:");
//                bt.preOrder();
//                System.out.println();
//                System.out.println("inorder:");
//                bt.inOrder();
//                System.out.println();
//                System.out.println("height: " + bt.getHeight());
//                System.out.println("size: " + bt.getSize());
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //从文件创建二叉树(testData.txt),结束符为"#"
        BinaryTree bt2 = new BinaryTree();
        try {
            if(bt2.buildTreeByFile("src/main/java/com/xinyue/BinaryTree/testData.txt","#")) {
                System.out.println("preorder:");
                bt2.preOrder();
                System.out.println();
                System.out.println("inorder:");
                bt2.inOrder();
                System.out.println();
                System.out.println("height: " + bt2.getHeight());
                System.out.println("size: " + bt2.getSize());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
