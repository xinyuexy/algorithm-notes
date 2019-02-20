package com.xinyue.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Directed Graph implemented by adjlist.
 * @date 2017/12/8
 */
public class Digraph {
    private int V;
    private int E;
    private LinkedList<Integer>[] adj;    //邻接链表数组
    private int[] indegree;     //保存每个顶点入度

    public Digraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<Integer>();
        }
    }

    /**
     * 从文件构造图
     * @param filename
     */
    public Digraph(String filename) throws FileNotFoundException {
        File file = new File(filename);
        String encoding = "utf-8";
        Scanner sc = new Scanner(file, encoding);
        this.V = sc.nextInt();
        if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
        adj = (LinkedList<Integer>[])new LinkedList[V];
        indegree = new int[V];
        //初始化所有表为空
        for(int v=0; v<V; v++) {
            adj[v] = new LinkedList<Integer>();
        }

        int E = sc.nextInt();
        if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
        for(int i=0; i<E; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            addEdge(v, w);
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        indegree[w]++;
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int outdegree(int v) {
        return adj[v].size();
    }

    public int indegree(int v) {
        return indegree[v];
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    /**
     * 输出图的内容
     * @return
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges \n" );
        for(int v=0; v<V; v++) {
            s.append(v + ": ");
            for(int w: adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String filename = "src/main/java/com/xinyue/Graph/tinyDG.txt";
        try {
            Digraph G = new Digraph(filename);
            System.out.println(G);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
