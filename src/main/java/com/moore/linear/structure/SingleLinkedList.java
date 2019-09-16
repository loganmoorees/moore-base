package com.moore.linear.structure;

import java.io.Serializable;

/**
 * 单向链表Java实现
 *
 * @author moore
 * @date 2019-09-03
 */
public class SingleLinkedList<E> implements Serializable {

    int size;
    private Node<E> node;
    private static final long serialVersionUID = 1L;

    private class Node<E> {

        /**
         * 每个节点的数据
         */
        private E data;

        /**
         * 每个节点指向下一个节点的连接
         */
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

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

    public E get(int index) {
        Node<E> x = node;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x.data;
    }

    private void checkIndex(int index) {
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}