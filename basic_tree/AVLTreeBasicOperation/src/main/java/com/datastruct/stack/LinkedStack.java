package com.datastruct.stack;

import com.datastruct.stack.parent.Stack;

import java.io.Serializable;

public class LinkedStack<T> implements Serializable,Stack<T> {

    private Node<T> top;
    private int size;
    public LinkedStack(){
        this.top = new Node<>();
    }
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.top==null || top.data == null;
    }

    /**
     * 元素data入栈
     * @param data
     */
    @Override
    public void push(T data) {
        if (data == null){
            throw new RuntimeException("data can not be null");
        }
        if (this.top == null){
            this.top = new Node<>(data);
        }else if (this.top.data == null){
            this.top.data = data;
        }else{
            Node<T> p = new Node<>(data, this.top);
            top = p;
        }
        size++;
    }

    /**
     * 取出栈顶元素，但并不移除
     * @return
     */
    @Override
    public T peek() {
        if (isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        return top.data;
    }


    @Override
    public T pop() {
        if (isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("栈深度:"+stack.size());
        int size = stack.size;
        for (int i=0; i<size;i++){
            System.out.println("stack->pop:"+stack.pop());
        }
    }
}
