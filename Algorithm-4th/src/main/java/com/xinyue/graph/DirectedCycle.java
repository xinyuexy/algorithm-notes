package com.xinyue.graph;

import java.io.FileNotFoundException;
import java.util.Stack;

/**
 * 有向图检测环.
 * @date 2017/12/10
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;

    public DirectedCycle(Digraph G) {
        marked = new boolean[G.getV()];
        edgeTo = new int[G.getV()];
        onStack = new boolean[G.getV()];
        for(int s=0; s<G.getV(); s++) {
            if(!marked[s]) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for(int w: G.adj(v)) {
            if(hasCycle()) {
                return;
            }
            if(!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
            else if(onStack[w]) {
                cycle = new Stack<Integer>();
                for(int x=v; x!=w; x=edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        //当前结点返回，退出递归栈
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    public static void main(String[] args) {
        String filename = "src/main/java/com/xinyue/Graph/tinyDG.txt";
        try {
            Digraph G = new Digraph(filename);
            DirectedCycle finder = new DirectedCycle(G);
            if(finder.hasCycle()) {
                System.out.println("Directed cycle: ");
                for(int v: finder.cycle()) {
                    System.out.print(v + " ");
                }
                System.out.println();
            }
            else {
                System.out.println("No directed cycle");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
