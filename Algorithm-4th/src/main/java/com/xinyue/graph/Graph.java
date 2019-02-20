package com.xinyue.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Undirected Graph implemented by adjacency list.
 * @author xinyue
 * @date 2017/12/4
 */
public class Graph {
    private int V;   //顶点个数
    private int E;
    private LinkedList<Integer>[] adjList;    //邻接链表数组

    public Graph(int V) {
        if(V < 0) {
            throw new IllegalArgumentException("Number of vertices must be nonnegative");
        }
        this.V = V;
        this.E = 0;
        //创建邻接表
        adjList = (LinkedList<Integer>[])new LinkedList[V];
        //初始化所有表为空
        for(int v=0; v<V; v++) {
            adjList[v] = new LinkedList<Integer>();
        }
    }

    /**
     * 从文件构造图
     * @param filename
     */
    public Graph(String filename) throws FileNotFoundException {
        File file = new File(filename);
        String encoding = "utf-8";
        Scanner sc = new Scanner(file, encoding);
        this.V = sc.nextInt();
        if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
        adjList = (LinkedList<Integer>[])new LinkedList[V];
        //初始化所有表为空
        for(int v=0; v<V; v++) {
            adjList[v] = new LinkedList<Integer>();
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
        adjList[v].addFirst(w);
        adjList[w].addFirst(v);
        E++;
    }

    public int getV() { return V; }

    public int getE() { return E; }

    public Iterable<Integer> adj(int v) {
        return adjList[v];
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
            for(int w: adjList[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }


    public static void main(String[] args) {
        String filename = "src/main/java/com/xinyue/Graph/tinyG.txt";
        try {
            Graph G = new Graph(filename);
            //第一种遍历方式
            Iterable<Integer> it = G.adj(0);
            for(int w: it) {
                System.out.print(w + " ");
            }
            System.out.println();
            //第二种遍历方式
            Iterator it2 = it.iterator();
            while(it2.hasNext()) {
                System.out.print(it2.next() + " ");
            }
            System.out.println();
            //打印图
            System.out.println(G);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
