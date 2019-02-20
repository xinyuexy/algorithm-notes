package com.xinyue.graph;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图求连通分量(使用DFS).
 * @date 2017/12/10.
 */
public class CC {
    private boolean[] marked;
    /**
     * id 每个顶点对应的连通分量编号
     * count 连通分量个数
     */
    private int[] id;
    private int count = 0;

    public CC(Graph G) {
        marked = new boolean[G.getV()];
        id = new int[G.getV()];
        //必须对每个顶点进行dfs
        for(int s=0; s<G.getV(); s++) {
            if(!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for(int w: G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w);
            }
        }
    }

    /**
     * 判断两个点是否连接，只需看是否属于同一个连通分量
     */
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }


    public static void main(String[] args) {
        String filename = "src/main/java/com/xinyue/Graph/tinyG.txt";
        try {
            Graph G = new Graph(filename);
            CC cc = new CC(G);
            int m = cc.count();
            System.out.println(m + " components");

            // compute list of vertices in each connected component
            Queue<Integer>[] components = (Queue<Integer>[]) new Queue[m];
            for(int i=0; i<m; i++) {
                components[i] = new LinkedList<Integer>();
            }
            for(int v=0; v<G.getV(); v++) {
                components[cc.id(v)].offer(v);
            }

            for(int i=0; i<m; i++) {
                for(int v: components[i]) {
                    System.out.print(v + " ");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
