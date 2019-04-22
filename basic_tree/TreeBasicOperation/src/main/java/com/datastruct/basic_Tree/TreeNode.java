package com.datastruct.basic_Tree;


import lombok.Getter;

/**
 * 树的节点
 * @param <T>
 */
public class TreeNode<T> {
    private T value;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    TreeNode(T value){
        this.value = value;
    }

    /**
     * 添加左子节点
     * @param value
     */
    public void addLeft(T value){
        TreeNode<T> leftChild = new TreeNode<T>(value);
        this.leftChild = leftChild;
    }

    /**
     * 添加右子节点
     * @param value
     */
    public void addRight(T value){
        TreeNode<T> rightChild = new TreeNode<>(value);
        this.rightChild = rightChild;
    }

    /**
     * 重载equals方法
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof TreeNode)){
            return false;
        }
        return this.value.equals(((TreeNode<?>)obj).value);
    }

    /**
     * 重载hashcode方法
     * @return
     */
    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public String toString() {
        return this.value==null?"":this.value.toString();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}

