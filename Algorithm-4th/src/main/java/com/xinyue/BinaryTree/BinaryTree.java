package com.xinyue.BinaryTree;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * A basic implement of binary tree.
 * Created by xinyue on 2017/11/18.
 */

/**
 * node of binary tree.
 */
class Node {
    String data;
    Node left;
    Node right;

    public Node(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {

    /**
     * root of binary tree
     */
    private Node root;

    /**
     * Initializes an empty binary tree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Create binary tree from System.in
     * endFlag is the flag of null node
     */
    public Node buildTree(String endFlag) throws IOException {
        Scanner scn = new Scanner(System.in);
        root = createTree(root, scn, endFlag);
        return root;
    }

    /**
     * Create binary tree from file
     * end flag : '#'
     */
    public Node buildTreeByFile(String filename, String endFlag) throws IOException {
        FileReader fin = new FileReader(filename);
        Scanner scn = new Scanner(fin);
        root = createTree(root, scn, endFlag);
        return root;
    }

    /**
     * Create binary tree by preOrder Traverse
     */
    private Node createTree(Node node, Scanner scn, String endFlag) {
        String data = scn.next();
        if(data.equals(endFlag)) {
            return null;
        }
        else {
            node = new Node(data);
            node.left = createTree(node.left,scn,endFlag);
            node.right = createTree(node.right,scn,endFlag);
            return node;
        }
    }

    /**
     *  preorder traversal recursive (root - left - right)
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node!=null) {
            visit(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     *  inorder traversal recursive (left - root - right)
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node!=null) {
            inOrder(node.left);
            visit(node);
            inOrder(node.right);
        }
    }

    /**
     *  postorder traversal recursive (left - right - root)
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node!=null) {
            postOrder(node.left);
            postOrder(node.right);
            visit(node);
        }
    }

    /**
     *  The operation of node when traversal
     */
    private void visit(Node node) {
        System.out.print(node.data + " ");
    }

    /**
     *  traversal by level
     */
    public void levelOrder() {
        if(root==null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        //add element
        q.offer(root);

        while(!q.isEmpty()) {
            //get and remove element
            Node node = q.poll();
            visit(node);
            if(node.left!=null) {
                q.offer(node.left);
            }
            if(node.right!=null) {
                q.offer(node.right);
            }
        }
    }

    /**
     *  Get the count of node
     */
    public int getSize() {
        return getSize(root);
    }

    private int getSize(Node node) {
        if(node==null) {
            return 0;
        } else {
            return 1 + getSize(node.left) + getSize(node.right);
        }
    }

    /**
     *  Get the height of binary tree
     */
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node node) {
        if(node == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }
    }

}
