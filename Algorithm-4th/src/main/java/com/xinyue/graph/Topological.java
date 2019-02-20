package com.xinyue.graph;

import java.io.FileNotFoundException;
import java.util.Stack;

/**
 * 有向无环图拓扑排序.
 * @date 2017/12/15.
 */
public class Topological {
    private boolean[] marked;
    private Stack<Integer> topoOder;

    public Topological(Digraph G) {
        marked = new boolean[G.getV()];
        topoOder = new Stack<Integer>();

        DirectedCycle cyclefinder = new DirectedCycle(G);
        if(!cyclefinder.hasCycle()) {
            for(int v=0; v<G.getV(); v++) {
                if(!marked[v]) {
                    dfs(G, v);
                }
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for(int w: G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w);
            }
        }
        topoOder.push(v);
    }

    public Stack<Integer> getTopoOder() {
        return topoOder;
    }

    public static void main(String[] args) {
        String filename = "src/main/java/com/xinyue/Graph/tinyDAG.txt";
        try {
            Digraph G = new Digraph(filename);
            Topological topo = new Topological(G);
            Stack<Integer> order = topo.getTopoOder();
            while(!order.isEmpty()) {
                System.out.print(order.pop() + " ");
            }
            System.out.println();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
