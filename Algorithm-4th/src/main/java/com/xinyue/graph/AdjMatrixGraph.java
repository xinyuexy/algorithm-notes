package com.xinyue.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Undirected Graph implemented by adjacency matrix.
 * @author xinyue
 * @date 2017/12/4
 */
public class AdjMatrixGraph {
    private int V;
    private int E;
    private int[][] adj;

    public AdjMatrixGraph(int V) {
        if(V < 0) {
            throw new RuntimeException("Number of vertices must be nonnegative");
        }
        this.V = V;
        this.E = 0;
        this.adj = new int[V][V];
    }

    /**
     * 从文件构造图
     * @param filename
     */
    public AdjMatrixGraph(String filename) throws FileNotFoundException {
        File file = new File(filename);
        String encoding = "utf-8";
        Scanner sc = new Scanner(file, encoding);
        this.V = sc.nextInt();
        if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
        this.adj = new int[V][V];

        int E = sc.nextInt();
        if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
        for(int i=0; i<E; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            addEdge(v, w);
        }
    }

    public void addEdge(int v, int w) {
        if(adj[v][w]==0) {
            E++;
        }
        adj[v][w] = 1;
        adj[w][v] = 1;
    }

    /**
     * 是否包含边v--w
     * @return
     */
    public boolean contains(int v, int w) {
        if(adj[v][w]==0) {
            return false;
        }
        else {
            return true;
        }
    }

    public int getV() { return V; }
    public int getE() { return E; }

    public Iterable<Integer> adj(int v) {
        return new AdjIterator(v);
    }

    public Iterator<Integer> adj2(int v) {
        return new AdjIterator(v);
    }

    // support iteration over graph vertices
    private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
        private int v;
        private int w = 0;

        AdjIterator(int v) {
            this.v = v;
        }

        public Iterator<Integer> iterator() {
            return this;
        }

        public boolean hasNext() {
            while (w < V) {
                if (adj[v][w] != 0) return true;
                w++;
            }
            return false;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return w++;
        }

        public void remove()  {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges \n" );
        for(int v=0; v<V; v++) {
            s.append(v + ": ");
            for(int w: adj(v)) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }


    public static void main(String[] args) {
        String filename = "src/main/java/com/xinyue/Graph/tinyG.txt";
        try {
            AdjMatrixGraph G = new AdjMatrixGraph(filename);
            //第一种遍历方式
            Iterable<Integer> it = G.adj(0);
            for(int w: it) {
                System.out.print(w + " ");
            }
            System.out.println();
            //第二种遍历方式
            Iterator it2 = G.adj2(0);
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
