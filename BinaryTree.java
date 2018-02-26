/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.bpit.service.impl;

/**
 * @author lixuemeng
 *         Created in 上午11:26 2018/2/24
 */
public class BinaryTree {

    private Node root;             // root of BST
    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree
        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    /**
     *   * 创建一个空的二叉树
     *
     */
    public BinaryTree() {
        root = null;
    }

    /**
     *   * 将数值输入构建二叉树
     *   * @param data 要输入的数值
     *
     */
    public void buildTree(int[] data) {
        for (int i = 0; i < data.length; i++) {
            insert(data[i]);
        }
    }

    /**
     *   * 递归的插入数值
     *   * @param data 要插入的数值
     *
     */
    public void insert(int data) {
        root = insert(root, data);
    }

    /**
     *   * 递归的插入数值
     *   * @param data 要插入的数值
     *
     */
    public int get(int data) {
        root = insert(root, data);
    }

    /**
     *   * 将数值插入到二叉树中，比当前结点小或等于当前结点的插在当前结点的左侧，比当前结点大的数插在当前结点的右侧，每次从根结点开始递归比较
     *   * @param node 当前的结点，就是根结点，只是每次根结点的左右子孙更新
     *   * @param data 要插入的数值
     *   * @return 新排好的二叉树
     *
     */
    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data <= node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }

    /**
     *   * 递归打印出二叉树
     *
     */
    public void printTree() {
        printTree(root);
    }

    /**
     *   * 从根结点开始遍历，从树的最高层叶子结点开始输出，从左至右
     *   * @param node 当前的结点
     *
     */
    private void printTree(Node node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.print(node.data + "  ");
        printTree(node.right);
    }
}

