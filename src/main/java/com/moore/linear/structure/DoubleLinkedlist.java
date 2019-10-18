package com.moore.linear.structure;

import java.io.Serializable;

/**
 * 双向链表
 *
 * @author moore
 */
public class DoubleLinkedlist<E> implements List<E>, Serializable {

    private static final long serialVersionUID = -1088356969477439558L;

    int size;

    private Node<E> node;

    private class Node<E> {
        private E data;

        private Node<E> pre;

        private Node<E> next;

        public Node() {
        }

        public Node(E data, Node<E> pre, Node<E> next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }

    public void add(E e) {
        
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public E get(int index) {
        return null;
    }
}
