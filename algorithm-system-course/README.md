bobo老师的算法与数据结构体系课学习笔记

## 排序基础
### 1. 选择排序
* 实现1：每次选出最小的

    <img src="https://i.loli.net/2021/06/14/lkDJwuqXcyrUCnj.png" style="zoom: 40%" />

    问题：这种方式新开辟了空间，能否原地完成？

* 实现2：每次找出最小的与前面的元素进行交换
    
    <img src="https://i.loli.net/2021/06/14/bkL57AY8m1auhDS.png" style="zoom: 40%"/>

    维持循环不变量：在i等于n的时候循环不变量也都是成立的

    <img src="https://i.loli.net/2021/06/14/RBWMYn8i7howjH1.png" style="zoom: 40%"/>

* 通过范型实现

### 2. 插入排序
#### 基本思想
每次把当前的元素插入到前面已经有序的元素中，类似于扑克牌

<img src="https://i.loli.net/2021/06/14/wdPpymraL1GHNuz.png" style="zoom: 40%"/>

和选择排序的区别

#### 优化：
不是每次交换插入，而是向后平移

<img src="https://i.loli.net/2021/06/14/NdJtvIDBKMoxUul.png" style="zoom: 40%"/>

#### 实现
* 范型实现
* 一个很重要的特性：对于基本有序的数组，插入排序可以做到O(n)
* 换个方式实现插入排序：循环不变量：a[0,i)为排序，a[i,n)已排序
