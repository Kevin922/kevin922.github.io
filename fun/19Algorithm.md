## Tree

``` Java
public class TreeNode {
  public int val;
  public TreeNode left, right;
  
  public TreeNode(int val) {
    this.val = val;
    left = null;
    right = null;
  }
}
```



## Fibonacci

拓展成一颗树。



## 二叉树

从根的角度出发：前中后顺序遍历

``` Java
public class OrderIterator {
  List<int> tree = new ArrayList<>();
  
  public void preorder(TreeNode root) {
    tree.add(root.val);
    preorder(root.left);
    preorder(root.right);
  }
  
  public void inorder(TreeNode root) {
    preorder(root.left);
    tree.add(root.val);
    preorder(root.right);
  }
  
  public void preorder(TreeNode root) {
    preorder(root.left);
    preorder(root.right);
    tree.add(root.val);
  }
}
```



## ？？树的计算公式



## ？？BFS



## ？？ DFS



## 二叉搜索树

1. 左子树**所有节点**均小于根节点
2. 右子树**所有节点**均大于根节点
3. 以此类推：左、右子树也分别为二叉搜索树。
4. 中序遍历 - 升序遍历。

### ？？ 查找

### ？？ 插入

### ？？ 删除

