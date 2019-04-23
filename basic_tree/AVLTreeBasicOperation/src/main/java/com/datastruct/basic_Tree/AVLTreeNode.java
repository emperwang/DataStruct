package com.datastruct.basic_Tree;


/**
 * 树的节点
 * @param <T>
 */
public class AVLTreeNode<T> {
    private T value;
    private AVLTreeNode<T> leftChild;
    private AVLTreeNode<T> rightChild;
    private int height;
    AVLTreeNode(T value){
        this.value = value;
    }

    /**
     * 添加左子节点
     * @param value
     */
    public void addLeft(T value){
        AVLTreeNode<T> leftChild = new AVLTreeNode<T>(value);
        this.leftChild = leftChild;
    }

    /**
     * 添加右子节点
     * @param value
     */
    public void addRight(T value){
        AVLTreeNode<T> rightChild = new AVLTreeNode<>(value);
        this.rightChild = rightChild;
    }

    /**
     * 重载equals方法
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof AVLTreeNode)){
            return false;
        }
        return this.value.equals(((AVLTreeNode<?>)obj).value);
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

    public AVLTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AVLTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public AVLTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(AVLTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

