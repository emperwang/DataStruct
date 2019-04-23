package com.datastruct.BinaryTree.parent;

import com.datastruct.BinaryTree.BinaryNode;

/**
 * 抽象树的接口
 * @param <T>
 */
public interface Tree<T extends Comparable> {
    /**
     * 判断树是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 二叉树的节点个数
     * @return
     */
    int size();

    /**
     *  返回二叉树的高度或深度，即节点的最大层数
     * @return
     */
    int height();

    /**
     * 前序遍历
     * @return
     */
    String preOrder();

    /**
     * 中序遍历
     * @return
     */
    String midOrder();

    /**
     * 后续遍历
     * @return
     */
    String postOrder();

    /**
     * 水平遍历
     * @return
     */
    String levelOrder();

    /**
     * 插入节点
     * @param data
     */
    void insert(T data);

    /**
     * 删除节点
     * @param data
     */
    void remove(T data);

    /**
     * 查找最小值
     * @return
     */
    T findMin();

    /**
     * 查找最大值
     * @return
     */
    T findMax();

    /**
     * 根据值查找节点
     * @param data
     * @return
     */
    BinaryNode findNode(T data);

    /**
     * 查找是否包含某个值
     * @param data
     * @return
     * @throws Exception
     */
    boolean contains(T data) throws Exception;

    /**
     * 清空树
     */
    void clean();

}
