## LeetCode刷题套路总结

### 1.数组

（1）双指针法（快慢，前后）

题目：283-[Move Zeroes](https://leetcode.com/problems/move-zeroes/)	27-[Remove Element](https://leetcode.com/problems/remove-element/)	26-[Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)	80-[Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)

（2）快速排序partition，三路快排（和快速排序区别）

题目：88-Merge Sorted Array	215-[Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array)

（3）对撞指针（首尾）

题目：167-Two Sum II - Input array is sorted	   125-Valid Palindrome	344-Reverse String	345-Reverse Vowels of a String		11-[Container With Most Water](https://leetcode.com/problems/container-with-most-water)

（4）滑动窗口（双索引技术/连续子数组）

209-[Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum)   	3-[Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters) 	76-[Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring)

### 2.查找表

**set和map**


>  哈希表的缺点是失去了数据的顺序性。


(1) set的使用

[349-Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays) 

(2) map的使用

350-[Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii)

(3) 使用查找表的经典问题: Two Sum

1-Two Sum  15-3Sum  18-4Sum   16-3Sum Closest 

(4) 灵活选择键值，究竟要查找什么.<br>
454-4Sum II 49-Group Anagrams

447-Number of Boomerangs    149-Max Points on a Line

(5) 查找表和滑动窗口 Contain Duplicate II <br>
219-Contains Duplicate II

(6) 二分搜索树底层实现的顺序性 Contain Duplicate III <br>
220-Contains Duplicate III



### 3.链表
**穿针引线**

(1) 反转链表 <br>
206-Reverse Linked List

反转m-n之间的链表:92-Reverse Linked List II

(2) 测试你的链表程序 <br>
[2-Add Two Numbers]   [83-Remove Duplicates from Sorted List]   [86-Partition List](https://leetcode.com/problems/partition-list/)

(3) 虚拟头结点(统一情况)<br>
[203-Remove Linked List Elements]   [82-Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)

(4)  5-4 复杂的穿针引线 <br>
[24-Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)      [25-Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/)

> 注意在做链表题的时候学会画图，设置好每个指针以及其作用。

(5)  5-5 不仅仅是穿针引线 Delete Node in a Linked List

(6) 5-6 链表与双指针 Remove Nth Node Form End of List <br>
[19-Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)  
[61-Rotate List](https://leetcode.com/problems/rotate-list/)    [143-Reorder List](https://leetcode.com/problems/reorder-list/)

### 4.栈，队列，优先队列
(1) 6-1 栈的基础应用

(2) 6-3 运用栈模拟递归（重点）<br>
看老师实现的代码

(3) 6-4 队列的典型应用 Binary Tree Level Order Traversal

(4) 6-5 BFS和图的最短路径 Perfect Squares

**广度优先遍历求最短路径：只针对无权图**

(5) 6-6 优先队列

### 5.二叉树和递归
**1) 递归**：
1. 跳出代码具体是怎样运行的，看代码本身所表示的语义。
2. 语义：设计一个函数就是固定做一个任务，在写函数逻辑的时候保证它完成这个任务。（
明确函数的意义，边界）

**2) 递归结构**: 1.递归终止条件；2.递归过程
<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g2xq5hd4quj30y70c2gpo.jpg" style="zoom:80%"/>

**3) 二叉树天然的递归结构**


**题目:**<br>
>解题时学会使用递归, 不要考虑代码具体如何运行的细节，从递归结构的整体性上考虑，弄清楚函数的意义

104-Maximum Depth of Binary Tree<br>
111-Minimum Depth of Binary Tree<br>
226-Invert Binary Tree<br>

**4) 注意递归的终止条件** <br>
>多个条件,二叉树中可能是叶子结点

**题目:**<br>
112-Path Sum<br>
111-Minimum Depth of Binary Tree<br>
404-Sum of Left Leaves<br>

**5) 定义递归问题** <br>
**题目**:<br>
257-Binary Tree Path<br>
113-Path Sum II<br>
129-Sum Root to Leaf Numbers

**6) 稍复杂的递归逻辑** <br>
437-Path Sum III

**7) 二分搜索树中的问题** <br>
**题目**:<br>
783 235	98 450 108 230 236 530

### 5.递归和回溯法
>Backtracking is an algorithm for finding all solutions by exploring all potential candidates. If the solution candidate turns to be not a solution (or at least not the last one), backtracking algorithm discards it by making some changes on the previous step, i.e. backtracks and then try again.

**1) 树形问题** <br>

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g36u5vzborj30z90i8qda.jpg" style="zoom: 80%"/>

**2) 什么是回溯** <br>
> 回溯法是暴力解法的一个主要实现手段，枚举所有可能性。

**题目**：17 93 131	797

**3) 排列问题** <br>

46-Permutations(树形问题)

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g37zdhthllj30wa0fodmb.jpg" style="zoom: 80%"/>

**4) 组合问题** <br>

77-Combinations

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g380w2tcptj31080dngrz.jpg" style="zoom: 80%"/>

**5) 回溯法解决组合问题的优化** <br>
剪支

77 39 40 216 78 90

**6) 二维平面上的回溯法** <br>

79-Word Search

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g397z5o7jwj30yl0eudm7.jpg" style="zoom: 80%"/>

**7) floodfill算法，一类经典问题** <br>
200-Number of Islands

130 417	695 694 733

**8) 回溯法是经典人工智能的基础 N Queens** <br>
<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g3b5e8kp91j30yr0g7q7f.jpg" style="zoom: 80%"/>

51	52 37

### 6.动态规划

**1) 什么是动态规划**

斐波那契数列问题：

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g3ep4aenrvj30y10imqda.jpg" style="zoom:60%"/>

**重叠子问题**

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g3ep5ufj2oj30vj0iwwlq.jpg" style="zoom:60%"/>


<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g3ep84yx7yj30uo0h5q9e.jpg" style="zoom:60%"/>

**动态规划定义：**

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g3epcgic4zj30zt0iagtt.jpg" style="zoom:60%"/>

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g3epdu97oij30w70iijy0.jpg" style="zoom:60%"/>



**2) 发现重叠子问题**

343-Integer Break

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g3o216fzkwj30xj0fngrx.jpg" style="zoom:60%"/>

(最优子结构)

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g3o23u8peoj30va0iuqa3.jpg" style="zoom:60%"/>


**3) 状态的定义和状态转移**

198-House Robber

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g3q2zra19oj30wo0eags3.jpg" style="zoom:80%"/>

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g3q33xr453j30yl0dg459.jpg" style="zoom:80%"/>

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g3q3c93oxxj30qw0ecwj5.jpg" style="zoom:60%"/>

题目：213 337 309

**4) 0-1背包问题**

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g3r8i8trp4j30vy0iktdu.jpg" style="zoom:60%"/>

**> 0-1背包问题的优化和变种**

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g3r8ykdfrhj30yb0if0yz.jpg" style="zoom:60%"/>

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g3r99m86gtj30x90go0xd.jpg" style="zoom:60%"/>

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g3r9e09mtqj30s30gydkh.jpg" style="zoom:60%"/>

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g3r9hbez83j30t70fbjv7.jpg" style="zoom:60%"/>

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g3r9hsq3m5j30nw0g5wi9.jpg" style="zoom:60%"/>


**5) 面试中的0-1背包问题**

416-Partition Equal Subset Sum

题目：322 377 474 139 494

**6) LIS问题 Longest Increasing Subsequence**

300	376(多种解法)

**7) LCS，最短路，求动态规划的具体解以及更多**

求具体解时，反向查找

### 7.贪心算法
**1) 贪心基础 Assign Cookies**

<img src="https://ws1.sinaimg.cn/mw690/006SQxbply1g3xae0s9o5j30n50g00wy.jpg" style="zoom:60%"/>

贪心算法往往需要排序

**2) 贪心算法与动态规划的关系 Non-overlapping Intervals**

435(既可以使用动态规划也可以使用贪心)

**3) 贪心选择性质的证明**

如果无法使用贪心算法，举出反例即可

如果无法举出反例，如何证明贪心算法的正确性<br>
(一般证明算法正确性使用数学归纳法或反证法)

贪心算法为A; 最优算法为O; 发现A完全能替代O，且不影响求出最优解

**最小生成树 最短路径**<br>
（融合贪心算法和其他的思想）


>大多数面试算法考察的都是基础，许多难题也是由基础拓展来的