package com.datastruct.BinaryTree;

import java.io.Serializable;

/**
 *  二叉树节点
 */
public class BinaryNode<T extends Comparable> implements Serializable {

    public BinaryNode<T> left;
    public BinaryNode<T> right;
    public T data;

    public BinaryNode( T data,BinaryNode<T> left, BinaryNode<T> right) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public BinaryNode(T data) {
        this(data,null,null);
    }

    /**
     * 判断是否为叶子节点
     * @return
     */
    public boolean isLeaf(){
        return this.left==null&&this.right==null;
    }
}
