package com.example;

import com.example.Threads.ReturnThread;
import com.example.Threads.Thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static int port = 56077;
    private static boolean stop = true;

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(port);
        while (stop) {
            Socket socket = server.accept();

            Thread the = new ReturnThread(socket);
            the.start();
        }
        server.close();
    }

    public static void setStop(boolean stop) {
        Main.stop = stop;
    }
}