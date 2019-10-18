package com.moore.linear.structure;

/**
 * 双向链表
 *
 * @author moore
 */
public class DoubleLinkedlist {



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
}
