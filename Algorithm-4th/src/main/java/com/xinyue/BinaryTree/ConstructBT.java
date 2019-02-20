package com.xinyue.BinaryTree;

/**
 * Construct Binary Tree from given traversal arrays
 * (eg: given Inorder and Preorder traversals)
 * @author xinyue
 * @date 2017/11/26
 */
public class ConstructBT {

    private Node root;
    private int preIndex = 0;

    /**
     * build binary tree from Preorder and Inorder.
     * @return Node
     */
    public Node buildTreePreIn(String[] pre, String[] in, int inStart, int inEnd) {
        if(inStart > inEnd) {
            return null;
        }

        /* Pick current node from Preorder traversal using preIndex
        and increment preIndex */
        Node node = new Node(pre[preIndex++]);

        /* If this node has no children then return */
        if(inStart == inEnd) {
            return node;
        }

        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(in, inStart, inEnd, node.data);

        /* Using index in Inorder traversal, construct left and
           right subtress */
        node.left = buildTreePreIn(pre, in, inStart, inIndex - 1);
        node.right = buildTreePreIn(pre, in, inIndex + 1, inEnd);
        return node;
    }

    /**
     * Function to find index of value in arr[start...end]
     * The function assumes that value is present in in[]
     */
    private int search(String[] arr, int start, int end, String value) {
        int i;
        for(i = start; i <= end; i++) {
            if(arr[i] == value) {
                return i;
            }
        }
        return i;
    }

    public void printPostorder(Node node) {
        if(node == null) {
            return;
        }

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        ConstructBT cbt = new ConstructBT();
        String[] in = new String[] {"D", "B", "E", "A", "F", "C"};
        String[] pre = new String[] {"A", "B", "D", "E", "C", "F"};

        Node root = cbt.buildTreePreIn(pre, in, 0, in.length - 1);
        cbt.printPostorder(root);
    }

}
