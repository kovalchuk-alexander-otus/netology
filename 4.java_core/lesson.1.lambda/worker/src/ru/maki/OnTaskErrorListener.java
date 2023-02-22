package ru.maki;

@FunctionalInterface
public interface OnTaskErrorListener {

    void onError(String result);
}
