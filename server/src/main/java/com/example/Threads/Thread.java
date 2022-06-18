package com.example.Threads;

public abstract class Thread extends java.lang.Thread {

    protected boolean stop = true;

    @Override
    public void run() {
        while (stop) {
            loop();
        }
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public abstract void loop();

    @Override
    public synchronized void start() {
        super.start();
    }
}
