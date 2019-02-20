package com.xinyue.graph;

import com.xinyue.uf.UF;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Kruskal's算法求最小生成树.
 */
public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new LinkedList<Edge>();
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        for(Edge e: G.edges()) {
            pq.add(e);
        }
        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);
            if(uf.connected(v, w)) continue;    //检测两个顶点之间是否连通

            uf.union(v, w);
            mst.add(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public static void main(String[] args) {
        String filename = "src/main/java/com/xinyue/Graph/tinyEWG.txt";
        try {
            EdgeWeightedGraph G = new EdgeWeightedGraph(filename);
            KruskalMST mst = new KruskalMST(G);
            for(Edge e: mst.edges()) {
                System.out.println(e);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
