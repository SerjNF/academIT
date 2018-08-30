package ru.inbox.foreman.treeNode;

/**
 * Класс узла дерева
 *
 * @param <T> тип данных;
 * @author SergeyNF
 */
public class TreeNode<T> {
    private T data;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode() {

    }

    public TreeNode(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        //noinspection unchecked
        TreeNode<T> t = (TreeNode<T>) obj;
        return data.equals(t.data) && left == t.left && right == t.right;
    }
}
