import java.util.List;
import java.util.Stack;

/// 144. Binary Tree Preorder Traversal
/// https://leetcode.com/problems/binary-tree-preorder-traversal/description/
/// 非递归二叉树的前序遍历
/// 时间复杂度: O(n), n为树的节点个数
/// 空间复杂度: O(h), h为树的高度
//此种方式写中序和后序遍历就很简单了

public class Solution144 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private class Command {
        String s;    // go, print
        TreeNode node;
        Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        
        Stack<Command> st = new Stack<>();
        st.add(new Command("go", root));

        while(!st.isEmpty()) {
            Command cd = st.pop();
            if(cd.s.equals("print")) {
                res.add(cd.node.val);
            } else {
                assert cd.s.equals("go");
                if(cd.node.right != null) {
                    st.add(new Command("go", cd.node.right));
                }
                if(cd.node.left != null) {
                    st.add(new Command("go", cd.node.left));
                }
                st.push(new Command("print", cd.node));
            }
        }

        return res;
    }
}