package ru.maki.Stack;

import ru.maki.Check;

public class SinglyStack<K> {
    protected Node<K> head; // указатель на обёртку с элементом, который надо вынуть следующим
    private boolean printLog = true;

    // добавление элемента в Стек
    public void push(K value) {
        if (this.printLog) {
            Check.printLNResult("Добавим " + value);
        }
        if (this.head == null) {
            this.head = new Node<>(value, null);
        } else {
            this.head = new Node<>(value, this.head);
        }
        if (this.printLog) {
            this.printMe();
        }
    }

    // изъятие элемента из Стека
    public K pop() {
        if (this.head == null) {
            Check.printLNResult("EMPTY");
            return null;
        } else {
            Check.printLNResult("Снимем со стека");
            K value = this.head.value;
            Check.printLNResult(value.toString());
            this.head = this.head.prev;
            this.printMe();
            return value;
        }
    }

    // смотрим содержимое Стека
    public void printMe() {
        if (this.head == null) {
            Check.printLNResult("EMPTY");
        } else {
            Node<K> node = this.head;
            while (node.prev != null) {
                Check.printResult(node.value.toString());
                Check.printResult(" -> ");
                node = node.prev;
            }
            Check.printLNResult(node.value.toString());
        }
    }

    // меняем порядок элементов в стеке на обратный
    public SinglyStack<K> reverse() {
        Check.printLNResult("Ревёрс!");
        if (this.head == null) {
            return this;
        }

        SinglyStack<K> reverseSinglyStack = new SinglyStack<>();
        reverseSinglyStack.printLog = false;
        reverse(reverseSinglyStack, this.head, this.head.prev);
        reverseSinglyStack.printLog = true;
        reverseSinglyStack.printMe();
        return reverseSinglyStack;
    }

    private void reverse(SinglyStack<K> singlyStack, Node<K> head, Node<K> prev) {
        singlyStack.push(head.value);
        if (prev != null) {
            reverse(singlyStack, prev, prev.prev);
        }
    }

    @Override
    public String toString() {
        return "Stack{" +
                "head=" + head +
                '}';
    }
}
