package com.xinyue.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 加权无向图实现.
 */
public class EdgeWeightedGraph {
    private int V;
    private int E;
    private LinkedList<Edge>[] adj;  //保存边的邻接表

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Edge>[]) new LinkedList[V];
        for(int v=0; v<V; v++) {
            adj[v] = new LinkedList<Edge>();
        }
    }

    public EdgeWeightedGraph(String filename) throws FileNotFoundException {
        File file = new File(filename);
        String encoding = "utf-8";
        Scanner sc = new Scanner(file, encoding);

        this.V = sc.nextInt();
        if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
        adj = (LinkedList<Edge>[])new LinkedList[V];
        //初始化所有表为空
        for(int v=0; v<V; v++) {
            adj[v] = new LinkedList<Edge>();
        }

        int E = sc.nextInt();
        if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
        for(int i=0; i<E; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            double weight = sc.nextDouble();
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }

    private void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        List<Edge> list = new LinkedList<Edge>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                // add only one copy of each self loop (self loops will be consecutive)
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + "\n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String filename = "src/main/java/com/xinyue/Graph/tinyEWG.txt";
        try {
            EdgeWeightedGraph G = new EdgeWeightedGraph(filename);
            System.out.println(G);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
