package com.xinyue.graph;

import java.util.Stack;

/**
 * Dijkstra算法实现最短路径(针对无向带权图).
 * 图使用邻接矩阵（时间复杂度为O(V^2)）
 * (非常朴素的方法，后面采用邻接链表实现会更好)
 * 参考geeksforgeeks
 * @date 2018/1/6
 */
public class DijkstraSP {
    private boolean[] marked;
    private int[] dist;  //保存各顶点到源点的距离
    private int[] parent;     //保存源点到各点的路径
    private int s;

    public DijkstraSP(int graph[][], int V, int s) {
        this.s = s;
        marked = new boolean[V];
        dist = new int[V];
        parent = new int[V];
        for(int i=0; i<V; i++) {
            marked[i] = false;
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;
        parent[s] = -1;

        //每次循环都会有一个顶点被挑选,除了源点外还有V-1个顶点
        for(int count=0; count < V-1; count++) {
            //每次从未访问的顶点中找一个离源点距离最小的
            int u = minDistance();
            marked[u] = true;

            //更新u的邻接点距源点的距离值
            for(int v=0; v<V; v++) {
                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if(!marked[v] && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }
    }

    private int minDistance() {
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for(int v=0; v<dist.length; v++) {
            if(marked[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    public Stack<Integer> getPath(int v) {
        Stack<Integer> path = new Stack<Integer>();
        for(int i=v; parent[i]!=-1; i=parent[i]) {
            path.push(i);
        }
        path.push(s);
        return path;
    }

    public void printSolution()
    {
        System.out.println("path            dist");
        for (int v = 0; v < dist.length; v++) {
            Stack<Integer> path = getPath(v);
            while (!path.isEmpty()) {
                int u = path.pop();
                if(u != v)
                    System.out.print(u + "-");
                else System.out.print(u + "\t\t\t");
            }
            System.out.println(dist[v]);
        }
    }


    public static void main(String[] args) {
        int graph[][] = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        DijkstraSP dj = new DijkstraSP(graph, 9, 0);
        dj.printSolution();
    }
}
