package com.xinyue.uf;

/**
 * 并查集.
 */
import java.util.Scanner;
public class UF {
    private int[] id;     //分量id,以触点作为索引
    private int count;    //分量数量

    public UF(int N){
        count = N;
        id = new int[N];
        for (int i = 0;i < N;i++){
            id[i] = i;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public int find(int p){
        return id[p];
    }

    public void union(int p , int q){
        //将p和q所属的分量归并(连接两条链)
        int pID = find(p);
        int qID = find(q);

        //如果p和q已经在相同的分量当中则不需要采取任何行动
        if (pID==qID) return;

        for (int i = 0; i < id.length; i++){
            if (id[i] == pID) id[i] = qID;
        }
        count--;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the length of array!");
        int N = sc.nextInt();

        UF uf = new UF(N);

        while (sc.hasNext()){
            int p = sc.nextInt();
            int q = sc.nextInt();
            if (uf.connected(p,q)) continue;
            uf.union(p,q);
            System.out.println(p+""+q);
        }

        System.out.println(uf.count + "components");

    }

}