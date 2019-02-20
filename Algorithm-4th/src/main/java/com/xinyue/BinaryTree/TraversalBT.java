package com.xinyue.BinaryTree;

import java.io.IOException;
import java.util.Stack;

/**
 * About different traversal methods on binary tree
 * @author xinyue
 * @date 2017/11/22
 */
public class TraversalBT {

    public TraversalBT() {

    }

    /**
     * An iterative process to print preorder traversal of Binary tree
     * @param root
     */
    public void iterativePreorder(Node root) {
        if(root == null) {
            return;
        }

        // Create an empty stack and push root to it
        Stack<Node> nodeStack = new Stack<Node>();
        nodeStack.push(root);

        /* Pop all items one by one. Do following for every popped item
         a) print it
         b) push its right child
         c) push its left child
         Note that right child is pushed first so that left is processed first */
        while (nodeStack.empty() == false) {
            // Pop the top item from stack and print it
            Node node = nodeStack.pop();
            System.out.print(node.data + " ");
            // Push right and left children of the popped node to stack
            if(node.right != null) {
                nodeStack.push(node.right);
            }
            if(node.left != null) {
                nodeStack.push(node.left);
            }
        }
    }

    /**
     * An iterative inorder traversal
     * @param root
     */
    public void iterativeInorder(Node root) {
        if(root == null) {
            return;
        }

        Stack<Node> nodeStack = new Stack<Node>();
        Node node = root;

        /**
         *  first node to be visited will be the left one
         */
        while(node!=null) {
            nodeStack.push(node);
            node = node.left;
        }

        while(!nodeStack.isEmpty()) {
            node = nodeStack.pop();
            System.out.print(node.data + " ");

            //traverse right child
            if(node.right != null) {
                node = node.right;
                // the next node to be visited is the leftmost
                while(node != null) {
                    nodeStack.push(node);
                    node = node.left;
                }
            }
        }

    }

    /**
     * An iterative postorder traversal
     * use two stacks
     * root - right - left (similar to preorder)
     * reverse (left - rigth - root)
     * @param root
     */
    public void iterativePostorder(Node root) {
        if(root == null) {
            return;
        }

        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        s1.push(root);

        //root - right - left
        while(!s1.isEmpty()) {
            Node node = s1.pop();
            s2.push(node);

            if(node.left != null) {
                s1.push(node.left);
            }
            if(node.right != null) {
                s1.push(node.right);
            }
        }

        while(!s2.isEmpty()) {
            Node node = s2.pop();
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TraversalBT trabt = new TraversalBT();

        try {
            Node root = bt.buildTreeByFile("src/main/java/com/xinyue/BinaryTree/testData.txt","#");
            if(root != null) {
                System.out.println("recursion preorder:");
                bt.preOrder();
                System.out.println();
                System.out.println("iteration preorder:");
                trabt.iterativePreorder(root);
                System.out.println();

                System.out.println("recursion inorder:");
                bt.inOrder();
                System.out.println();
                System.out.println("iteration inorder:");
                trabt.iterativeInorder(root);
                System.out.println();

                System.out.println("recursion postorder:");
                bt.postOrder();
                System.out.println();
                System.out.println("iteration postorder:");
                trabt.iterativePostorder(root);
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
