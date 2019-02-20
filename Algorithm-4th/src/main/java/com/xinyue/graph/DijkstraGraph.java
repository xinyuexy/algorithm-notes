package com.xinyue.graph;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Dijkstra算法(采用邻接链表和优先队列实现)
 * 参考:geeksforgeeks
 */
public class DijkstraGraph {
    int V;  //图的顶点数
    LinkedList< Pair<Integer,Integer> >[] adj;    //邻接链表(使用Pair类型存储顶点和权重)
    int[] dist;     //存储每个顶点到源点的距离

    public DijkstraGraph(int V) {
        this.V = V;
        adj = (LinkedList< Pair<Integer,Integer> >[])new LinkedList[V];
        dist = new int[V];
        for(int i=0; i<V; i++) {
            adj[i] = new LinkedList<Pair<Integer, Integer>>();
            dist[i] = Integer.MAX_VALUE;
        }
    }

    public void addEdge(int u, int v, int weight) {
        adj[u].add(new Pair<Integer, Integer>(v, weight));
        adj[v].add(new Pair<Integer, Integer>(u, weight));
    }

    public void shortestPath(int src) {
        //自定义比较器,实现最小优先队列
        Comparator<Pair<Integer,Integer>> cmp = new Comparator<Pair<Integer, Integer>>() {
            public int compare(Pair<Integer,Integer> o1, Pair<Integer,Integer> o2) {
                if(o1.getValue() > o2.getValue()) return 1;
                else if(o1.getValue() < o2.getValue()) return -1;
                else return 0;
            }
        };

        PriorityQueue<Pair<Integer,Integer>> minpq = new PriorityQueue<Pair<Integer, Integer>>(10,cmp);
        minpq.add(new Pair<Integer, Integer>(src, 0));  //将源点加入优先队列
        dist[src] = 0;

        //最外一层循环相当于BFS，时间复杂度为O(V+E)
        while(!minpq.isEmpty()) {
            //从优先队列中取出距离最小顶点
            int u = minpq.poll().getKey();

            //访问其邻接点，更新距离
            for(Pair<Integer,Integer> pair: adj[u]) {
                int v = pair.getKey();
                int weight = pair.getValue();

                //  If there is shorted path to v through u.
                if(dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    minpq.add(new Pair<Integer, Integer>(v, dist[v]));
                }
            }
        }

        //打印最短路径
        System.out.println("Vertex   Distance from Source");
        for(int i=0; i<V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }


    public static void main(String[] args) {
        int V = 9;
        DijkstraGraph g = new DijkstraGraph(V);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        g.shortestPath(1);
    }
}
