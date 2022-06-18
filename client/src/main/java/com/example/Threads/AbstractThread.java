package com.example.Threads;

public abstract class AbstractThread extends java.lang.Thread {

    protected static boolean stop = true;

    @Override
    public void run() {
        while (stop) {
            loop();
        }
    }

    public static void setStop(boolean Istop) {
        stop = Istop;
    }

    public abstract void loop();

    @Override
    public synchronized void start() {
        super.start();
    }
}
