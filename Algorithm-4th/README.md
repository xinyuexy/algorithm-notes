## About
本项目主要是对常用算法和数据结构的实现，采用**java**语言编写。参考《算法》第四版
___
## Table of Contents
* [Binary Tree](#1)
* [Binary Search Tree](#2)
* [Graph](#3)

<h3 id = "1">Binary Tree</h3>

* [基本实现](src/main/java/com/xinyue/BinaryTree/BinaryTree.java)
* [单元测试](src/main/java/com/xinyue/BinaryTree/Test.java)
* [知识梳理](src/main/java/com/xinyue/BinaryTree/README.md)
* 典型问题 <br/>
  * [遍历迭代实现](src/main/java/com/xinyue/BinaryTree/TraversalBT.java)
  * [先序中序构造二叉树](src/main/java/com/xinyue/BinaryTree/ConstructBT.java)
  * [最低公共祖先问题](src/main/java/com/xinyue/BinaryTree/LCABT.java)

<h3 id = "2">Binary Search Tree</h3>

* [基本实现](src/main/java/com/xinyue/BinarySearchTree/BinarySearchTree.java)
* [单元测试](src/main/java/com/xinyue/BinarySearchTree/Test.java)
* [知识梳理](src/main/java/com/xinyue/BinarySearchTree/readme.md)

<h3 id = "3">Graph</h3>

* 基本实现 <br/>
  * [邻接链表](src/main/java/com/xinyue/graph/Graph.java)
  * [邻接矩阵](src/main/java/com/xinyue/graph/AdjMatrixGraph.java)
  * [有向图实现](src/main/java/com/xinyue/graph/Digraph.java)
  * [加权无向图实现](src/main/java/com/xinyue/graph/EdgeWeightedGraph.java)
* [知识梳理](src/main/java/com/xinyue/graph/readme.md)
* 重要算法 <br/>
  * [广度优先遍历](src/main/java/com/xinyue/graph/BreadthFirstSearch.java)
  * [深度优先遍历](src/main/java/com/xinyue/graph/DepthFirstSearch.java)
* 典型问题 <br/>
  * [无向图求连通分量](src/main/java/com/xinyue/graph/CC.java)
  * [无向图检测环](src/main/java/com/xinyue/graph/Cycle.java)
  * [有向图检测环](src/main/java/com/xinyue/graph/DirectedCycle.java)
  * [拓扑排序实现](src/main/java/com/xinyue/graph/Topological.java)
  * [最小生成树Prim算法](src/main/java/com/xinyue/graph/LazyPrimMST.java)
  * [最小生成树Kruskal算法](src/main/java/com/xinyue/graph/KruskalMST.java)
  * Dijkstra求最短路径 <br/>
  	* [采用邻接矩阵O(V^2)](src/main/java/com/xinyue/graph/DijkstraSP.java)
  	* [采用邻接链表O(ElongV)](src/main/java/com/xinyue/graph/DijkstraGraph.java)