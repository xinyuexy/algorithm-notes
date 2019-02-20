package com.xinyue.graph;

import java.io.FileNotFoundException;
import java.util.Stack;

/**
 * DFS for Graph
 * store paths when search.
 * @date 2017/12/5
 */
public class DepthFirstSearch {

    private boolean[] marked;   //访问标志
    private int[] edgeTo;   //存储路径,edgeTo[v]表示s--v
    private int s;  //源点

    public DepthFirstSearch(Graph G, int s) {
        this.s = s;
        edgeTo = new int[G.getV()];
        marked = new boolean[G.getV()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for(int w: G.adj(v)) {
            if(!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    /**
     * 判断源点s到v是否存在路径
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * 返回一条从s到v的路径
     * @param v
     * @return
     */
    public Stack<Integer> pathTo(int v) {
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for(int x=v; x!=s; x=edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

    public static void main(String[] args) {
        String filename = "src/main/java/com/xinyue/Graph/tinyCG.txt";
        try {
            Graph G = new Graph(filename);
            int s = 0;
            DepthFirstSearch dfs = new DepthFirstSearch(G, s);
            System.out.println(G);

            for(int v=0; v<G.getV(); v++) {
                if(dfs.hasPathTo(v)) {
                    System.out.printf("%d to %d: ", s, v);
                    Stack<Integer> path = dfs.pathTo(v);
                    while(!path.isEmpty()) {
                        int x = path.pop();
                        if(x==s) System.out.print(x);
                        else System.out.print("-" + x);
                    }
                    System.out.println();
                }
                else {
                    System.out.printf("%d to %d:  not connected\n", s, v);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
