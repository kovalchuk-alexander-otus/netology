package ru.maki;

public class Box<K,V> {
    K key;
    V value;

    public Box(K key, V value) {
        this.key   = key;
        this.value = value;

        System.out.println(this);
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Box{" +
                "key=" + key +
                ", keyType=" + key.getClass().getName() +
                ", value=" + value +
                ", valueType=" + value.getClass().getName() +
                '}';
    }
}
