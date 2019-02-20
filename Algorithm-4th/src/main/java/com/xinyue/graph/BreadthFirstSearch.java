package com.xinyue.graph;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * BFS for graph.
 * store paths when search.
 * @date 2017/12/7
 */
public class BreadthFirstSearch {

    private boolean[] marked;   //访问标志
    private int[] edgeTo;   //存储路径,edgeTo[v]表示s--v
    private int s;  //源点

    public BreadthFirstSearch(Graph G, int s) {
        this.s = s;
        edgeTo = new int[G.getV()];
        marked = new boolean[G.getV()];
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new LinkedList<Integer>();
        marked[s] = true;
        queue.offer(s);

        while(!queue.isEmpty()) {
            int v = queue.poll();
            for(int w: G.adj(v)) {
                if(!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.offer(w);
                }
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
        if(!hasPathTo(v)) {
            return null;
        }
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
            BreadthFirstSearch bfs = new BreadthFirstSearch(G, s);
            System.out.println(G);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
