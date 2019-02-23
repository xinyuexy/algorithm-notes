import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//leetcode 447. Number of Boomerangs

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length < 3) {
            return 0;
        }

        Map<Integer, Integer> dis_map = new HashMap<>();
        int res = 0;
        for(int i=0; i<points.length; i++) {
            dis_map.clear();
            for(int j=0; j<points.length; j++) {
                if(j != i) {
                    int dis = distance(i, j, points);
                    if(dis_map.containsKey(dis)) {
                        dis_map.put(dis, dis_map.get(dis)+1);
                    } else {
                        dis_map.put(dis, 1);
                    }
                }
            }

            //迭代dis_map
            for(int count: dis_map.values()) {
                if(count >= 2) {
                    //乘法count-1要加括号啊
                    res += count * (count-1);
                }
            }
        }

        return res;
    }

    //用距离的平方,避免开根号导致浮点数精度问题
    //注意整形可能溢出
    private int distance(int i, int j, int[][] p) {
        return (p[i][0]-p[j][0]) * (p[i][0]-p[j][0]) +
                (p[i][1]-p[j][1]) * (p[i][1]-p[j][1]);
    }
}