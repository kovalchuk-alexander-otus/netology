package ru.maki;

public class Box<T> {
    T obj;

    public Box(T obj) {
        this.obj = obj;
        System.out.println(this);
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    @Override
    public String toString() {
        return "Box{" +
                "obj=" + obj +
                "; objType=" + obj.getClass().getName() +
                '}';
    }
}
