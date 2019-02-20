package com.xinyue.graph;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Prim算法实现最小生成树.
 * 假定图是连通的.
 * 延时实现.
 */
public class LazyPrimMST {
    private boolean[] marked;   //记录顶点是否在最小生成树上
    private Queue<Edge> mst;    //保存最小生成树的边
    private PriorityQueue<Edge> pq;     //优先队列保存横切边

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new PriorityQueue<Edge>();
        marked = new boolean[G.V()];
        mst = new LinkedList<Edge>();

        visit(G, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.poll();   //从pq中获取权重最小的边
            int v = e.either();
            int w = e.other(v);
            //跳过失效的边,即两个顶点都在mst,否则会形成环
            if(marked[v] && marked[w]) continue;
            mst.add(e);
            //将顶点(v或w)添加到树中
            if(!marked[v]) visit(G, v);
            if(!marked[w]) visit(G, w);
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        //将顶点v加入最小生成树,并将所有连接v和不在最小生成树中的顶点加入pq
        marked[v] = true;
        for(Edge e: G.adj(v)) {
            if(!marked[e.other(v)]) {
                pq.add(e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public static void main(String[] args) {
        String filename = "src/main/java/com/xinyue/Graph/tinyEWG.txt";
        try {
            EdgeWeightedGraph G = new EdgeWeightedGraph(filename);
            LazyPrimMST mst = new LazyPrimMST(G);
            for(Edge e: mst.edges()) {
                System.out.println(e);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
