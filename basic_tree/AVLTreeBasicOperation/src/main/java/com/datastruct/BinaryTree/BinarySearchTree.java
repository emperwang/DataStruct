package com.datastruct.BinaryTree;

import com.datastruct.BinaryTree.parent.Tree;
import com.datastruct.stack.LinkedStack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable>  implements Tree<T> {
    protected BinaryNode<T> root;

    public BinarySearchTree(){
        this.root = null;
    }
    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public int size() {
        return size(root);
    }

    /**
     * 递归实现: 定义根节点root后，再用subtree实现递归
     * @param subTree
     * @return
     */
    private int size(BinaryNode<T> subTree){
        if (subTree == null){
            return 0;
        }else {
            //对比汉诺塔:H(n) = H(n-1) + 1 + H(n-1)
            return size(subTree.left) + 1 + size(subTree.right);
        }
    }

    /**
     * 计算二叉树的高度
     * @return
     */
    @Override
    public int height() {
        return height(root);
    }

    /**
     * 递归实现
     * @param subtree
     * @return
     */
    private int height(BinaryNode<T> subtree){
        if (subtree == null){
            return 0;
        }else{
            int left = height(subtree.left);
            int right = height(subtree.right);
            return (left>right)?(left+1):(right+1);
        }
    }

    /**
     * 前序遍历
     * @return
     */
    @Override
    public String preOrder() {
        String preOrder = preOrder(root);
        if (preOrder.length() > 0){
            //截取掉最后的逗号
            preOrder = preOrder.substring(0,preOrder.length()-1);
        }
        return preOrder;
    }

    /**
     * 前序遍历
     * @param subtree
     * @return
     */
    private String preOrder(BinaryNode<T> subtree){
        //定义一个容器，存储遍历的值
        StringBuilder builder = new StringBuilder();
        if(subtree != null){
            builder.append(subtree.data).append(",");
            //遍历左子树
            builder.append(preOrder(subtree.left));
            //遍历右子树
            builder.append(preOrder(subtree.right));
        }
        return builder.toString();
    }
    private void preOrder2(BinaryNode<T> subtree){
        if (subtree == null){
            return ;
        }
        //先访问根节点
        visitNode(subtree);
        //遍历左子树
        preOrder2(subtree.left);
        //遍历右子树
        preOrder2(subtree.right);
    }

    private void visitNode(BinaryNode<T> node){
        System.out.println(node.data);
    }

    /**
     * 中序遍历
     * @return
     */
    @Override
    public String midOrder() {
        String midOrder = midOrder(root);
        if(midOrder.length()>0){
            //截取掉最后的逗号
            midOrder = midOrder.substring(0,midOrder.length()-1);
        }
        return midOrder;
    }

    /**
     * 中序遍历的递归实现
     * @param subtree
     * @return
     */
    private String midOrder(BinaryNode<T> subtree){
        //存储遍历的值
        StringBuilder builder = new StringBuilder();
        if (subtree != null){
            //遍历左子树
            builder.append(midOrder(subtree.left));
            //访问根节点
            builder.append(subtree.data).append(",");
            //遍历右子树
            builder.append(midOrder(subtree.right));
        }
        return builder.toString();
    }

    private void midOrder2(BinaryNode<T> subtree){
        if (subtree == null){
            return;
        }
        //遍历左子树
        midOrder2(subtree.left);
        //访问根节点
        visitNode(subtree);
        //遍历右子树
        midOrder2(subtree.right);
    }

    /**
     * 后续遍历
     * @return
     */
    @Override
    public String postOrder() {
        String order = postOrder(root);
        if (order.length() > 0){
            order = order.substring(0,order.length()-1);
        }
        return order.toString();
    }

    /**
     * 后续遍历的递归实现
     * @return
     */
    private String postOrder(BinaryNode<T> subtree){
        StringBuilder builder = new StringBuilder();
        if(subtree != null){
            //访问左子树
            builder.append(postOrder(subtree.left));
            //访问右子树
            builder.append(postOrder(subtree.right));
            //访问根节点
            builder.append(subtree.data).append(",");
        }
        return builder.toString();
    }

    /**
     * 先序遍历非递归实现
     * @return
     */
    public String preOrderTraverse(){
        StringBuffer buffer = new StringBuffer();
        //构建用于存放节点的栈
       LinkedStack<BinaryNode<T>> stack =  new LinkedStack<>();
       BinaryNode<T>  p = this.root;
       while (p != null || !stack.isEmpty()){
           if (p != null){
               //访问该节点
               buffer.append(p.data+",");
               //将已经访问的节点入栈
               stack.push(p);
               //继续访问其左节点
               p = p.left;
           }else{
               //若p==null，栈不为空，则说明已沿左子树访问完一条路径
               //从栈中弹出栈顶节点，并访问其右节点
               p = stack.pop();
               p = p.right;
           }
       }
       //去掉最后的逗号
        if (buffer.length() > 0) {
            return buffer.toString().substring(0, buffer.length() - 1);
        }else{
           return buffer.toString();
        }
    }

    /**
     * 非递归的中序遍历
     * @return
     */
    public String midOrderTraverse(){
        StringBuffer buffer = new StringBuffer();

        //构建用于存放节点的栈
        LinkedStack<BinaryNode<T>> stack = new LinkedStack<>();
        BinaryNode<T> p = this.root;
        while (p != null || !stack.isEmpty()){
            while (p != null){
                //把左节点都入栈,直到左节点为null
                stack.push(p);
                p = p.left;
            }
            //如果栈不为空，因为前面左孩子已经全部入栈
            if (!stack.isEmpty()){
                p = stack.pop();
                //访问p节点
                buffer.append(p.data+",");
                //访问p节点的右节点
                p = p.right;
            }
        }
        if (buffer.length() > 0){
            return buffer.toString().substring(0,buffer.length()-1);
        }else {
            return buffer.toString();
        }
    }

    /**
     * 非递归的后续遍历
     * @return
     */
    public String postOrderTaverse(){
        StringBuffer buffer = new StringBuffer();

        //构建存储节点的栈
        LinkedStack<BinaryNode<T>> stack = new LinkedStack<>();
        BinaryNode<T> currentNode = this.root;
        BinaryNode<T> prev = this.root;

        while (currentNode != null || !stack.isEmpty()){
            //把左子树介入栈
            while (currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            //开始访问当前节点的父节点和右节点
            if(!stack.isEmpty()){
                //获取右节点
                BinaryNode<T> temp = stack.peek().right;
                //先判断是否有右节点或者右节点是否已经访问过
                if (temp == null || temp == prev){//没有右节点||右节点被访问过
                    //如果没有右节点或者右节点被访问过，则弹出父节点并访问
                    currentNode = stack.pop();
                    //访问
                    buffer.append(currentNode.data+",");
                    //记录已经访问过的节点
                    prev = currentNode;
                    currentNode = null;
                }else {
                    //有右节点，则开始遍历右节点
                    currentNode = temp;
                }
            }
        }
        if (buffer.length() > 0){
            return buffer.toString().substring(0,buffer.length()-1);
        }else {
            return buffer.toString();
        }
    }

    @Override
    public String levelOrder() {
        //存放需要遍历的节点，左节点一定要优先遍历
        LinkedList<BinaryNode<T>> lists = new LinkedList<>();
        StringBuffer buffer = new StringBuffer();
        BinaryNode<T> p = this.root;
        while (p != null){
            //记录经过的节点
            buffer.append(p.data+" ");
            //先按层次遍历节点，左节点一定再右节点之前访问
            if (p.left != null){
                lists.add(p.left);
            }
            if (p.right != null){
                lists.add(p.right);
            }
            //访问下一个节点
             p = lists.poll();
        }
        return buffer.toString();
    }

    @Override
    public void insert(T data) {
        if (data == null){
            throw new RuntimeException("data can not be null!");
        }
       root =  insert(data,this.root);
    }

    /**
     * 把输入data插入到树中
     * @param data
     * @param p
     * @return
     */
    private BinaryNode<T> insert(T data,BinaryNode<T> p){
        if (p == null){
            p = new BinaryNode<>(data,null,null);
        }
        int result = data.compareTo(p.data);
        if (result < 0 ) { // 左
            p.left = insert(data,p.left);
        }else if (result > 0) { //右
            p.right = insert(data,p.right);
        }else{ // 相等
            ;   //表示已经右一个相同的节点，不需要进行插入
        }
        return p;
    }

    /**
     * 删除一个节点
     * @param data
     */
    @Override
    public void remove(T data) {
        if (data == null){
            throw new RuntimeException("data can not be null!");
        }
        root = remove(data,root);
    }

    /**
     * 删除节点，三种情况:
     * 1.删除叶子节点  也就是没有子节点
     * 2.删除拥有一个子节点的节点
     * 3.删除拥有两个子节点的节点
     * @param data
     * @param p
     * @return
     */
    private BinaryNode<T> remove(T data,BinaryNode<T> p){
        if (p == null){
            return p;
        }
        int result = data.compareTo(p.data);
        if (result < 0){  //左边查找删除节点
            p.left = remove(data,p.left);
        }else if (result > 0){ //右边查找删除节点
            p.right = remove(data,p.right);
        }else if (p.left!=null && p.right != null){//已找到节点并判断是否右两个子节点
            //中继替换，找到右子树中最小的元素并替换需要删除的元素值
            p.data = findMin(p.right).data;
            //溢出用于替换的节点
            p.right = remove(p.data,p.right);
        }else {// 只有一个节点
            p = (p.left == null)?p.right:p.left;
        }
        return p;
    }

    /**
     * 非递归删除
     * @return
     */
    public boolean removeUnrecure(T data){
        if (data == null){
            throw new RuntimeException("data can not be null");
        }
        //从根节点开始查找
        BinaryNode<T> current = this.root;
        //记录父节点
        BinaryNode<T> parent = this.root;
        //判断左右节点的flag
        boolean isLeft = true;
        //找到我要删除的节点
        while (data.compareTo(current.data) != 0){
            //更新父节点
            parent = current;
            int result = data.compareTo(current.data);
            if (result < 0 ){
                isLeft = true;
                current = current.left;
            }else if (result > 0){
                isLeft = false;
                current = current.right;
            }
            //如果没有找到，返回null
            if (current == null){
                return false;
            }
        }

        //到这里 说明已经找到
        //删除叶子节点
        if (current.left == null && current.right == null){
            if (current == this.root){
                this.root = null;
            }else if (isLeft){
                parent.left = null;
            }else {
                parent.right = null;
            }
        }
        //删除带有一个子节点的节点
        else if (current.left == null){
            if (current == this.root){
                this.root = current.right;
            }else if (isLeft) {//current为parent的左节点
                parent.left = current.right;
            }else { //current 为parent的右节点
                parent.right = current.right;
            }
        }
        //删除带有一个子节点的节点
        else if (current.right == null){
            if (current == this.root){
                this.root = current.left;
            }else if (isLeft){ //current 是parent的左节点
                parent.left = current.left;
            }else{//current 是parent的右节点
                parent.right = current.left;
            }
        }
        //删除带有两个子节点的节点
        else{
            //找到当前要删除节点current右子树中最小值
            BinaryNode<T> successor = findSuccessor(current);
            if (current == root){
                this.root = successor;
            }else if (isLeft){
                parent.left = successor;
            }else{
                parent.right = successor;
            }
            //把当前要删除的节点的左子节点赋值到successor；
            successor.left = current.left;
        }
        return true;
    }

    /**
     * 查找中继节点 ,右子树最小值节点
     * @return
     */
    public BinaryNode<T> findSuccessor(BinaryNode<T> delNode){
        BinaryNode<T> successor = delNode;
        BinaryNode<T> successorParent = delNode;
        BinaryNode<T> current = delNode.right;
        //不断查找左节点，直到为空，则successor最小值节点
        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        //如果要删除节点的右子节与successor不等，则执行下面操作
        //相等，则说明删除节点
        if (successor != delNode.right){
            successorParent.left = successor.right;
            //把中继节点的右节点指向当前要删除节点的右节点
            successor.right=delNode.right;
        }
        return successor;
    }
    @Override
    public T findMin() {
        if (isEmpty()){
            throw new RuntimeException("BinarySearchTree is empty");
        }
        return findMin(root).data;
    }

    /**
     * 寻找最小值
     * @param p
     * @return
     */
    private BinaryNode<T> findMin(BinaryNode<T> p){
        if (p == null){
            return null;
        }else if (p.left == null){
            return p;
        }
        return findMin(p.left);
    }

    /**
     * 寻找最大值
     * @return
     */
    @Override
    public T findMax() {
        if (isEmpty()){
            throw new RuntimeException("BinarySearchTree is empty");
        }
        return findMax(root).data;
    }
    private BinaryNode<T> findMax(BinaryNode<T> p){
        if (p == null){
            return null;
        }else if (p.right == null){
            return p;
        }
        return findMax(p.right);
    }

    /**
     *根据data查找node
     * @param data
     * @return
     */
    @Override
    public BinaryNode findNode(T data) {
        return findNode(data,root);
    }

    private BinaryNode<T> findNode(T data,BinaryNode<T> p){
        if (p == null || data == null){
            return null;
        }
        int result = data.compareTo(p.data);
        if (result < 0){ //从左子树查找
            return findNode(data,p.left);
        }else if (result > 0){//从右子树查找
            return findNode(data,p.right);
        }else{
            return p;  //找到
        }
    }
    /**
     * 是否包含data
     * @param data
     * @return
     * @throws Exception
     */
    @Override
    public boolean contains(T data) throws Exception {
        return contains(data,root);
    }

    private boolean contains(T data,BinaryNode<T> p){
        if (data == null || p==null){
            return false;
        }
        int result = data.compareTo(p.data);
        if (result < 0){ //小于 则从左子树查找
            return contains(data,p.left);
        }else if (result >0){
            //大于 则从右子树查找
            return contains(data,p.right);
        }else{
            return true;  //找到
        }
    }

    @Override
    public void clean() {
        root = null;
    }

    /**
     * 将树转换成字符串打印在控制台上
     */
    public void print(){
        LinkedList<BinaryNode<T>> tree = getCompleteBinaryTree();
        //获取树的深度
        int depth = height();
        Iterator<BinaryNode<T>> iterator = tree.iterator();
        int maxPosition = 1;
        for (int floor =1;floor<=depth;floor++){
            maxPosition = 1<<(floor-1);
            //输出打印空白符
            pringBLank((1<<(depth-floor))-1);

            //开始打印元素
            for(int position=0;position<maxPosition;position++){
                if (iterator.hasNext()){
                    BinaryNode<T> next = iterator.next();
                    if (next!=null){
                        System.out.println(next.data);
                    }else {
                        System.out.println(" ");
                    }
                    //再次打印空白符
                    pringBLank((1<<(depth-floor+1))-1);
                }
            }
            System.out.println();
        }
    }

    public void pringBLank(int length){
        while (length-- >0){
            System.out.print(" ");
        }
    }
    /**
     * 将二叉树用空节点补充完全二叉树,并以水平形式返回
     * @return
     */
    public LinkedList<BinaryNode<T>> getCompleteBinaryTree(){
        Queue<BinaryNode<T>> queue = new LinkedList<>();
        //存放完全二叉树
        LinkedList<BinaryNode<T>> tree = new LinkedList<>();
        queue.add(root);
        BinaryNode<T> empty = null;
        int nodeCount = 1; //队列中非空节点数
        while (queue.size() >0  && nodeCount >0){
            BinaryNode<T> node = queue.remove();
            if (node!=null){
                nodeCount--;
                tree.add(node);
                BinaryNode<T> left = node.left;
                BinaryNode<T> right = node.right;
                if (left == null){
                    queue.add(empty);
                }else {
                    queue.add(left);
                    nodeCount++;
                }
                if (right == null){
                    queue.add(empty);
                }else {
                    queue.add(right);
                    nodeCount++;
                }
            }else {
                tree.add(empty);
                queue.add(empty);
                queue.add(empty);
            }
        }
        return tree;
    }
    public static void main(String[] args) {
        BinarySearchTree<Comparable> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(40);
        tree.insert(2);
        tree.insert(90);
        tree.insert(11);
        tree.insert(9);
        tree.insert(30);
        tree.print();
        System.out.println(tree.preOrder());
/*        System.out.println(tree.preOrderTraverse());
        System.out.println(tree.midOrder());
        System.out.println(tree.midOrderTraverse());
        System.out.println(tree.postOrder());
        System.out.println(tree.postOrderTaverse());*/
        System.out.println(tree.levelOrder());
/*        System.out.println(tree.findMax());
        System.out.println(tree.findMin());
        System.out.println(tree.findNode(40));*/
    }
}
