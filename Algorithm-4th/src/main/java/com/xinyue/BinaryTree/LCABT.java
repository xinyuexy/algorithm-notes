package com.xinyue.BinaryTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * find Lowest Common Ancestor in a Binary Tree.
 * @author xinyue
 * @date 2017/11/26
 */
public class LCABT {

    /**
     * Method 1 (By Storing root to n1 and root to n2 paths):
     * Following is simple O(n) algorithm to find LCA of n1 and n2.
     * 1) Find path from root to n1 and store it in a vector or array.
     * 2) Find path from root to n2 and store it in another vector or array.
     * 3) Traverse both paths till the values in arrays are same. Return the common element just before the mismatch.
     */

    public String findLCA1(Node root, String n1, String n2) {
        List<String> path1 = new ArrayList<String>();
        List<String> path2 = new ArrayList<String>();

        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
            return "";
        }

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i))) {
                break;
            }
        }

        return path1.get(i-1);
    }

    /**
     * Method 2 (Using Single Traversal)
     */
    public Node findLCA2(Node node, String n1, String n2) {
        if(node == null) {
            return null;
        }

        if(node.data.equals(n1) || node.data.equals(n2)) {
            return node;
        }

        Node left_lca = findLCA2(node.left, n1, n2);
        Node right_lca = findLCA2(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if(left_lca != null && right_lca != null) {
            return node;
        }

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }


    /**
     * store a path from root to n(data)
     * @param root root node of binary tree
     * @param n  the node's data
     * @param path  store the path from root to n
     * @return
     */
    private boolean findPath(Node root, String n, List<String> path) {
        if(root == null) {
            return false;
        }

        path.add(root.data);

        if (root.data.equals(n)) {
            return true;
        }

        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }

        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }

        path.remove(path.size()-1);

        return false;
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        LCABT lca = new LCABT();

        try {
            Node root = bt.buildTreeByFile("src/main/java/com/xinyue/BinaryTree/testData.txt","#");
            System.out.println("LCA method1:");
            System.out.println("LCA(c,e): " + lca.findLCA1(root, "c", "e"));
            System.out.println("LCA method2:");
            System.out.println("LCA(c,e): " + lca.findLCA2(root, "c", "e").data);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
