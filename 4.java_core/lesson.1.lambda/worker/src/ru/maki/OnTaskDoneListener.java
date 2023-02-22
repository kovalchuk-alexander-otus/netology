package ru.maki;

@FunctionalInterface
public interface OnTaskDoneListener {

    void onDone(String result);
}
