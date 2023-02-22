package ru.maki;

public class Worker {
    private final OnTaskDoneListener callback;
    private final OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33){
                this.errorCallback.onError("Task " + i + " is failed");
                continue;
            }
            this.callback.onDone("Task " + i + " is done");
        }
    }
}
