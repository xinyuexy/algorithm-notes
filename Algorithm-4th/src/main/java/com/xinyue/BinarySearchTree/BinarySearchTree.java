package com.xinyue.BinarySearchTree;

/**
 * Binary Search Tree implementation.
 * @author xinyue
 * @date 2017/11/28
 */

public class BinarySearchTree<T extends Comparable<T>> {

    private class Node {
        T key;
        Node left;
        Node right;

        public Node(T key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    /**
     * 查找指定键值是否存在
     * @param key 键值
     * @return 存在返回true，否则返回false
     */
    public boolean Search(T key) {
        return Search(root, key);
    }

    private boolean Search(Node node, T key) {
        if(node == null) {
            return false;
        }

        if(node.key == key) {
            return true;
        }
        else if(node.key.compareTo(key) > 0) {
            return Search(node.left, key);
        }
        else {
            return Search(node.right, key);
        }
    }

    /**
     * 插入键值为key的结点
     * @param key
     */
    public void Insert(T key) {
        root = Insert(root, key);
    }

    private Node Insert(Node node, T key) {
        if(node == null) {
            return new Node(key);
        }

        int cmp = key.compareTo(node.key);
        if(cmp < 0) {
            node.left = Insert(node.left, key);
        }
        else if(cmp > 0) {
            node.right = Insert(node.right, key);
        }
        return node;
    }

    /**
     * 删除指定结点
     * @param key
     */
    public void delete(T key) {
        root = delete(root, key);
    }

    /**
     * 递归删除结点，分情况考虑
     * @param node
     * @param key
     * @return
     */
    private Node delete(Node node, T key) {
        if(node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if(cmp < 0) {
            node.left = delete(node.left, key);
        }
        else if(cmp > 0) {
            node.right = delete(node.right, key);
        }
        else {
            // node with only one child or no child
            if(node.right == null) {
                return node.left;
            }
            if(node.left == null) {
                return node.right;
            }

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            //用其后继结点(右子树中最小结点)替换，然后删除其后继结点
            node.key = minValue(node.right);
            node.right = delete(node.right, node.key);
        }
        return node;
    }

    private T minValue(Node node) {
        if(node.left == null) {
            return node.key;
        }
        return minValue(node.left);
    }

    /**
     * 中序遍历
     */
    public void Inorder() {
        Inorder(root);
    }

    private void Inorder(Node node) {
        if(node == null) {
            return;
        }

        Inorder(node.left);
        System.out.print(node.key + " ");
        Inorder(node.right);
    }

}
