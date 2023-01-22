package ru.maki.Stack;

public class Node<K> {
    protected final K value; // значение в обёртке
    protected final Node<K> prev; // элемент, ниже в стеке

    public Node(K value, Node<K> prev) {
        this.value = value;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", prev=" + prev +
                '}';
    }
}
