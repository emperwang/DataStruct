package com.datastruct.basic_Tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树基本操作方法
 */
public class BasicOperation {

    /**
     * 返回树中的节点数量
     * @param root
     * @param <T>
     * @return
     */
    public static <T> int getTreeNum(TreeNode<T> root){
        if(root == null){
            return 0;
        }

        return getTreeNum(root.getLeftChild())+getTreeNum(root.getRightChild())+1;
    }

    /**
     *  返回树的深度
     * @param root
     * @param <T>
     * @return
     */
    public static <T> int getTreeDepth(TreeNode<T> root){
        if(root == null){
            return 0;
        }

        int leftDepth = getTreeDepth(root.getLeftChild())+1;
        int rightDepth= getTreeDepth(root.getRightChild())+1;
        return Math.max(leftDepth,rightDepth);
    }

    /**
     * 前序遍历树
     * @param root
     * @param <T>
     */
    public static <T> void preOrderTravel(TreeNode<T> root){
        if(root == null){
            return;
        }
        visitNode(root);
        preOrderTravel(root.getLeftChild());
        preOrderTravel(root.getRightChild());
    }

    /**
     * 中序遍历
     * @param root
     * @param <T>
     */
    public static <T> void  midOrderTravel(TreeNode<T> root){
        if(root == null){
            return;
        }
        midOrderTravel(root.getLeftChild());
        visitNode(root);
        midOrderTravel(root.getRightChild());
    }

    /**
     * 后序遍历
     * @param root
     * @param <T>
     */
    public static <T> void backOrderTravel(TreeNode<T> root){
        if(root == null){
            return;
        }
        backOrderTravel(root.getLeftChild());
        backOrderTravel(root.getRightChild());
        visitNode(root);
    }
    /**
     * 打印节点的值
     * @param root
     * @param <T>
     */
    private static <T> void visitNode(TreeNode<T> root) {
        System.out.println(root.getValue());
    }

    /**
     * 分层遍历
     * @param root
     * @param <T>
     */
    public static <T> void levelTravel(TreeNode<T> root){
        Queue<TreeNode<T>> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode<T> temp = q.poll();
            visitNode(temp);
            if(temp.getLeftChild() != null){
                q.offer(temp.getLeftChild());
            }
            if(temp.getRightChild() != null){
                q.offer(temp.getRightChild());
            }
        }
    }

    /**
     *  求第k层节点个数
     * @param root 树的根节点
     * @param k   第几层
     * @param <T>
     * @return
     */
    public static <T> int getNumForLevel(TreeNode<T> root,int k){
        if(root == null || k < 1){
            return 0;
        }
        if (k == 1){
            return 1;
        }
        int leftNum = getNumForLevel(root.getLeftChild(),k-1);
        int rightNum = getNumForLevel(root.getRightChild(),k-1);
        return leftNum+rightNum;
    }

    /**
     * 获取二叉树中叶子节点的个数
     * @param root
     * @param <T>
     * @return
     */
    public static <T> int getLeafNum(TreeNode<T> root){
        if(root == null){
            return 0;
        }
        if (root.getLeftChild() == null && root.getRightChild() == null){
            return 1;
        }
        int leftNum = getLeafNum(root.getLeftChild());
        int rightNum = getLeafNum(root.getRightChild());
        return leftNum+rightNum;
    }

    /**
     * 交换左右子树
     * @param root
     * @param <T>
     * @return
     */
    public static <T> TreeNode<T> exchange(TreeNode<T> root){
        if(root == null){
            return null;
        }
        TreeNode<T> left = exchange(root.getLeftChild());
        TreeNode<T> right = exchange(root.getRightChild());
        root.setLeftChild(right);
        root.setRightChild(left);
        return root;
    }

    /**
     * 判断node是否是root的子节点
     * @param root
     * @param node
     * @param <T>
     * @return
     */
    public static <T> boolean nodeIsChild(TreeNode<T> root,TreeNode<T> node){
        if (root == null || node == null){
            return false;
        }
        if (root == node){
            return true;
        }
        boolean isFind = nodeIsChild(root.getLeftChild(),node);
        if(!isFind){
            isFind = nodeIsChild(root.getRightChild(),node);
        }
        return isFind;
    }

    /**
     * 比较两颗树是否相等
     * @param node1
     * @param node2
     * @param <T>
     * @return
     */
    public static <T> boolean equalsTree(TreeNode<T> node1,TreeNode<T> node2){
        if(node1 == null && node2 == null){
            return true;
        }else if(node1 == null || node2 == null){
            return false;
        }
        boolean isEqual = node1.getValue().equals(node2.getValue());
        boolean isLeftEqual = equalsTree(node1.getLeftChild(),node2.getLeftChild());
        boolean isRightEqual = equalsTree(node1.getRightChild(),node2.getRightChild());
        return isEqual && isLeftEqual && isRightEqual;
    }

    /**
     * 根据前序遍历的结果和中序遍历的结果 重新构建二叉树
     * @param pre 前序遍历结果
     * @param mid 中序遍历结果
     * @param <T>
     * @return
     */
    public static <T> TreeNode<T> getTreeFromPreAndMid(List<T> pre,List<T> mid){
        if(pre == null || mid == null || pre.size() == 0 || mid.size() == 0){
            return null;
        }
        /**
         * 前序第一个就是root节点,如果前序结果只有一个,那么表示就一个root节点
         */
        if(pre.size() == 1){
            return new TreeNode<>(pre.get(0));
        }
        //创建root节点
        TreeNode<T> root = new TreeNode<>(pre.get(0));
        /**
         * 在中序中根节点左边是左子节点   右边是右子节点
         */
        //在中序中找出根节点所在的位置
        int index=0;
        while (!(mid.get(index++).equals(pre.get(0)))){

        }
        //构建左子树的前序
        List<T> preLeft = new ArrayList<>(index-1);
        //左子树的中序
        List<T> midLeft = new ArrayList<>(index-1);
        for(int i=1;i<index;i++){
            preLeft.add(pre.get(i));
        }
        for(int i=0;i<index-1;i++){
            midLeft.add(mid.get(i));
        }

        //重建左子树
        root.setLeftChild(getTreeFromPreAndMid(preLeft,midLeft));
        //右子树前序
        //List<T> preRight = new ArrayList<>(pre.size()-(index-1));
        List<T> preRight = new ArrayList<>();
        //右子树中序
        //List<T> midRight = new ArrayList<>(pre.size()-(index-1));
        List<T> midRight = new ArrayList<>();
        for (int i=0;i<pre.size()-index;i++){
            preRight.add(pre.get(index+i));
        }
        for(int i=0;i<pre.size()-index;i++){
            midRight.add(mid.get(index+i));
        }
        //重建右子树
        root.setRightChild(getTreeFromPreAndMid(preRight,midRight));
        return root;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.addLeft(2);
        root.addRight(3);
        root.getLeftChild().addLeft(4);
        root.getLeftChild().addRight(5);
        System.out.println("中序遍历");
        BasicOperation.midOrderTravel(root);
        System.out.println("前序遍历");
        BasicOperation.preOrderTravel(root);
        System.out.println("后序遍历");
        BasicOperation.backOrderTravel(root);
        System.out.println("层次遍历");
        BasicOperation.levelTravel(root);
        System.out.println("树的深度:"+BasicOperation.getTreeDepth(root));
        System.out.println("树的叶子个数:"+BasicOperation.getLeafNum(root));
        System.out.println("树的节点个数:"+BasicOperation.getTreeNum(root));
        System.out.println("第2层的节点个数为:"+BasicOperation.getNumForLevel(root,3));
        //TreeNode<Integer> exchange = BasicOperation.exchange(root);
        //preOrderTravel(exchange);
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        pre.add(2);
        pre.add(4);
        pre.add(5);
        pre.add(3);
        List<Integer> mid = new ArrayList<>();
        mid.add(4);
        mid.add(2);
        mid.add(5);
        mid.add(1);
        mid.add(3);
        TreeNode<Integer> treeFromPreAndMid = BasicOperation.getTreeFromPreAndMid(pre, mid);
        System.out.println("前序和中序构建树:");
        BasicOperation.preOrderTravel(treeFromPreAndMid);
        System.out.println("构建树比较:");
        System.out.println(BasicOperation.equalsTree(root,treeFromPreAndMid));
    }
}
