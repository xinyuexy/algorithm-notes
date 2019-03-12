### LeetCode刷题套路总结

#### 1.数组

（1）双指针法（快慢，前后）

题目：283-[Move Zeroes](https://leetcode.com/problems/move-zeroes/)	27-[Remove Element](https://leetcode.com/problems/remove-element/)	26-[Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)	80-[Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)

（2）快速排序partition，三路快排（和快速排序区别）

题目：88-Merge Sorted Array	215-[Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array)

（3）对撞指针（首尾）

题目：167-Two Sum II - Input array is sorted	   125-Valid Palindrome	344-Reverse String	345-Reverse Vowels of a String		11-[Container With Most Water](https://leetcode.com/problems/container-with-most-water)

（4）滑动窗口（双索引技术/连续子数组）

209-[Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum)   	3-[Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters) 	76-[Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring)

#### 2.查找表

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



#### 3.链表
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