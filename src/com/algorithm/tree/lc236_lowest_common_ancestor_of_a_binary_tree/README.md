# LC236. Lowest Common Ancestor of a Binary Tree

## 题目
- 题号：236
- 题目名称：Lowest Common Ancestor of a Binary Tree
- 链接：https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

## 解题思路
- 使用哈希表存储每个节点的父节点
- 遍历第一个节点的所有祖先节点并记录
- 遍历第二个节点的祖先节点，找到第一个在记录中的节点即为最近公共祖先

## 关键点
- 父节点记录与祖先节点查找
- 哈希表和集合的配合使用

## 复杂度分析
- 时间复杂度：O(n)，需要遍历整棵树
- 空间复杂度：O(n)，哈希表和集合需要存储所有节点信息

## 易错点
- 根节点的处理
- 空节点的边界条件

## 复盘/优化
- 可以使用递归方法实现更简洁的代码
- 递归方法不需要额外空间存储父节点信息
