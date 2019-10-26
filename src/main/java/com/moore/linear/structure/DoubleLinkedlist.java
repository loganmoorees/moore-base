package com.moore.linear.structure;

import java.io.Serializable;

import static java.lang.System.out;

/**
 * 双向链表
 *
 * @author moore
 */
public class DoubleLinkedlist<E> implements List<E>, Serializable {

    private static final long serialVersionUID = -1088356969477439558L;

    int size;

    private Node<E> first;

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

    @Override
    public void add(E e) {
        Node<E> node = new Node<>(e, null, first);
        if (size == 0)
            first = node;
        else {
            first.pre = node;
            first = node;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        
    }

    @Override
    public E get(int index) {
        return null;
    }

    public void addIndex(E e, int index) {
        Node<E> node = new Node<>(e, null, null);
        Node<E> f = first;
        for (int i = 0; i < index; i++) {
            if (f.next != null) {
                f = f.next;
            }
        }
        Node<E> before = f.pre;
        before.next = node;
        node.pre = f.pre;
        f.pre = node;
        node.next = f;
        size++;
    }

    /**
     * 打印链表的值
     */
    public void showList() {
        Node<E> temp = this.first;
        out.print("{");
        while (temp.next != null) {
            out.print(temp.data + ", ");
            temp = temp.next;
        }
        out.println(temp.data + "}");
    }
}
