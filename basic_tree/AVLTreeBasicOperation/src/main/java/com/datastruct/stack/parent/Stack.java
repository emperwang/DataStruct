package com.datastruct.stack.parent;

/**
 * 栈接口抽象类型
 * @param <T>
 */
public interface Stack<T> {

    /**
     * 栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * data元素入栈
     * @param data
     */
    void push(T data);

    /**
     * 返回栈顶元素，未出栈
     * @return
     */
    T peek();

    /**
     * 出栈，返回栈顶元素，同时从栈中移除元素
     * @return
     */
    T pop();
}
