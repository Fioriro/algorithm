# Algorithm Notes

个人算法刷题仓库，主要用于整理 LeetCode、剑指 Offer 以及国内面试高频算法题。  
使用语言以 **Java** 为主，目标是沉淀可复用的题型模板、解题思路和高频题总结。

---

## 仓库目标

这个仓库主要解决几个问题：

- 按题型系统整理算法题，而不是零散堆积
- 沉淀常见算法模板，方便复习和面试前快速回顾
- 对高频题进行标记，优先覆盖 **LeetCode Hot 100**、**剑指 Offer**、国内常见面试题
- 建立统一的命名、分类和记录方式，降低后续维护成本

---

## 内容范围

当前仓库主要包含以下内容：

- **LeetCode 高频题**
- **LeetCode Hot 100**
- **剑指 Offer**
- 国内面试常见算法题
- 常见算法模板与专题总结

---

## 目录结构

```text
algorithm-notes/
├─ README.md
├─ templates/                  # 常用算法模板
│  ├─ binary_search.java
│  ├─ bfs.java
│  ├─ dfs.java
│  ├─ backtracking.java
│  ├─ union_find.java
│  └─ lru_cache.java
├─ leetcode/                   # LeetCode 题解代码
│  ├─ array/
│  ├─ hash/
│  ├─ two_pointers/
│  ├─ sliding_window/
│  ├─ linked_list/
│  ├─ stack_queue/
│  ├─ binary_tree/
│  ├─ backtracking/
│  ├─ binary_search/
│  ├─ greedy/
│  ├─ dp/
│  ├─ graph/
│  └─ design/
├─ notes/                      # 各专题总结
│  ├─ array.md
│  ├─ linked_list.md
│  ├─ tree.md
│  ├─ dp.md
│  └─ graph.md
└─ offer/                      # 剑指 Offer 题目索引或映射
   └─ README.md
```

## 分类规则

本仓库以 题型分类 为主，而不是单纯按平台分类。

这样做的原因是：
- 更符合面试复习方式
- 便于总结同类题目的通用解法
- 更容易建立自己的题型知识体系

例如：
- 数组 -> leetcode/array/
- 双指针 -> leetcode/two_pointers/
- 链表 -> leetcode/linked_list/
- 动态规划 -> leetcode/dp/
- 图论 -> leetcode/graph/

## 文件命名规范

题目代码文件统一采用以下命名方式：

```text
lc001_two_sum_01.java
lc015_three_sum_01.java
lc146_lru_cache_01.java
```

命名规则说明：

- lc 表示 LeetCode
- 后面保留题号，方便检索
- 末尾的标记表示这个第几次做，初始为01
- 题目名称使用小写 + 下划线
- 文件名尽量语义清晰，避免随意缩写


## 刷题记录说明

后续会逐步补充题目索引，记录以下信息：

- 题号
- 题目名称
- 题型
- 难度
- 是否高频
- 是否属于 Hot 100 / 剑指 Offer
- 当前完成状态
- 是否需要二刷 / 三刷

## 题目索引示例

| 题号  | 题目                  | 类型              | 难度     | 状态 | 标签            |
| --- | ------------------- | --------------- | ------ | -- | ------------- |
| 1   | Two Sum             | Hash            | Easy   | ✅  | Hot100        |
| 15  | Three Sum           | Two Pointers    | Medium | ✅  | Hot100        |
| 53  | Maximum Subarray    | DP / Prefix Sum | Medium | ✅  | Hot100, Offer |
| 146 | LRU Cache           | Design          | Medium | ✅  | 高频            |
| 206 | Reverse Linked List | Linked List     | Easy   | ✅  | Hot100, Offer |

## 计划覆盖的重点内容
1. LeetCode Hot 100

优先刷完 Hot 100 的高频题，并按专题整理。

2. 剑指 Offer

补齐国内常见面试题风格，重点覆盖：

- 数组 / 字符串
- 链表
- 树
- 栈与队列
- 动态规划
- 搜索与回溯

3. 面试高频专题

重点专题包括：

- 哈希表
- 双指针
- 滑动窗口
- 链表
- 栈 / 队列 / 单调栈
- 二叉树 / 二叉搜索树
- 回溯
- 二分查找
- 贪心
- 动态规划
- 图论
- 设计题

## 刷题原则

为了避免低效刷题，仓库会尽量遵循以下原则：

1. 按专题推进
    - 先建立题型认知，再扩展题量
2. 优先高频题
   - 先覆盖常考题，再做长尾题
3. 一题多刷
   - 经典题至少做到：理解思路 -> 独立写出 -> 限时完成
4. 重视模板沉淀
   - 不只追求 AC，更重视形成可复用的解题模板
5. 定期复盘
   - 对易错题、经典题、面试高频题进行二刷和总结

## 说明

这个仓库更偏向个人学习和面试准备，因此会更关注：

- 解法是否稳定
- 思路是否清晰
- 模板是否可复用
- 是否适合面试场景快速表达

不刻意追求花哨结构，重点是长期可维护、可复习、可迭代。