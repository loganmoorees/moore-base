package com.moore.linear.structure;

import java.io.Serializable;

import static java.lang.System.out;

/**
 * 单向链表Java实现
 *
 * @author moore
 * @date 2019-09-03
 */
public class SingleLinkedList<E> implements List<E>, Serializable {

    int size;
    private Node<E> node;
    private static final long serialVersionUID = 1L;

    private class Node<E> {

        /**
         * 每个节点的数据
         */
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
        }
    }

    /**
     * 添加数据
     *
     * @param e
     */
    public void add(E e) {
        Node<E> newNode = new Node<E>(e, null);
        if (size == 0)
            this.node = newNode;
        else {
            Node<E> temp = this.node;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    /**
     * 头结点插入
     *
     * @param e
     */
    public void addHead(E e) {
        Node<E> newNode = new Node<>(e, node);
        node = newNode;
    }

    /**
     * 指定位置进行添加
     *
     * @param e
     * @param index
     */
    public void addIndex(E e, int index) {
        checkIndex(index);
        Node<E> newNode = new Node<>(e, null);
        Node<E> beforeNode = node;
        Node<E> nextNode = node;
        for (int i = 0; i < index; i++) {
            if (node.next != null) {
                beforeNode = node.next;
                nextNode = node.next.next;
            }
        }
        newNode.next = nextNode;
        beforeNode.next = newNode;
        size++;
    }

    /**
     * 获取指定节点
     *
     * @param index
     *
     * @return
     */
    public E get(int index) {
        Node<E> x = node;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x.data;
    }

    /**
     * 删除链表
     *
     * @param index
     *
     * @return
     */
    public void remove(int index) {
        checkIndex(index);
        Node<E> current = node, pre = new Node(), next = new Node();
        if (index > 0) {
            for (int i = 0; i < index; i++) {
                pre = current;
                current = current.next;
                next = current.next;
            }
            pre.next = next;
        } else {
            node = node.next;
        }
        size--;
    }

    /**
     * 打印链表的值
     */
    public void showList() {
        Node<E> temp = this.node;
        out.print("{");
        while (temp.next != null) {
            out.print(temp.data + ", ");
            temp = temp.next;
        }
        out.println(temp.data + "}");
    }

    /**
     * 获取链表长度
     *
     * @return
     */
    public int length() {
        return size;
    }

    /**
     * 检查链表下标
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}