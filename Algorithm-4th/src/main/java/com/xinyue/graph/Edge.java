package com.xinyue.graph;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 带权边的数据类型.
 */
public class Edge implements Comparable<Edge> {
    private int v;
    private int w;
    private double weight;  //边的权重

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return  weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if(vertex == v) return w;
        else if(vertex == w) return v;
        else throw new RuntimeException("Inconsistent edge");
    }

    public int compareTo(Edge that) {
        if(this.weight() < that.weight()) return -1;
        else if(this.weight() > that.weight()) return +1;
        else return 0;
    }

    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }

    public static void main(String[] args) {
        //自定义比较器,实现最大优先队列
        Comparator<Edge> cmp = new Comparator<Edge>() {
            public int compare(Edge o1, Edge o2) {
                if(o2.weight > o1.weight) return 1;
                else if(o2.weight < o1.weight) return -1;
                else return 0;
            }
        };

        PriorityQueue<Edge> minpq = new PriorityQueue<Edge>();  //使用Edge里实现的comparable接口
        PriorityQueue<Edge> maxpq = new PriorityQueue<Edge>(10,cmp);    //自定义比较器
        for(int i=0; i<5; i++) {
            Edge e = new Edge(i, i+1, Math.random());
            maxpq.add(e);
            minpq.add(e);
        }
        System.out.println("Max PQ");
        while (!maxpq.isEmpty()) {
            System.out.println(maxpq.poll());
        }
        System.out.println("Min PQ");
        while (!minpq.isEmpty()) {
            System.out.println(minpq.poll());
        }
    }
}
