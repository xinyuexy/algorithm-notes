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
