package com.xinyue.graph;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 有向图中基于深度优先搜索的顶点排序.
 * @date 2017/12/15
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;    //所有顶点的前序排列
    private Queue<Integer> post;    //所有顶点的后序
    private Stack<Integer> reversePost;     //所有顶点的逆后序

    public DepthFirstOrder(Digraph G) {
        pre = new LinkedList<Integer>();
        post = new LinkedList<Integer>();
        reversePost = new Stack<Integer>();
        marked = new boolean[G.getV()];

        for(int v=0; v<G.getV(); v++) {
            if(!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        pre.offer(v);
        marked[v] = true;

        for(int w: G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w);
            }
        }
        post.offer(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }

    public static void main(String[] args) {
        String filename = "src/main/java/com/xinyue/Graph/tinyDAG.txt";
        try {
            Digraph G = new Digraph(filename);
            DepthFirstOrder dfs = new DepthFirstOrder(G);

            System.out.println("Preorder: ");
            for(int v: dfs.pre()) {
                System.out.print(v + " ");
            }
            System.out.println();

            System.out.println("Postorder: ");
            for(int v: dfs.post()) {
                System.out.print(v + " ");
            }
            System.out.println();

            System.out.println("Reverse postorder: ");
            Stack<Integer> temp = new Stack<Integer>();
            for(int v: dfs.reversePost()) {
                temp.push(v);
            }
            while (!temp.isEmpty()) {
                System.out.print(temp.pop() + " ");
            }
            System.out.println();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
