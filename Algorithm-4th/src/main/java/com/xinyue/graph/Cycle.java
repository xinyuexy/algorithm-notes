package com.xinyue.graph;

/**
 * 无向图检测环(不包括自环和平行边).
 * @date 2017/12/10
 */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.getV()];
        //图可能不连通，需要对所有顶点进行判断
        for(int s=0; s<G.getV(); s++) {
            if(!marked[s]) {
                dfs(G, s, s);
            }
        }
    }

    /**
     * 当再次访问到被访问过的结点，且不是当前结点的前一个结点，则存在环
     * @param G
     * @param v 当前访问的结点
     * @param u 记录当前的上一个结点
     */
    private void dfs(Graph G, int v, int u) {
        marked[v] = true;
        for(int w: G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w, v);
            }
            else if(w != u) {
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

}
